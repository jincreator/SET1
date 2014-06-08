package set1.data;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Cluster를 관리합니다.
 * 
 * @author 이진규
 */
public class Cluster {

	private DefaultMutableTreeNode tree;

	/**
	 * Cluster Object를 만들고 최상위 노드의 이름을 $root로 짓습니다.
	 */
	public Cluster() {
		tree = new DefaultMutableTreeNode("$root");
	}

	public Cluster(String[] nameArray) {
		this();
		for (String name : nameArray)
			tree.add(new DefaultMutableTreeNode(name));
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
	 * 노드를 JTree에서 쓸 수 있는 MutableTreeNode로 바꿔줍니다.
	 *
	 * @param node
	 *            노드
	 * @see #updateFromFile(String)
	 */
	private DefaultMutableTreeNode recursiveTree(Node node) {
		DefaultMutableTreeNode retTreeNode = new DefaultMutableTreeNode(node
				.getAttributes().getNamedItem("name").getNodeValue());
		if (node.hasChildNodes()) {
			NodeList childNodes = node.getChildNodes();
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node childNode = childNodes.item(i);
				if (childNode.getNodeType() == Node.ELEMENT_NODE) {
					retTreeNode.add(recursiveTree(childNode));
				}
			}
		}
		return retTreeNode;
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
		tree = recursiveTree(rootGroupNode);
	}

	/**
	 * Cluster를 파일에 씁니다.
	 *
	 * @param path
	 *            경로
	 * @see #updateFromFile(String)
	 */
	public void writeToFile(String path) {
		// TODO
	}

	/**
	 * Cluster의 tree를 반환합니다.
	 */
	public DefaultMutableTreeNode getTree() {
		return tree;
	}

	/**
	 * 새 노드를 $root 아래에 넣습니다.
	 */
	public void addRow(String rowName) {
		tree.add(new DefaultMutableTreeNode(rowName));
	}
}