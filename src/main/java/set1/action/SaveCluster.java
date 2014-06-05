package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import set1.Titan;
import set1.action.LoadCluster.EventHandler;

public class SaveCluster {
	public JMenuItem FileSaveClustering = new JMenuItem("Save Clustering");
	public JButton SaveCluster = new JButton("");
	public SaveCluster(){
		FileSaveClustering.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		FileSaveClustering.addActionListener(new EventHandler());
		SaveCluster.setIcon(new ImageIcon(Titan.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		SaveCluster.setToolTipText("SaveCluster");
		SaveCluster.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("SaveCluster");
		}
	}
}
