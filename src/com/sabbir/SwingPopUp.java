package com.sabbir;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

@SuppressWarnings("serial")
public class SwingPopUp extends JFrame{

	private JPopupMenu puMenu;
	
	public SwingPopUp(){
		initUI();
	}
	
	private void initUI() {
		createLayout();
		
		setTitle("Pop Up Menu");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createLayout() {
		puMenu = new JPopupMenu();
		
		JMenuItem maxI = new JMenuItem("Maximize");
		maxI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getExtendedState() != JFrame.MAXIMIZED_BOTH){
					setExtendedState(JFrame.MAXIMIZED_BOTH);
				}
			}
		});
		puMenu.add(maxI);
		
		JMenuItem quitI = new JMenuItem("Quit");
		quitI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		puMenu.add(quitI);
		
		addMouseListener(new MouseAdapter() {
			@Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    puMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
		});
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				SwingPopUp px = new SwingPopUp();
				px.setVisible(true);
			}
		});
	}
}
