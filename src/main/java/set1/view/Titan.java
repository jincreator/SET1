package set1.view;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import set1.model.Cluster;
import set1.model.DSM;
import set1.model.IncompleteDataException;
import set1.model.WrongCharacterException;

public class Titan extends JFrame {
	private JTable table;
	private JTree tree;
	private JScrollPane scrollPane, scrollPane2;
	private DSM dsm;
	private Cluster cluster;
	private DSMTableModel dsmTableModel;
	private String currentDSMFilePath;

	public void showError(String message) {
		JOptionPane.showMessageDialog(null, message, "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	public String getInput(String message) {
		return JOptionPane.showInputDialog(message);
	}

	/**
	 * Create the application and initialize the contents of the frame.
	 */
	public Titan() {
		dsm = new DSM();
		cluster = new Cluster();
		dsmTableModel = new DSMTableModel(dsm, cluster);
		currentDSMFilePath = ""; // TODO: 현재폴더 쓰기.

		this.setTitle("소프트웨어 공학 1조");
		this.setBounds(100, 100, 800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		// file menu-------------------------------------------
		JMenu FIle = new JMenu("File");
		menuBar.add(FIle);
		JMenuItem NewDSM = new JMenuItem("New DSM");
		NewDSM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input = JOptionPane.showInputDialog("Enter Row Number:");
				if (input != null) {
					dsm = new DSM(Integer.parseInt(input));
					cluster = new Cluster(dsm.getNameMatrix());
				}
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
				fc.setFileFilter(new FileNameExtensionFilter("DSM file", "dsm"));
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						dsm.updateFromFile(fc.getSelectedFile()
								.getAbsolutePath());
						cluster = new Cluster(dsm.getNameMatrix());
						currentDSMFilePath = fc.getSelectedFile()
								.getAbsolutePath();
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
		JMenuItem FileSaveDSM = new JMenuItem("Save DSM");
		FileSaveDSM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dsm.writeToFile(currentDSMFilePath);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		FileSaveDSM
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		FIle.add(FileSaveDSM);

		JMenuItem FileSaveDSMAs = new JMenuItem("Save DSM As");
		FileSaveDSMAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setDialogType(JFileChooser.SAVE_DIALOG); // TODO: 근데 안바뀜...
				fc.setFileFilter(new FileNameExtensionFilter("DSM file", "dsm"));
				int returnVal = fc.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try { // TODO: .dsm 안붙으면 붙게...
						dsm.writeToFile(fc.getSelectedFile().getAbsolutePath());
						currentDSMFilePath = fc.getSelectedFile()
								.getAbsolutePath();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		FIle.add(FileSaveDSMAs);
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
		FIle.add(FileLoadClustering);
		JSeparator separator_1 = new JSeparator();
		FIle.add(separator_1);
		JMenuItem FileSaveClusteringAs = new JMenuItem("Save Clustering As");
		FileSaveClusteringAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// String fileName;
				// FileDialog savedsm = new FileDialog(frmTitan, "파일저장",
				// FileDialog.SAVE);
				// savedsm.setVisible(true);
				// fileName = savedsm.getDirectory() + savedsm.getFile();
			}
		});

		JMenuItem FileSaveClustering = new JMenuItem("Save Clustering");
		FIle.add(FileSaveClustering);
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
		JCheckBoxMenuItem ShowRowLabel = new JCheckBoxMenuItem(
				"Show Row Label");
		ShowRowLabel.setSelected(true);
		View.add(ShowRowLabel);
		// Help-----------------------------------------------
		JMenu Help = new JMenu("Help");
		menuBar.add(Help);
		JMenuItem About = new JMenuItem("About");
		About.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"20115350 선종찬\n 20105801 곽길문\n "
								+ "20122982 임동빈\n 20111549 이진규", "SE PROJECT",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Help.add(About);
		// Toolbar--------------------------------------------
		JToolBar toolBar = new JToolBar();
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		JButton OpenDSM = new JButton("");
		OpenDSM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				; // TODO
			}
		});
		OpenDSM.setToolTipText("OpenDSM");
		OpenDSM.setIcon(new ImageIcon(
				Titan.class
						.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		toolBar.add(OpenDSM);
		JButton Redraw = new JButton("");
		Redraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dsmTableModel = new DSMTableModel(dsm, cluster, ShowRowLabel
						.getState());
				table = new JTable(dsmTableModel);
				tree = new JTree(cluster.getTree());
				scrollPane.setViewportView(tree);
				scrollPane2.setViewportView(table);
			}
		});
		// 리페인트

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
		this.getContentPane().add(splitPane, BorderLayout.CENTER);
		splitPane.setDividerLocation(280);
		// 왼쪽판넬----------------------------------------------
		scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		JToolBar toolBar_1 = new JToolBar();
		scrollPane.setColumnHeaderView(toolBar_1);
		// 툴바------------------------------------------------
		JButton ExpandAll = new JButton("");
		ExpandAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < tree.getRowCount(); i++)
					tree.expandRow(i); // TODO for 없이...
			}
		});
		ExpandAll
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/expanded.gif")));
		ExpandAll.setToolTipText("ExpandAll");
		toolBar_1.add(ExpandAll);
		JButton CollapseAll = new JButton("");
		CollapseAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tree.collapsePath(tree.getPathForRow(0));
			}
		});
		CollapseAll.setToolTipText("CollapseAll");
		CollapseAll
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed.gif")));
		toolBar_1.add(CollapseAll);
		JButton Group = new JButton("");
		Group.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreePath[] tpList = tree.getSelectionPaths();
				if (tpList.length != 0) {
					DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(
							getInput("Enter group name"));
					DefaultMutableTreeNode firstNode = (DefaultMutableTreeNode) tpList[0]
							.getLastPathComponent();
					DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) firstNode
							.getParent();
					int index = parentNode.getIndex(firstNode);
					for (TreePath tp : tpList) {
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) tp
								.getLastPathComponent();
						node.removeFromParent();
						groupNode.add(node);
					}
					parentNode.insert(groupNode, index);
				}
				tree.updateUI();
			}
		});
		Group.setToolTipText("Group");
		Group.setIcon(new ImageIcon(Titan.class
				.getResource("/javax/swing/plaf/metal/icons/ocean/menu.gif")));
		toolBar_1.add(Group);
		JButton UnGroup = new JButton("");
		UnGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreePath[] tpList = tree.getSelectionPaths();
				if (tpList.length == 1) {
					DefaultMutableTreeNode groupNode = (DefaultMutableTreeNode) tpList[0]
							.getLastPathComponent();
					DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) groupNode
							.getParent();
					int index = parentNode.getIndex(groupNode);
					int length = groupNode.getChildCount();
					for (int i = 0; i < length; i++) {
						DefaultMutableTreeNode node = (DefaultMutableTreeNode) groupNode
								.getFirstChild();
						node.removeFromParent();
						parentNode.insert(node, index + i);
					}
					groupNode.removeFromParent();
					;
				}
				tree.updateUI();
			}
		});
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

		JButton NewDsmRow = new JButton("");
		NewDsmRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane
						.showInputDialog("Enter New Row Name");
				dsm.addRow(input);
				cluster.addRow(input);
			}
		});

		JButton ReName = new JButton("");
		ReName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreePath[] tp = tree.getSelectionPaths();
				if (tp.length != 1) {
					showError("Please select one node!");
				} else {
					String name = getInput("Enter new node name:");
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) tp[0]
							.getLastPathComponent();
					dsm.changeRowName(node.toString(), name);
					node.setUserObject(name); // TODO 일단 땜방
					tree.updateUI();
				}
			}
		});
		ReName.setIcon(new ImageIcon(
				Titan.class
						.getResource("/com/sun/javafx/scene/web/skin/FontColor_16x16_JFX.png")));
		ReName.setToolTipText("Rename");
		toolBar_1.add(ReName);

		JButton Delete = new JButton("");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreePath[] tpList = tree.getSelectionPaths();
				for (TreePath tp : tpList) {
					DefaultMutableTreeNode node = (DefaultMutableTreeNode) tp
							.getLastPathComponent();
					try {
						dsm.removeRowName(node.toString());
					} catch (ArrayIndexOutOfBoundsException aioofe) {
						// aioofe.printStackTrace(); //TODO
					}
					node.removeFromParent();
				}
				tree.updateUI();
			}
		});
		Delete.setIcon(new ImageIcon(Titan.class
				.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		Delete.setToolTipText("Delete");
		toolBar_1.add(Delete);
		NewDsmRow
				.setIcon(new ImageIcon(
						Titan.class
								.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		NewDsmRow.setToolTipText("NewDsmRow");
		toolBar_1.add(NewDsmRow);
		// 트리-----------------------------------------------
		tree = new JTree(cluster.getTree());
		scrollPane.setViewportView(tree);
		// 오른쪽 판넬-------------------------------------------
		scrollPane2 = new JScrollPane();
		splitPane.setRightComponent(scrollPane2);
		// 리페인트 리스너 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	}
}