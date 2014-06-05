package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;


public class Exit {
	public JMenuItem Exit = new JMenuItem("exit");
	public Exit(){
		Exit.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("Exit");
			System.exit(0);
		}
	}
}
