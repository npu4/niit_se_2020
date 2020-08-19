package org.serieznyi.serialization;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

public class XmlPrettyFormatter {
  private static final int DEFAULT_INDENT = 10;

  private final int indent;

  public XmlPrettyFormatter() {
    this(DEFAULT_INDENT);
  }

  public XmlPrettyFormatter(int indent) {
    this.indent = indent;
  }

  private static NodeList extractNodeListWithNormalizedSpaces(Document document)
      throws XPathExpressionException {
    XPath xPath = XPathFactory.newInstance().newXPath();
    return (NodeList)
        xPath.evaluate("//text()[normalize-space()='']", document, XPathConstants.NODESET);
  }

  // метод для конвертации строки с XML разметкой в объект Document
  private static Document convertStringToDocument(String xml) {
    try {
      return DocumentBuilderFactory.newInstance()
          .newDocumentBuilder()
          .parse(new InputSource(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))));
    } catch (SAXException | IOException | ParserConfigurationException e) {
      e.printStackTrace();
    }
    return null;
  }

  private String toPrettyXmlString(Document document) {
    try {
      NodeList nodeList = extractNodeListWithNormalizedSpaces(document);

      for (int i = 0; i < nodeList.getLength(); i++) {
        Node node = nodeList.item(i);
        node.getParentNode().removeChild(node);
      }

      Transformer transformer = this.createTransformer();

      StringWriter stringWriter = new StringWriter();
      transformer.transform(new DOMSource(document), new StreamResult(stringWriter));

      return stringWriter.toString();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private Transformer createTransformer() throws TransformerConfigurationException {
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    transformerFactory.setAttribute("indent-number", this.indent);
    Transformer transformer = transformerFactory.newTransformer();
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

    return transformer;
  }

  public String toPrettyView(String xml) {
    Document document = convertStringToDocument(xml);

    return toPrettyXmlString(document);
  }
}
