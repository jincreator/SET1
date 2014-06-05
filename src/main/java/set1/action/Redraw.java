package set1.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import set1.Titan;
import set1.action.SaveClusterAs.EventHandler;

public class Redraw {
	public JMenuItem ViewRedraw = new JMenuItem("Redraw");
	public JButton Redraw = new JButton("");
	public Redraw(){
		ViewRedraw.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		ViewRedraw.addActionListener(new EventHandler());
		Redraw.setToolTipText("Redraw");
		Redraw.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		Redraw.addActionListener(new EventHandler());
	}
	class EventHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			System.out.print("ViewRedraw");
		}
	}
}
