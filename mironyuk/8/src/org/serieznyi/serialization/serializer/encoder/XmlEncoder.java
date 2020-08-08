package org.serieznyi.serialization.serializer.encoder;

import org.serieznyi.serialization.serializer.Encoder;
import org.serieznyi.serialization.serializer.Serializer;
import org.serieznyi.serialization.serializer.exception.EncoderException;
import org.serieznyi.serialization.serializer.value.ObjectValue;
import org.serieznyi.serialization.serializer.value.Value;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
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

      if (value.getType() == Value.Type.PRIMITIVE) {
        element.appendChild(document.createTextNode((String) value.getValue()));
      } else if (value.getType() == Value.Type.NULL) {
        element.appendChild(document.createTextNode(NULL_IDENTIFIER));
      } else if (value.getType() == Value.Type.OBJECT) {
        element.appendChild(objectValueToXmlElement(document, (ObjectValue) value));
      }

      rootElement.appendChild(element);
    }

    return rootElement;
  }

  private ObjectValue xmlElementToObjectValue(Element element) {
    ObjectValue objectValue = new ObjectValue(element.getNodeName());

    for (int i = 0; i < element.getChildNodes().getLength(); i++) {
      Node node = element.getChildNodes().item(i);
      String nodeName = node.getNodeName();
      Node firstChild = node.getFirstChild();
      int firstChildType = firstChild.getNodeType();
      int nodeChildesCount = node.getChildNodes().getLength();

      if (nodeChildesCount == 1 && firstChildType == Node.TEXT_NODE) {
        String nodeText = node.getTextContent();

        if (nodeText.equals(NULL_IDENTIFIER)) {
          objectValue.addNullValue(node.getNodeName());
        } else {
          objectValue.addPrimitiveValue(node.getNodeName(), nodeText, null);
        }
      } else if (nodeChildesCount == 1 && firstChildType == Node.ELEMENT_NODE) {
        objectValue.addObjectValue(nodeName, xmlElementToObjectValue((Element) firstChild));
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
    } catch (SAXException | ParserConfigurationException | IOException e) {
      throw new EncoderException(e);
    }
  }

  public boolean isMatch(Serializer.Format format) {
    return format == Serializer.Format.XML;
  }
}
