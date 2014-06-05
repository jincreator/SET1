package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import set1.Titan;

public class MoveDown {
	public JButton MoveDown = new JButton("");
	public MoveDown(){
		MoveDown.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		MoveDown.setToolTipText("ExpandAll");
		MoveDown.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("MoveDown");
		}
	}
}
