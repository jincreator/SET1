package set1;


import java.awt.EventQueue;

import javax.swing.AbstractAction;
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
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTree;
import javax.swing.JTable;

import set1.action.*;

public class Titan {
	public JFrame frmTitan;
	private JTable table;
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
		frmTitan = new JFrame();
		frmTitan.setTitle("소프트웨어 공학 1조");
		frmTitan.setBounds(100, 100, 800, 600);
		frmTitan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmTitan.setJMenuBar(menuBar);
		//file menu-------------------------------------------
		JMenu FIle = new JMenu("File");
		menuBar.add(FIle);
		NewDSM ND =new NewDSM();
		FIle.add(ND.NewDSM);
		OpenDSM OD =new OpenDSM();
		FIle.add(OD.FileOpenDSM);
		JSeparator separator = new JSeparator();
		FIle.add(separator);
		NewCluster NC=new NewCluster();
		FIle.add(NC.FileNewClustering);
		LoadCluster LC=new LoadCluster();
		FIle.add(LC.FileLoadClustering);
		JSeparator separator_1 = new JSeparator();
		FIle.add(separator_1);
		SaveCluster SC=new SaveCluster();
		FIle.add(SC.FileSaveClustering);
		SaveClusterAs SCA=new SaveClusterAs();
		FIle.add(SCA.FileSaveClusteringAs);
		JSeparator separator_2 = new JSeparator();
		FIle.add(separator_2);
		Exit Ex = new Exit();
		FIle.add(Ex.Exit);
		//View ---------------------------------------------
		JMenu View = new JMenu("View");
		menuBar.add(View);
		Redraw Re = new Redraw();
		View.add(Re.ViewRedraw);
		ShowLowLabel SLL = new ShowLowLabel();
		View.add(SLL.ShowLowLabels);
		//Help-----------------------------------------------
		JMenu Help = new JMenu("Help");
		menuBar.add(Help);
		About Ab= new About();
		Help.add(Ab.About);
		//Toolbar--------------------------------------------
		JToolBar toolBar = new JToolBar();
		frmTitan.getContentPane().add(toolBar, BorderLayout.NORTH);
		toolBar.add(OD.OpenDSM);
		toolBar.add(Re.Redraw);
		toolBar.add(NC.NewCluster);
		toolBar.add(LC.LoadCluster);
		toolBar.add(SC.SaveCluster);
		toolBar.add(SCA.SaveClusterAs);
		
		JSplitPane splitPane = new JSplitPane();
		frmTitan.getContentPane().add(splitPane, BorderLayout.CENTER);
		//왼쪽판넬----------------------------------------------
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		JToolBar toolBar_1 = new JToolBar();
		scrollPane.setColumnHeaderView(toolBar_1);
		//툴바------------------------------------------------
		ExpandAll EA=new ExpandAll();
		toolBar_1.add(EA.ExpandAll);
		CollapseAll CA=new CollapseAll();
		toolBar_1.add(CA.CollapseAll);
		Group G=new Group();
		toolBar_1.add(G.Group);
		UnGroup UG=new UnGroup();
		toolBar_1.add(UG.UnGroup);
		MoveUp MU=new MoveUp();
		toolBar_1.add(MU.MoveUp);
		MoveDown MD=new MoveDown();
		toolBar_1.add(MD.MoveDown);
		//트리-----------------------------------------------
		JTree tree = new JTree();
		scrollPane.setViewportView(tree);
		//오른쪽 판넬-------------------------------------------
		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);
		//테이블----------------------------------------------
		table = new JTable();
		scrollPane_1.setViewportView(table);
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
