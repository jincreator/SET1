package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;



public class ShowLowLabel {
	public JCheckBoxMenuItem ShowLowLabels = new JCheckBoxMenuItem("Show Low Labels");
	public ShowLowLabel(){
		ShowLowLabels.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("Low");
		}
	}
}
