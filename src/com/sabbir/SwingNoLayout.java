package com.sabbir;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SwingNoLayout extends JFrame{

	public SwingNoLayout(){
		initUI();
	}
	
	private void initUI() {
		setLayout(null);
		
		JButton ok = new JButton("Ok");
		ok.setBounds(50, 50, 80, 25);
		
		JButton no = new JButton("No");
		no.setBounds(150, 50, 80, 25);
		
		add(ok);
		add(no);
		
		setTitle("Without Layout");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				SwingNoLayout sl = new SwingNoLayout();
				sl.setVisible(true);
			}
		});
	}
}
