package set1.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Cluster를 관리합니다.
 * 
 * @author 이진규
 */
public class Cluster {

	private static final String rootName = "$root";

	protected Document document;

	/**
	 * Cluster Object를 만들고 최상위 노드의 이름을 $root로 짓습니다.
	 */
	public Cluster() {
		try {
			document = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().newDocument();
			document.appendChild(document.createElement("cluster"));
			Element rootElement = document.createElement("group");
			rootElement.setAttribute("name", rootName);
			document.getDocumentElement().appendChild(rootElement);
		} catch (DOMException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Cluster(String[] nameArray) {
		this();
		for (String name : nameArray) {
			Element element = document.createElement("item");
			element.setAttribute("name", name);
			document.getDocumentElement().getLastChild().appendChild(element);
		}
	}

	/**
	 * 파일을 읽어 Cluster Object를 만듭니다.
	 *
	 * @param path
	 *            경로
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws XPathExpressionException
	 * @see #Cluster()
	 * @see #updateFromFile(String)
	 */
	public Cluster(String path) throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException {
		this();
		this.updateFromFile(path);
	}

	/**
	 * 노드에서 엘리먼트만 남깁니다.
	 *
	 * @param node
	 *            노드
	 * @see #updateFromFile(String)
	 */
	private void filterElementOnlyNode(Node node) {
		// System.out.println(node.toString() +
		// String.valueOf(node.getChildNodes()));
		if (node.hasChildNodes()) {
			NodeList childNodes = node.getChildNodes();
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node childNode = childNodes.item(i);
				if (childNode.getNodeType() != Node.ELEMENT_NODE) {
					// System.out.println(childNode.toString());
					childNode.getParentNode().removeChild(childNode);
				} else {
					filterElementOnlyNode(childNode);
					// System.out.println(childNode.toString());
				}
			}
		}
	}

	/**
	 * 파일을 읽어 Cluster를 고칩니다.
	 *
	 * @param path
	 *            경로
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws XPathExpressionException
	 * @see #writeToFile(String)
	 * @see #Cluster(String)
	 */
	public void updateFromFile(String path)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException {
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		// dbFactory.setNamespaceAware(true);
		// dbFactory.setValidating(true);
		// dbFactory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		XPathExpression clusterXPath = XPathFactory.newInstance().newXPath()
				.compile("/cluster");
		XPathExpression rootGroupXPath = XPathFactory.newInstance().newXPath()
				.compile("group[@name='$root']");
		NodeList clusterNodeList = (NodeList) clusterXPath.evaluate(doc,
				XPathConstants.NODESET);
		// if (clusterNodeList.getLength() != 1)
		// throw new Exception("TODO"); //TODO
		Node clusterNode = clusterNodeList.item(0);
		NodeList rootGroupNodeList = (NodeList) rootGroupXPath.evaluate(
				clusterNode, XPathConstants.NODESET);
		// if (rootGroupNodeList.getLength() != 1)
		// throw new Exception("TODO"); //TODO
		Node rootGroupNode = rootGroupNodeList.item(0);
		filterElementOnlyNode(doc.getDocumentElement());
		document = doc;
	}

	/**
	 * Cluster를 파일에 씁니다.
	 *
	 * @param path
	 *            경로
	 * @throws IOException
	 * @see #updateFromFile(String)
	 */
	public void writeToFile(String path) throws IOException {
		// TODO

		try {
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty("omit-xml-declaration", "yes");
			transformer.transform(new DOMSource(document), new StreamResult(
					new File(path)));
		} catch (TransformerException | TransformerFactoryConfigurationError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/**
	 * 새 노드를 $root 아래에 넣습니다.
	 * 
	 * @param rowName
	 *            새 노드의 이름
	 */
	public void addRow(String rowName) {
		Element rowElement = document.createElement("item");
		rowElement.setAttribute("name", rowName);
		document.getLastChild().appendChild(rowElement);
	}

	public Document getDocument() {
		return document;
	}
}