package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import set1.Titan;
import set1.action.SaveClusterAs.EventHandler;

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
