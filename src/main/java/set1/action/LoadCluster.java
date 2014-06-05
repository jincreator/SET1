package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import set1.Titan;

public class LoadCluster {
	public JMenuItem FileLoadClustering = new JMenuItem("Load Clustering");
	public JButton LoadCluster = new JButton("");
	public LoadCluster(){
		FileLoadClustering.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeClosed.gif")));
		FileLoadClustering.addActionListener(new EventHandler());
		LoadCluster.setIcon(new ImageIcon(Titan.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		LoadCluster.setToolTipText("LoadCluster");
		LoadCluster.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("LoadCluster");
		}
	}
}
