package org.serieznyi.serialization;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
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

  private static NodeList extractNodeListWithNormalizedSpaces(Document document) throws XPathExpressionException {
    XPath xPath = XPathFactory.newInstance().newXPath();
    return (NodeList)
        xPath.evaluate("//text()[normalize-space()='']", document, XPathConstants.NODESET);
  }

  private static Document stringToDocument(String xml) throws ParserConfigurationException, IOException, SAXException {
    return DocumentBuilderFactory.newInstance()
        .newDocumentBuilder()
        .parse(new InputSource(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))));
  }

  private String toPrettyXmlString(Document document) throws XPathExpressionException, TransformerException {
      NodeList nodeList = extractNodeListWithNormalizedSpaces(document);

      for (int i = 0; i < nodeList.getLength(); i++) {
        Node node = nodeList.item(i);
        node.getParentNode().removeChild(node);
      }

      Transformer transformer = this.createPrettyTransformer();

      StringWriter stringWriter = new StringWriter();
      transformer.transform(new DOMSource(document), new StreamResult(stringWriter));

      return stringWriter.toString();
  }

  private Transformer createPrettyTransformer() throws TransformerConfigurationException {
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    transformerFactory.setAttribute("indent-number", this.indent);
    Transformer transformer = transformerFactory.newTransformer();
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

    return transformer;
  }

  public String toPrettyView(String xml) throws FormattingException {
    try {
      Document document = stringToDocument(xml);

      return toPrettyXmlString(document);
    } catch (Throwable e) {
      throw new FormattingException(e);
    }
  }

  public String fromPrettyView(String value) {
    return trim(value);
  }

  public static String trim(String input) {
    BufferedReader reader = new BufferedReader(new StringReader(input));
    StringBuilder result = new StringBuilder();
    try {
      String line;
      while ( (line = reader.readLine() ) != null)
        result.append(line.trim());
      return result.toString();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static class FormattingException extends Exception
  {
    public FormattingException(Throwable e) {
      super(e);
    }
  }
}
