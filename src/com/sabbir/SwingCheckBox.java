package com.sabbir;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

@SuppressWarnings("serial")
public class SwingCheckBox extends JFrame{

	private JLabel statusBar;
	
	public SwingCheckBox(){
		initUI();
	}
	
	private void initUI() {
		createCheckBox();
		
		statusBar = new JLabel("Ready");
		statusBar.setBorder(BorderFactory.createEtchedBorder());
		add(statusBar, BorderLayout.SOUTH);
		
		setTitle("Check Box");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createCheckBox() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		JMenu view = new JMenu("View");
		view.setMnemonic(KeyEvent.VK_V);
		
		JCheckBoxMenuItem chI = new JCheckBoxMenuItem("Show Statusbar");
		chI.setMnemonic(KeyEvent.VK_S);
		chI.setSelected(true);
		
		chI.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					statusBar.setVisible(true);
				}
				else{
					statusBar.setVisible(false);
				}
			}
		});
		view.add(chI);
		
		menuBar.add(file);
		menuBar.add(view);
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(help);
		
		setJMenuBar(menuBar);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				SwingCheckBox ch = new SwingCheckBox();
				ch.setVisible(true);
			}
		});
	}
}
