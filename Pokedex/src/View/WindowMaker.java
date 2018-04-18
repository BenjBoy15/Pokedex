package View;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JList;
import java.awt.FlowLayout;
import java.awt.Panel;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

import Model.*;
import Controller.*;

public class WindowMaker {

	private JFrame frmPokedexV;
	private JList list;
	private DefaultListModel model = new DefaultListModel<Pokemon>();
	private JPanel pnlLeft, pnlRight, pnlLeftTop, pnlLeftBottom, pnlRightTop, pnlRightBottom, pnlRightBottomBottom, pnlRightBottomTop, pnlLevel, pnlExperience;
	private JButton btnUp, btnDown, btnMusic, btnClose, btnTrain;
	private WindowActionListener listener;
	private GridBagConstraints gbcImg, gbcLvl, gbcXP, gbcName;
	private JLabel lblImage, lblName, lblLevel, lblLevelChart, lblExperience, lblExperienceChart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new WindowMaker();
	}

	/**
	 * Create the application.
	 */
	public WindowMaker() {
		listener = new WindowActionListener(this);
		this.initVar();
		this.fillData();
		this.initialize();
		this.refreshView();
	}
	
	private void fillData() {
		new PokeList();
		
		this.list.setModel(this.model);
		this.list.setCellRenderer(new PokeRenderer());
	}
	
	/**
	 * init variables
	 */
	private void initVar() {
		this.pnlLeft = new JPanel();
		this.pnlLeftTop = new JPanel();
		this.pnlLeftBottom = new JPanel();
		this.pnlRight = new JPanel();
		this.pnlRightTop = new JPanel();
		this.pnlRightBottom = new JPanel();
		this.pnlRightBottomBottom = new JPanel();
		this.pnlRightBottomTop = new JPanel();
		this.pnlLevel = new JPanel();
		this.pnlExperience = new JPanel();
		
		this.lblImage = new JLabel();
		this.lblName = new JLabel();
		this.lblLevel = new JLabel("Level");
		this.lblLevelChart = new JLabel();
		this.lblExperience = new JLabel("Experience");
		this.lblExperienceChart = new JLabel();
		
		this.list = new JList();
		
		this.btnUp = new JButton(new ImageIcon("images/imgUp.jpg"));
		this.btnUp.addActionListener(this.listener);
		
		this.btnDown = new JButton(new ImageIcon("images/imgDown.jpg"));
		this.btnDown.addActionListener(this.listener);
		
		this.btnMusic = new JButton(new ImageIcon("images/imgSound.jpg"));
		this.btnMusic.addActionListener(this.listener);
		
		this.btnClose = new JButton(new ImageIcon("images/imgClose.jpg"));
		this.btnClose.addActionListener(this.listener);
		
		this.btnTrain = new JButton("trainieren");
		this.btnTrain.addActionListener(this.listener);
		
		this.gbcLvl = new GridBagConstraints();
		this.gbcLvl.gridx = 0;
		this.gbcLvl.gridwidth = 2;
		this.gbcLvl.gridy = 0;
		this.gbcLvl.gridheight = 1;
		
		this.gbcXP = new GridBagConstraints();
		this.gbcXP.gridx = 0;
		this.gbcXP.gridwidth = 2;
		this.gbcXP.gridy = 1;
		this.gbcXP.gridheight = 2;
		
		this.gbcImg = new GridBagConstraints();
		this.gbcImg.gridx = 0;
		this.gbcImg.gridwidth = 2;
		this.gbcImg.gridy = 2;
		this.gbcImg.gridheight = 3;
		
		this.gbcName = new GridBagConstraints();
		this.gbcName.gridx = 0;
		this.gbcName.gridwidth = 2;
		this.gbcName.gridy = 5;
		this.gbcName.gridheight = 1;
		
	}

	/**
	 * Initialize the content of the frame
	 */
	private void initialize() {
		frmPokedexV = new JFrame();
		frmPokedexV.setTitle("Pok\u00E9dex V2.0");
		frmPokedexV.setSize(700,500);
		frmPokedexV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPokedexV.setVisible(true);
		
		this.pnlLeftTop.add(new JScrollPane(this.list));
		
		
		this.list.setSelectedIndex(0);
		
		// set up main frame
		frmPokedexV.setLayout(new BorderLayout());
		frmPokedexV.add(this.pnlLeft, BorderLayout.CENTER);
		frmPokedexV.add(this.pnlRight, BorderLayout.EAST);
		
		// set up left panel
		this.pnlLeft.add(this.pnlLeftTop, BorderLayout.CENTER);
		this.pnlLeft.add(this.pnlLeftBottom, BorderLayout.SOUTH);
		
		// set up right panel
		this.pnlRight.add(this.pnlRightTop, BorderLayout.CENTER);
		this.pnlRight.add(this.pnlRightBottom, BorderLayout.SOUTH);
		
		this.pnlLeftTop.setLayout(new GridLayout(1, 1));
		
		this.pnlLeftBottom.setLayout(new GridLayout(1, 2));
		this.pnlLeftBottom.add(this.btnUp);
		this.pnlLeftBottom.add(this.btnDown);
		
		this.pnlRightBottom.setLayout(new BorderLayout());
		this.pnlRightBottom.add(this.pnlRightBottomTop, BorderLayout.NORTH);
		this.pnlRightBottom.add(this.pnlRightBottomBottom, BorderLayout.SOUTH);
		
		this.pnlRightBottomTop.setLayout(new GridLayout(1, 1));
		this.pnlRightBottomTop.add(this.btnTrain);
		
		this.pnlRightBottomBottom.setLayout(new GridLayout(1, 2));
		this.pnlRightBottomBottom.add(this.btnMusic);
		this.pnlRightBottomBottom.add(this.btnClose);
		
		this.pnlLevel.setLayout(new GridLayout(2, 1));
		this.pnlLevel.add(this.lblLevel);
		this.pnlLevel.add(this.lblLevelChart);
		
		this.pnlExperience.setLayout(new GridLayout(2, 1));
		this.pnlExperience.add(this.lblExperience);
		this.pnlExperience.add(this.lblExperienceChart);
		
		this.pnlRightTop.setLayout(new GridBagLayout());
		this.pnlRightTop.add(this.pnlLevel, this.gbcLvl);
		this.pnlRightTop.add(this.pnlExperience, this.gbcXP);
		this.pnlRightTop.add(this.lblImage, this.gbcImg);
		this.pnlRightTop.add(this.lblName, this.gbcName);
	}
	
	
	/**
	 * return all Action Buttons
	 * @return
	 */
	public JButton[] getAllButtons() {
		JButton[] buttons = {this.btnUp, this.btnDown, this.btnMusic, this.btnClose, this.btnTrain};
		return buttons;
	}
	
	/**
	 * @return JList of the View
	 */
	public JList getList() {
		return this.list;
	}
	
	
	/**
	 * refresh view Data
	 */
	public void refreshView() {
		int selectedIndex = this.list.getSelectedIndex();
		if(selectedIndex == -1) {
			selectedIndex = 0;
		}
		/** Clears and reload the list */
		this.model.clear();
		for(Pokemon p : PokeList.getAll()) {			
			this.model.addElement(p);
		}
		
		this.lblImage.setIcon(new ImageIcon(PokeList.getSelectedPokemon().getImageLink()));
		this.lblName.setText(PokeList.getSelectedPokemon().getName());
		this.lblLevelChart.setText(Integer.toString(PokeList.getSelectedPokemon().getLevel()));
		this.lblExperienceChart.setText(Integer.toString(PokeList.getSelectedPokemon().getExperiencePoints()));

		
		this.list.setSelectedIndex(selectedIndex);
	}
}
