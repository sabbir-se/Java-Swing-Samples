package com.sabbir;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SwingButton extends JFrame{

	public SwingButton(){
		initButtonUI();
	}
	
	private void initButtonUI() {
		JButton btn = new JButton("Quit");
		btn.setToolTipText("A button component");
		
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		createLayout(btn);
		initUI("Quit Button");
	}

	private void createLayout(JButton btn) {
		JPanel pane = (JPanel) getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                	.addComponent(btn)
                	.addGap(200)
                );

        gl.setVerticalGroup(gl.createSequentialGroup()
                	.addComponent(btn)
                	.addGap(150)
                );
	}

	private void initUI(String msg){
		setTitle(msg);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				SwingButton swingMain = new SwingButton();
				swingMain.setVisible(true);
			}
		});
	}
}
