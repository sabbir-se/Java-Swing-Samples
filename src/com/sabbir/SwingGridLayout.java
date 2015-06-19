package com.sabbir;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SwingGridLayout extends JFrame{

	public SwingGridLayout(){
		initUI();
	}
	
	private void initUI() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panel.setLayout(new GridLayout(5, 4, 5, 5));
		
		String[] buttons = {
				"Cls", "Bck", "", "Close", "7", "8", "9", "/", "4",
	            "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"
	    };
		
		for(int i=0; i<buttons.length; i++){
			if(i==2){
				panel.add(new JLabel(buttons[i]));
			}
			else{
				panel.add(new JButton(buttons[i]));
			}
		}
		
		add(panel);
		
		setTitle("Grid Layout");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				SwingGridLayout sgl = new SwingGridLayout();
				sgl.setVisible(true);
			}
		});
	}
}
