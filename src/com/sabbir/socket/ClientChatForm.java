package com.sabbir.socket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ClientChatForm extends JFrame implements ActionListener{

	private static Socket con;
	JPanel panel;
	JTextField newMsg;
	JTextArea chatHis;
	JButton send;
	DataInputStream dis;
	DataOutputStream dos;
	
	public ClientChatForm() throws UnknownHostException, IOException{
		panel = new JPanel();
		newMsg = new JTextField();
		chatHis = new JTextArea();
		send = new JButton("Send");
		
		setTitle("Client");
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		add(panel);
		
		chatHis.setBounds(20, 20, 450, 360);
		newMsg.setBounds(20, 400, 340, 30);
		send.setBounds(375, 400, 95, 30);
		
		panel.add(chatHis);
		panel.add(newMsg);
		panel.add(send);
		
		con = new Socket(InetAddress.getLocalHost(), 2000);
		/*for remote pc use ip address of server with function                                 
		InetAddress.getByName("Provide ip here")
		ChatHistory.setText("Connected to Server");
		*/
		
		chatHis.setText("Connected to Server.");
		send.addActionListener(this);
		while(true){
			try{
				dis = new DataInputStream(con.getInputStream());
				String msg = dis.readUTF();
				chatHis.setText(chatHis.getText() + "\n" + "Server:" + msg);
			
			} catch(Exception e1){
				chatHis.setText(chatHis.getText() + "\n" + "Message sending fail:Network Error");
				
				try {
					Thread.sleep(3000);
					System.exit(0);
				
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if((e.getSource() == send) && (newMsg.getText() != null)){
			chatHis.setText(chatHis.getText()+ "\n" + "Me:" + newMsg.getText());
			
			try{
				dos = new DataOutputStream(con.getOutputStream());
				dos.writeUTF(newMsg.getText());
				
			} catch(Exception e1){
				try {
					Thread.sleep(3000);
				    System.exit(0);
				    
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
			}
			newMsg.setText("");
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		new ClientChatForm();
	}
}
