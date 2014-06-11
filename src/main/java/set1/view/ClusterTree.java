package set1.view;

import java.io.IOException;
import java.security.acl.Group;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import set1.model.Cluster;

public class ClusterTree extends Cluster {
	/**
	 * 노드를 JTree에서 쓸 수 있는 MutableTreeNode로 바꿔줍니다.
	 *
	 * @param node
	 *            노드
	 * @see #updateFromFile(String)
	 */
	ClusterTree(Cluster cluster) {
		this.document = cluster.getDocument();
	}

	public ClusterTree(String[] nameMatrix) {
		super(nameMatrix);
	}

	public ClusterTree() {
		super();
	}

	public ClusterTree(String path) throws XPathExpressionException,
			ParserConfigurationException, SAXException, IOException {
		super(path);
	}

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

	private Element recursiveNode(DefaultMutableTreeNode treeNode) {
		Element retNode;
		if (treeNode.isLeaf()) {
			retNode = document.createElement("item");
		} else {
			retNode = document.createElement("group");
			Enumeration<DefaultMutableTreeNode> treeNodeEnumeration = treeNode
					.depthFirstEnumeration();
			while (treeNodeEnumeration.hasMoreElements())
				retNode.appendChild(recursiveNode(treeNodeEnumeration
						.nextElement()));
		}
		retNode.setAttribute("name", treeNode.toString());
		return retNode;
	}

	public DefaultMutableTreeNode getDefaultMutableTreeNode() {
		return recursiveTree(document.getDocumentElement().getLastChild());
	}

	public void updateFromDefaultMutableTreeNode(DefaultMutableTreeNode dmtn) {
		document.getDocumentElement().replaceChild(
				document.getDocumentElement().getLastChild(),
				recursiveNode(dmtn));
	}
}
