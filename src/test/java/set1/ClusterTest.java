package set1;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Test;
import org.xml.sax.SAXException;

import static org.junit.Assert.*;
import set1.model.Cluster;

/**
 * Cluster Unit Test.
 * 
 * @author 이진규
 */
public class ClusterTest {
	/**
	 * 파일에서 읽어들이기.
	 */
	@Test
	public void testReadFromFile() {
		Cluster cluster = new Cluster();
		String path = this.getClass()
				.getResource("/set1/titan_Authoritative.clsx").getPath();
		try {
			cluster.updateFromFile(path);
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue("Root Node Name", cluster.getDocument().getDocumentElement().getLastChild().getAttributes().getNamedItem("name").getNodeValue().equals("$root"));
	}
}
