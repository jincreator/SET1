package set1.action;
import java.awt.event.ActionEvent;

import set1.Titan;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
public class About {
	Titan i;
	//this.i = i;
	
	public JMenuItem About = new JMenuItem("About");
	public About(){
		About.addActionListener(new EventHandler());
	}
	
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("About");
		//JOptionPane.showMessageDialog(this, "예제창입니다.", "예제", JOptionPane.QUESTION_MESSAGE);
		}
	}
}
