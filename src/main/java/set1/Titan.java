package set1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSeparator;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JSplitPane;
import javax.swing.JTable;

public class Titan {

	String planet[] = { "entity_1", "entity_2", "entity_3" };

	String row[][] = { { "", "1", "2", "3" }, { "entity_1", "-", "", "1" },
			{ "entity_2", "", "", "" }, { "entity_3", "", "", "-" } };
	String col[] = { "s", "s", "s", "s" };

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

		JMenuItem mntmNewMenuItem_newDSM = new JMenuItem("New DSM");
		mntmNewMenuItem_newDSM.setIcon(new ImageIcon(Titan.class
				.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		mnF.add(mntmNewMenuItem_newDSM);

		JMenuItem mntmNewMenuItem = new JMenuItem("Open DSM");
		mntmNewMenuItem
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		mnF.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_saveDSM = new JMenuItem("Save DSM");
		mntmNewMenuItem_saveDSM
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mnF.add(mntmNewMenuItem_saveDSM);

		JMenuItem mntmNewMenuItem_saveDSMAs = new JMenuItem("Save DSM As...");
		mntmNewMenuItem_saveDSMAs
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mnF.add(mntmNewMenuItem_saveDSMAs);

		JSeparator separator = new JSeparator();
		mnF.add(separator);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New Clustering");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Titan.class
				.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		mnF.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Load Clustering");
		mntmNewMenuItem_2
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/java/swing/plaf/windows/icons/TreeClosed.gif")));
		mnF.add(mntmNewMenuItem_2);

		JSeparator separator_1 = new JSeparator();
		mnF.add(separator_1);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Save Clustering");
		mntmNewMenuItem_3
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mnF.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Save Clustering As");
		mntmNewMenuItem_4
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mnF.add(mntmNewMenuItem_4);

		JSeparator separator_2 = new JSeparator();
		mnF.add(separator_2);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("exit");
		mnF.add(mntmNewMenuItem_6);

		JMenu mnNewMenu_1 = new JMenu("View");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Redraw");
		mntmNewMenuItem_5
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		mnNewMenu_1.add(mntmNewMenuItem_5);

		JSeparator separator_5 = new JSeparator();
		mnNewMenu_1.add(separator_5);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Find");
		mnNewMenu_1.add(mntmNewMenuItem_7);

		JSeparator separator_6 = new JSeparator();
		mnNewMenu_1.add(separator_6);

		JCheckBoxMenuItem chckbxmntmShowLowLabels = new JCheckBoxMenuItem(
				"Show Low Labels");
		mnNewMenu_1.add(chckbxmntmShowLowLabels);

		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem(
				"Show Dependency Strength");
		mnNewMenu_1.add(chckbxmntmNewCheckItem);

		JMenu mnNewMenu_2 = new JMenu("Help");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmAbout = new JMenuItem("About");
		mnNewMenu_2.add(mntmAbout);

		JSplitPane splitPane = new JSplitPane();
		frmTitan.getContentPane().add(splitPane, BorderLayout.CENTER);

		JList<String> list = new JList(planet); // FIXME JList generic이
												// WindowBuilder에서 안됨
		splitPane.setLeftComponent(list);

		table = new JTable(row, col);
		splitPane.setRightComponent(table);
	}
}
