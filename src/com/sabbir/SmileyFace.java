package com.sabbir;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class SmileyFace{
	
	final Font f = new Font(Font.SERIF, Font.PLAIN, 18);
	
	public SmileyFace(){
		JFrame frame = new JFrame("");
		MyPanel panel = new MyPanel(); 
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new SmileyFace();
			}
		});
	}
	
	@SuppressWarnings("serial")
	public class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
		    
		    super.paintComponent(g);
		  
		    int height = getHeight();
		    int width  = getWidth();
		    
		    // draw face that takes up 80% of the JPanel
		    int faceTop  = height/10;
		    int faceLeft = width/10;
		    int faceHeight = height - height/5;
		    int faceWidth  = width  - width/5;
		    
		    
		    // outline
		    g.setColor(Color.yellow);
		    g.fillOval(faceLeft, faceTop, faceWidth, faceHeight);
		    
		    // eyes
		    g.setColor(Color.black);
		    g.fillOval(faceLeft+(int)(width*0.2), faceTop+(int)(height*0.2),
		                width/10, height/10);
		    g.fillOval(faceLeft+(int)(width*0.5), faceTop+(int)(height*0.2),
		                width/10, height/10);
		    
		    // mouth
		    /*g.drawArc(faceLeft+(int)(width*0.25), faceTop+(int)(height*0.5),
		               (int)(width*0.3), (int)(height*0.2),
		               0, -180);*/
		    
		    g.drawArc(faceLeft+(int)(width*0.2), faceTop+(int)(height*0.46),
		               (int)(width*0.4), (int)(height*0.20),
		               0, -180);
		    
		    g.setColor(Color.blue);
		    g.setFont(f);
		    drawCenteredString("Hello my name is Sabbir", width, height-10, g);
		}
		
		public void drawCenteredString(String s, int w, int h, Graphics g) {
		    FontMetrics fm = g.getFontMetrics();
		    int x = (w - fm.stringWidth(s)) / 2;
		    int y = h;
		    g.drawString(s, x, y);
		}
	}
}