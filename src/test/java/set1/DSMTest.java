package set1;

import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.*;
import set1.model.DSM;
import set1.model.IncompleteDataException;
import set1.model.WrongCharacterException;

/**
 * DSM Unit Test.
 * 
 * @author 이진규
 */
public class DSMTest {
	/**
	 * 파일에서 읽어들이기.
	 */
	@Test
	public void testReadFromFile() {
		DSM dsm = new DSM();
		String path = this.getClass().getResource("/set1/titan.dsm").getPath();
		try {
			dsm.updateFromFile(path);
		} catch (IOException | IncompleteDataException
				| WrongCharacterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue("Length of DSM name", dsm.getNameMatrix().length == 35);
		assertTrue("Length of DSM data", dsm.getDataMatrix().length == 35);
		assertTrue(
				"DSM first name",
				dsm.getNameMatrix()[0]
						.equals("edu.drexel.cs.rise.titan.action.cluster.SaveAction"));
		assertTrue("DSM last name",
				dsm.getNameMatrix()[34]
						.equals("edu.drexel.cs.rise.titan.model.MatrixModel"));
		assertTrue("DSM 0 data", dsm.getDataMatrix()[0][0] == false);
		assertTrue("DSM 1 data", dsm.getDataMatrix()[34][25] == true);
		assertTrue("hasRow edu.drexel.cs.rise.titan.action.cluster.SaveAction", dsm.hasRow("edu.drexel.cs.rise.titan.action.cluster.SaveAction"));
		assertFalse("hasRow kr.ac.cau.cse.titan", dsm.hasRow("kr.ac.cau.cse.titan"));
	}
}
