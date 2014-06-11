package set1.control;

import set1.model.Cluster;
import set1.model.DSM;

public class Controller {

	private DSM dsm;
	private Cluster cluster;

	public Controller() {
		dsm = new DSM();
		cluster = new Cluster(dsm.getNameMatrix());
	}

	public Controller(DSM dsm, Cluster cluster) {
		this.setDSM(dsm);
		this.setCluster(cluster);
	}

	public DSM getDSM() {
		return dsm;
	}

	public void setDSM(DSM dsm) {
		this.dsm = dsm;
	}

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public void newDSM(int rowLength) {
		dsm = new DSM(rowLength);
		cluster = new Cluster(dsm.getNameMatrix());
	}

	public void addRow(String input) {
		dsm.addRow(input);
		cluster.addRow(input);
	}

	public void changeRowName(String originalName, String changedName) {
		dsm.changeRowName(originalName, changedName);
		cluster.changeRowName(originalName, changedName);
		// TODO cluster
	}

	public void removeRowName(String name) {
		String[] rowNameList = cluster.removeRowName(name);
		for(String rowName : rowNameList)
			dsm.removeRowName(rowName);
	}
}
