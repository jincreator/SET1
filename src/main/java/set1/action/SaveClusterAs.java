package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import set1.Titan;
import set1.action.SaveCluster.EventHandler;

public class SaveClusterAs {
	public JMenuItem FileSaveClusteringAs = new JMenuItem("Save Clustering As");
	public JButton SaveClusterAs = new JButton("");
	public SaveClusterAs(){
		FileSaveClusteringAs.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		FileSaveClusteringAs.addActionListener(new EventHandler());
		SaveClusterAs.setIcon(new ImageIcon(Titan.class.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")));
		SaveClusterAs.setToolTipText("SaveClusterAs");
		SaveClusterAs.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("SaveClusterAs");
		}
	}
}
