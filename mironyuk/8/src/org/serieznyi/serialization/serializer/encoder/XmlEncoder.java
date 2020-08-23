package org.serieznyi.serialization.serializer.encoder;

import org.serieznyi.serialization.serializer.Encoder;
import org.serieznyi.serialization.serializer.Serializer;
import org.serieznyi.serialization.serializer.exception.EncoderException;
import org.serieznyi.serialization.serializer.value.ListValue;
import org.serieznyi.serialization.serializer.value.MapValue;
import org.serieznyi.serialization.serializer.value.ObjectValue;
import org.serieznyi.serialization.serializer.value.Value;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlEncoder implements Encoder {
  private final String NULL_IDENTIFIER = "NULL";

  @Override
  public String encode(ObjectValue object) {
    try {
      Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
      document.appendChild(objectValueToXmlElement(document, object));

      StringWriter stringWriter = new StringWriter();
      StreamResult result = new StreamResult(stringWriter);
      TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), result);
      return stringWriter.toString();
    } catch (ParserConfigurationException | TransformerException e) {
      throw new EncoderException(e);
    }
  }

  private Element objectValueToXmlElement(Document document, ObjectValue object) {
    String type = object.getTypeName();

    Element rootElement = document.createElement(type);

    for (Map.Entry<String, Value<?>> entry : object.getValue().entrySet()) {
      String key = entry.getKey();
      Value<?> value = entry.getValue();

      Element element = document.createElement(key);

      element.setAttribute("type", value.getType().toString());

      element.appendChild(valueToXmlElement(document, value));

      rootElement.appendChild(element);
    }

    return rootElement;
  }

  private Node valueToXmlElement(Document document, Value<?> value) {
    Node node;

    if (value.getType() == Value.Type.PRIMITIVE || value.getType() == Value.Type.ENUM) {
      node = document.createTextNode((String) value.getValue());
    } else if (value.getType() == Value.Type.NULL) {
      node = document.createTextNode(NULL_IDENTIFIER);
    } else if (value.getType() == Value.Type.LIST) {
      ListValue listValue = (ListValue) value;

      node = document.createDocumentFragment();

      for (Value<?> listValueItem : listValue.getValue()) {
        node.appendChild(valueToXmlElement(document, listValueItem));
      }
    } else if (value.getType() == Value.Type.MAP) {

      MapValue mapValue = (MapValue) value;

      node = document.createDocumentFragment();

      for (Map.Entry<String, ? extends Value<?>> entry : mapValue.getValue().entrySet()) {
        Element item = document.createElement("item");

        Node key = document.createElement("key");
        key.appendChild(document.createTextNode(entry.getKey()));
        item.appendChild(key);

        Node value2 = document.createElement("value");
        value2.appendChild(valueToXmlElement(document, entry.getValue()));
        item.appendChild(value2);

        node.appendChild(item);
      }
    } else if (value.getType() == Value.Type.OBJECT) {
      node = objectValueToXmlElement(document, (ObjectValue) value);
    } else {
      throw new EncoderException("Не поддерживаемый тип: " + value.getType());
    }

    if (node instanceof Element) {
      ((Element)node).setAttribute("type", value.getType().toString());
    }

    return node;
  }

  private ObjectValue xmlElementToObjectValue(Element element) {
    ObjectValue objectValue = new ObjectValue(element.getNodeName());

    for (int i = 0; i < element.getChildNodes().getLength(); i++) {
      Node node = element.getChildNodes().item(i);
      String nodeName = node.getNodeName();
      Node firstChild = node.getFirstChild();

      String type = node.getAttributes().getNamedItem("type").getNodeValue();

      if (Value.Type.PRIMITIVE.name().equals(type)) {
        objectValue.addPrimitiveValue(nodeName, node.getTextContent());
      } else if (Value.Type.NULL.name().equals(type)) {
        objectValue.addNullValue(nodeName);
      } else if (Value.Type.ENUM.name().equals(type)) {
        objectValue.addEnumValue(nodeName, node.getTextContent());
      } else if (Value.Type.OBJECT.name().equals(type)) {
        objectValue.addObjectValue(nodeName, xmlElementToObjectValue((Element) firstChild));
      } else if (Value.Type.LIST.name().equals(type)) {
        List<ObjectValue> list = new ArrayList<>();

        NodeList childNodes = node.getChildNodes();

        for (int k = 0; k < childNodes.getLength() ; k++) {
          list.add(xmlElementToObjectValue((Element) childNodes.item(k)));
        }

        objectValue.addListValue(nodeName, new ListValue(list));
      } else if (Value.Type.MAP.name().equals(type)) {
        Map<String, ObjectValue> map = new HashMap<>();

        NodeList childNodes = node.getChildNodes();

        for (int k = 0; k < childNodes.getLength() ; k++) {
          Node item = childNodes.item(k);

          Element first = (Element) item.getFirstChild();
          Element last = (Element) item.getLastChild();
          Node keyNode = first.getTagName().equals("key") ? first : last;
          Node valueNode = last.getTagName().equals("value") ? last.getFirstChild() : first.getFirstChild();

          map.put(keyNode.getTextContent(), xmlElementToObjectValue((Element) valueNode));
        }

        objectValue.addMapValue(nodeName, new MapValue(map));
      }
    }

    return objectValue;
  }

  @Override
  public ObjectValue decode(String data) {
    try {
      Document document =
          DocumentBuilderFactory.newInstance()
              .newDocumentBuilder()
              .parse(new ByteArrayInputStream(data.getBytes()));

      return xmlElementToObjectValue(document.getDocumentElement());
    } catch (Throwable e) {
      throw new EncoderException(e);
    }
  }

  public boolean isMatch(Serializer.Format format) {
    return format == Serializer.Format.XML;
  }
}
