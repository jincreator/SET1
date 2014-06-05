package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import set1.Titan;

public class CollapseAll {
	public JButton CollapseAll = new JButton("");
	public CollapseAll(){
		CollapseAll.setToolTipText("CollapseAll");
		CollapseAll.setIcon(new ImageIcon(Titan.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed.gif")));
		CollapseAll.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("CollapseAll");
		}
	}
}
