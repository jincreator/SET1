package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import set1.Titan;
import set1.action.OpenDSM.EventHandler;

public class NewDSM {
	public JMenuItem NewDSM = new JMenuItem("New DSM");
	public NewDSM(){
		NewDSM.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("NewDSM");
		}
	}
}
