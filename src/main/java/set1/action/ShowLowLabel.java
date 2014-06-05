package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;

import set1.Titan;
import set1.action.Redraw.EventHandler;

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
