package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import set1.Titan;
import set1.action.Group.EventHandler;

public class UnGroup {
	public JButton UnGroup = new JButton("");
	public UnGroup(){
		UnGroup.setToolTipText("UnGroup");
		UnGroup.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		UnGroup.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("UnGroup");
		}
	}
}
