package set1.data;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * DSM을 관리합니다.
 * 
 * @author 이진규
 */
public class DSM {

	private ArrayList<ArrayList<Boolean>> dataMatrix;
	private ArrayList<String> nameMatrix;

	public DSM() {
		dataMatrix = new ArrayList<ArrayList<Boolean>>();
		nameMatrix = new ArrayList<String>();
	}

	/**
	 * 두 Array에서 DSM Object를 만듭니다.
	 *
	 * @param nameArray
	 *            이름
	 * @param dataArray
	 *            데이터
	 * @throws IncompleteDataException
	 *             데이터가 빠져 있음
	 * @throws WrongCharacterException
	 *             잘못된 값이 들어 있음
	 * @see #DSM()
	 * @see #DSM(String)
	 * @see #updateFromArray(String[], Boolean[][])
	 */
	public DSM(String[] nameArray, Boolean[][] dataArray)
			throws IncompleteDataException, WrongCharacterException {
		this();
		this.updateFromArray(nameArray, dataArray);
	}

	/**
	 * 파일을 읽어 DSM Object를 만듭니다.
	 *
	 * @param path
	 *            경로
	 * @throws FileNotFoundException
	 *             파일이 없음
	 * @throws IOException
	 *             I/O가 잘못됨
	 * @throws IncompleteDataException
	 *             데이터가 빠져 있음
	 * @throws WrongCharacterException
	 *             잘못된 값이 들어 있음
	 * @see #DSM()
	 * @see #DSM(String[], Boolean[][])
	 * @see #updateFromFile(String)
	 */
	public DSM(String path) throws FileNotFoundException, IOException,
			IncompleteDataException, WrongCharacterException {
		this();
		this.updateFromFile(path);
	}

	/**
	 * 두 array에서 DSM을 고칩니다.
	 *
	 * @param nameArray
	 *            이름
	 * @param dataArray
	 *            데이터
	 * @throws IncompleteDataException
	 *             데이터가 빠져 있음
	 * @throws WrongCharacterException
	 *             잘못된 값이 들어 있음
	 * @see #DSM(String[], Boolean[][])
	 * @see #writeToFile(String)
	 */
	public void updateFromArray(String[] nameArray, Boolean[][] dataArray)
			throws IncompleteDataException, WrongCharacterException {
		ArrayList<String> updatedNameMatrix = new ArrayList<String>();
		ArrayList<ArrayList<Boolean>> updatedDataMatrix = new ArrayList<ArrayList<Boolean>>();
		if (nameArray.length > dataArray.length)
			throw new IncompleteDataException(nameArray[dataArray.length]
					+ "부터는 데이터가 없습니다.");
		if (nameArray.length < dataArray.length)
			throw new WrongCharacterException("데이터는 " + nameArray.length
					+ "줄 있어야 하나 더 많습니다.");
		for (int i = 0; i < dataArray.length; i++) {
			Boolean[] dataLine = dataArray[i];
			if (dataLine.length > nameArray.length)
				throw new WrongCharacterException(nameArray[i]
						+ "에 데이터가 더 있습니다.");
			if (dataLine.length < nameArray.length)
				throw new IncompleteDataException(nameArray[i]
						+ "에 데이터가 빠져있습니다");
			ArrayList<Boolean> updatedDataLine = new ArrayList<Boolean>();
			for (Boolean data : dataLine)
				updatedDataLine.add(data);
			updatedDataMatrix.add(updatedDataLine);
		}
		for (String name : nameArray) {
			updatedNameMatrix.add(name);
		}
		nameMatrix = updatedNameMatrix;
		dataMatrix = updatedDataMatrix;
	}

	/**
	 * 이름이 들어있는 ArrayList를 줍니다.
	 * 
	 * @return nameMatrix
	 * @see #getDataMatrix()
	 */
	public ArrayList<String> getNameMatrix() {
		return new ArrayList<String>(nameMatrix);
	}

	/**
	 * 데이터가 들어있는 ArrayList를 줍니다.
	 * 
	 * @return dataMatrix
	 * @see #getNameMatrix()
	 */
	public ArrayList<ArrayList<Boolean>> getDataMatrix() {
		return new ArrayList<ArrayList<Boolean>>(dataMatrix);
	}

	/**
	 * 파일을 읽어 DSM을 고칩니다.
	 *
	 * @param path
	 *            경로
	 * @throws FileNotFoundException
	 *             파일이 없음
	 * @throws IOException
	 *             I/O가 잘못됨
	 * @throws IncompleteDataException
	 *             데이터가 빠져 있음
	 * @throws WrongCharacterException
	 *             잘못된 값이 들어 있음
	 * @see #writeToFile(String)
	 * @see #DSM(String)
	 */
	public void updateFromFile(String path) throws FileNotFoundException,
			IOException, IncompleteDataException, WrongCharacterException {
		ArrayList<String> updatedNameMatrix = new ArrayList<String>();
		ArrayList<ArrayList<Boolean>> updatedDataMatrix = new ArrayList<ArrayList<Boolean>>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			int lineLength = Integer.parseInt(br.readLine());
			for (int lineNum = 1; lineNum < lineLength + 1; lineNum++) {
				String[] line = br.readLine().split(" ");
				if (line.length != lineLength)
					throw new IncompleteDataException("한줄 길이가 짧음");
				ArrayList<Boolean> dataLine = new ArrayList<Boolean>();
				for (String status : line) {
					if (status.equals("1")) {
						dataLine.add(true);
					} else if (status.equals("0")) {
						dataLine.add(false);
					} else {
						throw new WrongCharacterException("0/1만 있어야 함");
					}
				}
				updatedDataMatrix.add(dataLine);
			}
			for (int lineNum = 1; lineNum < lineLength + 1; lineNum++) {
				updatedNameMatrix.add(br.readLine());
			}
			nameMatrix = updatedNameMatrix;
			dataMatrix = updatedDataMatrix;
		}
	}

	/**
	 * DSM을 파일에 씁니다.
	 *
	 * @param path
	 *            경로
	 * @throws IOException
	 *             I/O가 잘못됨
	 * @see #updateFromFile(String)
	 */
	public void writeToFile(String path) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			bw.write(nameMatrix.size());
			bw.newLine();
			for (ArrayList<Boolean> dataLine : dataMatrix) {
				for (Boolean data : dataLine) {
					if (data == false)
						bw.write('0');
					else
						bw.write('1');
					bw.write(' ');
				}
				bw.newLine();
			}
			for (int i = 0; i < nameMatrix.size(); i++) {
				bw.write(nameMatrix.get(i));
				if (i == nameMatrix.size() - 1)
					bw.newLine();
			}
		}
	}
}