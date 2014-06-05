package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import set1.Titan;

public class ExpandAll {
	public JButton ExpandAll = new JButton("");
	public ExpandAll(){
		ExpandAll.setIcon(new ImageIcon(Titan.class.getResource("/javax/swing/plaf/metal/icons/ocean/expanded.gif")));
		ExpandAll.setToolTipText("ExpandAll");
		ExpandAll.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("ExpandAll");
		}
	}
}
