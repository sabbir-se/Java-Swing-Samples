package com.sabbir;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class SwingMenu extends JFrame{

	public SwingMenu(){
		initUI();
	}
	
	private void initUI() {
		createMenuBar();
		
		setTitle("Simple Menubar");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		ImageIcon exitIcon = new ImageIcon("resource/exit.png");
		ImageIcon newIcon = new ImageIcon("resource/document_add.png");
		ImageIcon openIcon = new ImageIcon("resource/Open_file.png");
		ImageIcon saveIcon = new ImageIcon("resource/stock_data_save.png");
		
		JMenu subMenu = new JMenu("Import");
		
		JMenuItem subMenuItem = new JMenuItem("Import email..");
		JMenuItem subMenuItem1 = new JMenuItem("Import bookmark..");
		subMenu.add(subMenuItem);
		subMenu.add(subMenuItem1);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		
		JMenuItem newMi = new JMenuItem("New", newIcon);
		newMi.setMnemonic(KeyEvent.VK_N);
        JMenuItem openMi = new JMenuItem("Open", openIcon);
        openMi.setMnemonic(KeyEvent.VK_O);
        JMenuItem saveMi = new JMenuItem("Save", saveIcon);
		saveMi.setMnemonic(KeyEvent.VK_S);
		
        JMenuItem exitMi = new JMenuItem("Exit", exitIcon);
        exitMi.setToolTipText("Exit application");
        exitMi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, 
        		ActionEvent.CTRL_MASK));
        exitMi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
        
		fileMenu.add(newMi);
		fileMenu.add(openMi);
		fileMenu.add(saveMi);
		fileMenu.addSeparator();
		fileMenu.add(subMenu);
		fileMenu.addSeparator();
		fileMenu.add(exitMi);
		
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				SwingMenu sm = new SwingMenu();
				sm.setVisible(true);
			}
		});
	}
}
