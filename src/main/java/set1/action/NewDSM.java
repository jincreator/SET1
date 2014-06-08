package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


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
