package set1;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTree;
import javax.swing.JTable;

import set1.data.DSM;
import set1.data.IncompleteDataException;
import set1.data.WrongCharacterException;

public class Titan {
	public static JFrame frmTitan;
	private JTable table;
	private DSM dsm;
	private JScrollPane scrollPane2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		dsm = new DSM();
		frmTitan = new JFrame();
		frmTitan.setTitle("소프트웨어 공학 1조");
		frmTitan.setBounds(100, 100, 800, 600);
		frmTitan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmTitan.setJMenuBar(menuBar);
		// file menu-------------------------------------------
		JMenu FIle = new JMenu("File");
		menuBar.add(FIle);
		JMenuItem NewDSM = new JMenuItem("New DSM");
		NewDSM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Input = JOptionPane.showInputDialog("input Number");
			}
		});
		NewDSM.setIcon(new ImageIcon(
				Titan.class
						.getResource("/com/sun/javafx/scene/control/skin/modena/HTMLEditor-Copy.png")));
		FIle.add(NewDSM);
		JMenuItem FileOpenDSM = new JMenuItem("Open DSM");

		FileOpenDSM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// FileDialog dsmopen = new
				// FileDialog(frmTitan,"DSM열기",FileDialog.LOAD);
				// dsmopen.setVisible(true);
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {

					try {
						dsm.updateFromFile(fc.getSelectedFile()
								.getAbsolutePath());
						table = new JTable(dsm.getDataMatrix(), dsm.getNameMatrix());
						table.repaint();
					} catch (IOException | IncompleteDataException
							| WrongCharacterException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			
		});
		FileOpenDSM
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		FIle.add(FileOpenDSM);
		JSeparator separator = new JSeparator();
		FIle.add(separator);
		JMenuItem FileNewClustering = new JMenuItem("New Clustering");
		FileNewClustering.setIcon(new ImageIcon(Titan.class
				.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		FIle.add(FileNewClustering);
		JMenuItem FileLoadClustering = new JMenuItem("Load Clustering");
		FileLoadClustering
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/java/swing/plaf/windows/icons/TreeClosed.gif")));
		JSeparator separator_1 = new JSeparator();
		FIle.add(separator_1);
		JMenuItem FileSaveClustering = new JMenuItem("Save Clustering");
		FileSaveClustering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileDialog savedsm = new FileDialog(frmTitan, "파일저장",
						FileDialog.SAVE);
				savedsm.setVisible(true);
			}
		});

		FileSaveClustering
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		FIle.add(FileSaveClustering);
		JMenuItem FileSaveClusteringAs = new JMenuItem("Save Clustering As");
		FileSaveClusteringAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fileName;
				FileDialog savedsm = new FileDialog(frmTitan, "파일저장",
						FileDialog.SAVE);
				savedsm.setVisible(true);
				fileName = savedsm.getDirectory() + savedsm.getFile();
			}
		});
		FileSaveClusteringAs
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		FIle.add(FileSaveClusteringAs);
		JSeparator separator_2 = new JSeparator();
		FIle.add(separator_2);
		JMenuItem Exit = new JMenuItem("exit");
		FIle.add(Exit);
		// View ---------------------------------------------
		JMenu View = new JMenu("View");
		menuBar.add(View);
		JMenuItem ViewRedraw = new JMenuItem("Redraw");
		ViewRedraw
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		View.add(ViewRedraw);
		JCheckBoxMenuItem ShowLowLabels = new JCheckBoxMenuItem(
				"Show Low Labels");
		View.add(ShowLowLabels);
		// Help-----------------------------------------------
		JMenu Help = new JMenu("Help");
		menuBar.add(Help);
		JMenuItem About = new JMenuItem("About");
		About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frmTitan,
						"20115350 선종찬\n 00000000 곽길문\n "
								+ "00000000 임동빈\n 00000000 이진규", "SE PROJECT",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Help.add(About);
		// Toolbar--------------------------------------------
		JToolBar toolBar = new JToolBar();
		frmTitan.getContentPane().add(toolBar, BorderLayout.NORTH);
		JButton OpenDSM = new JButton("");
		OpenDSM.setToolTipText("OpenDSM");
		OpenDSM.setIcon(new ImageIcon(
				Titan.class
						.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		toolBar.add(OpenDSM);
		JButton Redraw = new JButton("");
		// 리페인트
		Redraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(dsm.getDataMatrix().length);
			}
		});
		Redraw.setToolTipText("Redraw");
		Redraw.setIcon(new ImageIcon(
				Titan.class
						.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		toolBar.add(Redraw);
		JButton NewCluster = new JButton("");
		NewCluster.setToolTipText("NewCluster");
		NewCluster.setIcon(new ImageIcon(Titan.class
				.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		toolBar.add(NewCluster);
		JButton LoadCluster = new JButton("");
		LoadCluster
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		LoadCluster.setToolTipText("LoadCluster");
		toolBar.add(LoadCluster);
		JButton SaveCluster = new JButton("");
		SaveCluster
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		SaveCluster.setToolTipText("SaveCluster");
		toolBar.add(SaveCluster);
		JButton SaveClusterAs = new JButton("");
		SaveClusterAs
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")));
		SaveClusterAs.setToolTipText("SaveClusterAs");
		toolBar.add(SaveClusterAs);

		JSplitPane splitPane = new JSplitPane();
		frmTitan.getContentPane().add(splitPane, BorderLayout.CENTER);
		splitPane.setDividerLocation(230);
		// 왼쪽판넬----------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		JToolBar toolBar_1 = new JToolBar();
		scrollPane.setColumnHeaderView(toolBar_1);
		// 툴바------------------------------------------------
		JButton ExpandAll = new JButton("");
		ExpandAll
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/expanded.gif")));
		ExpandAll.setToolTipText("ExpandAll");
		toolBar_1.add(ExpandAll);
		JButton CollapseAll = new JButton("");
		CollapseAll.setToolTipText("CollapseAll");
		CollapseAll
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed.gif")));
		toolBar_1.add(CollapseAll);
		JButton Group = new JButton("");
		Group.setToolTipText("Group");
		Group.setIcon(new ImageIcon(Titan.class
				.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		toolBar_1.add(Group);
		JButton UnGroup = new JButton("");
		UnGroup.setToolTipText("UnGroup");
		UnGroup.setIcon(new ImageIcon(
				Titan.class
						.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		toolBar_1.add(UnGroup);
		JButton MoveUp = new JButton("");
		MoveUp.setIcon(new ImageIcon(
				Titan.class
						.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		MoveUp.setToolTipText("MoveUp");
		toolBar_1.add(MoveUp);
		JButton MoveDown = new JButton("");
		MoveDown.setIcon(new ImageIcon(
				Titan.class
						.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		MoveDown.setToolTipText("MoveDown");
		toolBar_1.add(MoveDown);

		JButton NewDsmLow = new JButton("");
		NewDsmLow
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		NewDsmLow.setToolTipText("NewDsmLow");
		toolBar_1.add(NewDsmLow);
		// 트리-----------------------------------------------
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		// 오른쪽 판넬-------------------------------------------
		scrollPane2 = new JScrollPane();
		splitPane.setRightComponent(scrollPane2);
		// 테이블----------------------------------------------
		table = new JTable(dsm.getDataMatrix(), dsm.getNameMatrix());
		scrollPane2.setViewportView(table);

		JButton button = new JButton("New button");
		scrollPane2.setColumnHeaderView(button);
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