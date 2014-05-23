package set1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSeparator;
import java.awt.Choice;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Button;
import javax.swing.JPasswordField;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.List;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Titan {
	
	String planet[]={
			"qqqq",
			"qqq",
			"qqqq",
			"wwwww",
			"fegsdfgssg"
	};
	
	String row[][]={{"d","d","d"},
			{"d","d","d"},
	};
	String col[]={"s","s","s"};

	private JFrame frmTitan;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public void launchTitan() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Titan window = new Titan();
					window.frmTitan.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Titan() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		
		frmTitan = new JFrame();
		frmTitan.setTitle("Titan-1\uC870");
		frmTitan.setBounds(100, 100, 654, 538);
		frmTitan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmTitan.setJMenuBar(menuBar);
		
		JMenu mnF = new JMenu("File");
		menuBar.add(mnF);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Open DSM");
		mntmNewMenuItem.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		mnF.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnF.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New Clustering");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Titan.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		mnF.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Load Clustering");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeClosed.gif")));
		mnF.add(mntmNewMenuItem_2);
		
		JSeparator separator_1 = new JSeparator();
		mnF.add(separator_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Save Clustering");
		mntmNewMenuItem_3.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mnF.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Save Clustering As");
		mntmNewMenuItem_4.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mnF.add(mntmNewMenuItem_4);
		
		JSeparator separator_2 = new JSeparator();
		mnF.add(separator_2);
		
		JMenu mnNewMenu = new JMenu("Export As");
		mnF.add(mnNewMenu);
		
		JMenuItem mntmDsm = new JMenuItem("DSM");
		mntmDsm.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		mnNewMenu.add(mntmDsm);
		
		JMenuItem mntmExcel = new JMenuItem("Excel");
		mntmExcel.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		mnNewMenu.add(mntmExcel);
		
		JSeparator separator_3 = new JSeparator();
		mnF.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		mnF.add(separator_4);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("exit");
		mnF.add(mntmNewMenuItem_6);
		
		JMenu mnMetrics = new JMenu("Metrics");
		menuBar.add(mnMetrics);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Propagation Cost");
		mnMetrics.add(mntmNewMenuItem_8);
		
		JMenu mnNewMenu_1 = new JMenu("View");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Redraw");
		mntmNewMenuItem_5.setIcon(new ImageIcon(Titan.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JSeparator separator_5 = new JSeparator();
		mnNewMenu_1.add(separator_5);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Find");
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JSeparator separator_6 = new JSeparator();
		mnNewMenu_1.add(separator_6);
		
		JCheckBoxMenuItem chckbxmntmShowLowLabels = new JCheckBoxMenuItem("Show Low Labels");
		mnNewMenu_1.add(chckbxmntmShowLowLabels);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Show Dependency Strength");
		mnNewMenu_1.add(chckbxmntmNewCheckItem);
		
		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnNewMenu_2.add(mntmAbout);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(row[0][0]);
			}
		});
		menuBar.add(btnNewButton);
		
		
		JSplitPane splitPane = new JSplitPane();
		frmTitan.getContentPane().add(splitPane, BorderLayout.CENTER);
		

		
		
		
		JList list = new JList(planet);
		splitPane.setLeftComponent(list);
		
		table = new JTable(row,col);
		splitPane.setRightComponent(table);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
