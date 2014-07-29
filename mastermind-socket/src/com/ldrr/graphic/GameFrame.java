package com.ldrr.graphic;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.ldrr.chat.client.ClientController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class GameFrame {

	private static ClientController clientController;
	private JFrame frame;
	private JTextArea textAreaChat;
	private JTextField textToSend;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame window = new GameFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public GameFrame() {
		initialize();
		clientController = new ClientController(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Game", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 332, 540);
		frame.getContentPane().add(panel);
		
		JPanel panelChat = new JPanel();
		panelChat.setBorder(new TitledBorder(null, "Chat", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChat.setBounds(352, 214, 327, 337);
		frame.getContentPane().add(panelChat);
		panelChat.setLayout(null);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = null;;
				if ((message = textToSend.getText()) != null) {
					clientController.sendMessage(textToSend.getText());
					textAreaChat.append("eu: " + message + "\n");
					textToSend.setText(null);
					textToSend.requestFocus();
				}
			}
		});
		btnNewButton.setBounds(244, 297, 70, 20);
		panelChat.add(btnNewButton);
		
		textToSend = new JTextField();
		textToSend.setBounds(12, 297, 229, 20);
		panelChat.add(textToSend);
		textToSend.setColumns(10);
		
		textAreaChat = new JTextArea();
		textAreaChat.setBounds(12, 27, 300, 250);
		panelChat.add(textAreaChat);
		textAreaChat.setEditable(false);
	}
	
	public JTextArea getTextAreaChat() {
		return textAreaChat;
	}
}
