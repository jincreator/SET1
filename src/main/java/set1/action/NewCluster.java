package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import set1.Titan;

public class NewCluster {
	public JMenuItem FileNewClustering = new JMenuItem("New Clustering");
	public JButton NewCluster = new JButton("");
	public NewCluster(){
		FileNewClustering.setIcon(new ImageIcon(Titan.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		FileNewClustering.addActionListener(new EventHandler());
		NewCluster.setToolTipText("NewCluster");
		NewCluster.setIcon(new ImageIcon(Titan.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		NewCluster.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("NewCluster");
		}
	}
}
