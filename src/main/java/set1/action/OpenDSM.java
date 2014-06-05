package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import set1.Titan;
public class OpenDSM {
	public JMenuItem FileOpenDSM = new JMenuItem("Open DSM");
	public JButton OpenDSM = new JButton("");
	public OpenDSM(){
		FileOpenDSM.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		FileOpenDSM.addActionListener(new EventHandler());
		OpenDSM.setToolTipText("OpenDSM");
		OpenDSM.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		OpenDSM.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("ddddffffffd");
		}
	}
}
