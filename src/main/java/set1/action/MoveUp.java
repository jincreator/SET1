package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import set1.Titan;

public class MoveUp {
	public JButton MoveUp = new JButton("");
	public MoveUp(){
		MoveUp.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		MoveUp.setToolTipText("ExpandAll");
		MoveUp.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("MoveUp");
		}
	}
}
