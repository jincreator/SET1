package set1.view;

import javax.swing.table.AbstractTableModel;

import set1.model.Cluster;
import set1.model.DSM;
import set1.model.IncompleteDataException;
import set1.model.WrongCharacterException;

public class DSMTableModel extends AbstractTableModel {

	private DSM dsm;
	private Cluster cluster;
	private Boolean isLabel;

	public DSMTableModel(DSM dsm, Cluster cluster) {
		this.dsm = dsm;
		this.cluster = cluster;
		this.isLabel = true;
	}

	public DSMTableModel(DSM dsm, Cluster cluster, Boolean isLabel) {
		this.dsm = dsm;
		this.cluster = cluster;
		this.isLabel = isLabel;
	}

	public void setLabel(Boolean isLabel) {
		this.isLabel = isLabel;
	}

	@Override
	public int getRowCount() {
		return dsm.getNameMatrix().length;
	}

	@Override
	public int getColumnCount() {
		return dsm.getNameMatrix().length + 1;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0)
			return "";
		else
			return String.valueOf(columnIndex);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex != 0) {
			if (dsm.getDataMatrix()[rowIndex][columnIndex - 1] == true)
				return 'X';
			else
				return ' ';
		} else if (isLabel)
			return String.valueOf(rowIndex + 1) + ". "
					+ dsm.getNameMatrix()[rowIndex];
		else
			return String.valueOf(rowIndex + 1);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 0;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		columnIndex--;
		String inputString = ((String) aValue).replaceAll("\\s+", "");
		char inputChar;
		if (!inputString.isEmpty()) {
			inputChar = inputString.charAt(0);
			Boolean[][] updatedDataMatrix = dsm.getDataMatrix();
			if (inputChar == 'X' || inputChar == 'x' || inputChar == '1')
				updatedDataMatrix[rowIndex][columnIndex] = true;
			if (inputChar == 'O' || inputChar == 'o' || inputChar == '0')
				updatedDataMatrix[rowIndex][columnIndex] = false;
			try {
				dsm.updateFromArray(dsm.getNameMatrix(), updatedDataMatrix);
			} catch (IncompleteDataException | WrongCharacterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
