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
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


public class GameFrame {

	private static ClientController clientController;
	private JFrame frame;
	private JTextArea textAreaChat;
	private JTextField textToSend;
	private JTextField textFieldNickName;
	private JButton btnConnect;
	private JButton btnDisconnect;
	private JButton btnSend;
	private JLabel move_1;
	private JLabel move_2;
	private JLabel move_3;
	private JLabel move_4;
	private JButton btnSendSequence;
	private JPanel panelChance_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JPanel panelChance_2;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JPanel panelChance_3;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JPanel panelChance_4;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JPanel panelChance_5;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JPanel panelChance_6;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JPanel panelChance_7;
	private JLabel label_24;
	private JLabel label_25;
	private JLabel label_26;
	private JLabel label_27;
	private JPanel panelChance_8;
	private JLabel label_28;
	private JLabel label_29;
	private JLabel label_30;
	private JLabel label_31;

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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panelGame = new JPanel();
		panelGame.setBackground(new Color(51, 153, 51));
		panelGame.setBorder(new TitledBorder(null, "Game", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGame.setBounds(10, 10, 330, 540);
		frame.getContentPane().add(panelGame);
		panelGame.setLayout(null);
		
		panelChance_1 = new JPanel();
		panelChance_1.setLayout(null);
		panelChance_1.setBounds(10, 422, 200, 48);
		panelGame.add(panelChance_1);
		
		label = new JLabel();
		label.setBounds(4, 0, 45, 45);
		panelChance_1.add(label);
		
		label_1 = new JLabel();
		label_1.setBounds(53, 0, 45, 45);
		panelChance_1.add(label_1);
		
		label_2 = new JLabel();
		label_2.setBounds(102, 0, 45, 45);
		panelChance_1.add(label_2);
		
		label_3 = new JLabel();
		label_3.setBounds(151, 0, 45, 45);
		panelChance_1.add(label_3);

		JPanel panelMove = new JPanel();
		panelMove.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelMove.setBounds(10, 494, 200, 35);
		panelGame.add(panelMove);

		move_1 = new JLabel();
		move_1.setBounds(12, 0, 35, 35);
		move_1.addMouseListener(new MouseAdapter() {
			int index = 0;
			@Override
			public void mouseClicked(MouseEvent arg0) {

				move_1.setIcon(Sprite.getColor(index++));
				if (index == 5) {
					index = 0;
				}
			}
		});
		panelMove.setLayout(null);
		move_1.setIcon(null);
		panelMove.add(move_1);

		move_2 = new JLabel();
		move_2.setBounds(59, 0, 35, 35);
		move_2.addMouseListener(new MouseAdapter() {
			int index = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				move_2.setIcon(Sprite.getColor(index++));
				if (index == 5) {
					index = 0;
				}
			}
		});
		move_2.setIcon(null);
		panelMove.add(move_2);

		move_3 = new JLabel();
		move_3.setBounds(106, 0, 35, 35);
		move_3.addMouseListener(new MouseAdapter() {
			int index = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				move_3.setIcon(Sprite.getColor(index++));
				if (index == 5) {
					index = 0;
				}
			}
		});
		move_3.setIcon(null);
		panelMove.add(move_3);

		move_4 = new JLabel();
		move_4.setBounds(153, 0, 35, 35);
		move_4.addMouseListener(new MouseAdapter() {
			int index = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				move_4.setIcon(Sprite.getColor(index++));
				if (index == 5) {
					index = 0;
				}
			}
		});
		move_4.setIcon(null);
		panelMove.add(move_4);
		
		btnSendSequence = new JButton();
		btnSendSequence.setIcon(Sprite.getIconButton(0));
		btnSendSequence.setBounds(214, 494, 35, 35);
		panelGame.add(btnSendSequence);
		
		panelChance_2 = new JPanel();
		panelChance_2.setLayout(null);
		panelChance_2.setBounds(10, 365, 200, 48);
		panelGame.add(panelChance_2);
		
		label_4 = new JLabel();
		label_4.setBounds(4, 0, 45, 45);
		panelChance_2.add(label_4);
		
		label_5 = new JLabel();
		label_5.setBounds(53, 0, 45, 45);
		panelChance_2.add(label_5);
		
		label_6 = new JLabel();
		label_6.setBounds(102, 0, 45, 45);
		panelChance_2.add(label_6);
		
		label_7 = new JLabel();
		label_7.setBounds(151, 0, 45, 45);
		panelChance_2.add(label_7);
		
		panelChance_3 = new JPanel();
		panelChance_3.setLayout(null);
		panelChance_3.setBounds(10, 312, 200, 48);
		panelGame.add(panelChance_3);
		
		label_8 = new JLabel();
		label_8.setBounds(4, 0, 45, 45);
		panelChance_3.add(label_8);
		
		label_9 = new JLabel();
		label_9.setBounds(53, 0, 45, 45);
		panelChance_3.add(label_9);
		
		label_10 = new JLabel();
		label_10.setBounds(102, 0, 45, 45);
		panelChance_3.add(label_10);
		
		label_11 = new JLabel();
		label_11.setBounds(151, 0, 45, 45);
		panelChance_3.add(label_11);
		
		panelChance_4 = new JPanel();
		panelChance_4.setLayout(null);
		panelChance_4.setBounds(10, 255, 200, 48);
		panelGame.add(panelChance_4);
		
		label_12 = new JLabel();
		label_12.setBounds(4, 0, 45, 45);
		panelChance_4.add(label_12);
		
		label_13 = new JLabel();
		label_13.setBounds(53, 0, 45, 45);
		panelChance_4.add(label_13);
		
		label_14 = new JLabel();
		label_14.setBounds(102, 0, 45, 45);
		panelChance_4.add(label_14);
		
		label_15 = new JLabel();
		label_15.setBounds(151, 0, 45, 45);
		panelChance_4.add(label_15);
		
		panelChance_5 = new JPanel();
		panelChance_5.setLayout(null);
		panelChance_5.setBounds(10, 196, 200, 48);
		panelGame.add(panelChance_5);
		
		label_16 = new JLabel();
		label_16.setBounds(4, 0, 45, 45);
		panelChance_5.add(label_16);
		
		label_17 = new JLabel();
		label_17.setBounds(53, 0, 45, 45);
		panelChance_5.add(label_17);
		
		label_18 = new JLabel();
		label_18.setBounds(102, 0, 45, 45);
		panelChance_5.add(label_18);
		
		label_19 = new JLabel();
		label_19.setBounds(151, 0, 45, 45);
		panelChance_5.add(label_19);
		
		panelChance_6 = new JPanel();
		panelChance_6.setLayout(null);
		panelChance_6.setBounds(10, 139, 200, 48);
		panelGame.add(panelChance_6);
		
		label_20 = new JLabel();
		label_20.setBounds(4, 0, 45, 45);
		panelChance_6.add(label_20);
		
		label_21 = new JLabel();
		label_21.setBounds(53, 0, 45, 45);
		panelChance_6.add(label_21);
		
		label_22 = new JLabel();
		label_22.setBounds(102, 0, 45, 45);
		panelChance_6.add(label_22);
		
		label_23 = new JLabel();
		label_23.setBounds(151, 0, 45, 45);
		panelChance_6.add(label_23);
		
		panelChance_7 = new JPanel();
		panelChance_7.setLayout(null);
		panelChance_7.setBounds(10, 82, 200, 48);
		panelGame.add(panelChance_7);
		
		label_24 = new JLabel();
		label_24.setBounds(4, 0, 45, 45);
		panelChance_7.add(label_24);
		
		label_25 = new JLabel();
		label_25.setBounds(53, 0, 45, 45);
		panelChance_7.add(label_25);
		
		label_26 = new JLabel();
		label_26.setBounds(102, 0, 45, 45);
		panelChance_7.add(label_26);
		
		label_27 = new JLabel();
		label_27.setBounds(151, 0, 45, 45);
		panelChance_7.add(label_27);
		
		panelChance_8 = new JPanel();
		panelChance_8.setLayout(null);
		panelChance_8.setBounds(10, 27, 200, 48);
		panelGame.add(panelChance_8);
		
		label_28 = new JLabel();
		label_28.setBounds(4, 0, 45, 45);
		panelChance_8.add(label_28);
		
		label_29 = new JLabel();
		label_29.setBounds(53, 0, 45, 45);
		panelChance_8.add(label_29);
		
		label_30 = new JLabel();
		label_30.setBounds(102, 0, 45, 45);
		panelChance_8.add(label_30);
		
		label_31 = new JLabel();
		label_31.setBounds(151, 0, 45, 45);
		panelChance_8.add(label_31);

		JPanel panelChat = new JPanel();
		panelChat.setBackground(Color.LIGHT_GRAY);
		panelChat.setBorder(new TitledBorder(null, "Chat", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChat.setBounds(350, 140, 330, 410);
		frame.getContentPane().add(panelChat);
		panelChat.setLayout(null);

		btnSend = new JButton("Enviar");
		btnSend.setEnabled(false);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = null;;
				if ((message = textToSend.getText()) != null) {
					clientController.sendMessageToServer(textToSend.getText());
					textAreaChat.setSelectedTextColor(Color.GREEN);
					textAreaChat.append("eu: " + message + "\n");
					textToSend.setText(null);
					textToSend.requestFocus();
				}
			}
		});
		btnSend.setBounds(247, 370, 70, 20);
		panelChat.add(btnSend);

		textToSend = new JTextField();
		textToSend.setEditable(false);
		textToSend.setBounds(15, 370, 230, 20);
		panelChat.add(textToSend);
		textToSend.setColumns(10);

		textAreaChat = new JTextArea();
		textAreaChat.setBounds(15, 100, 300, 250);
		panelChat.add(textAreaChat);
		textAreaChat.setEditable(false);

		textFieldNickName = new JTextField();
		textFieldNickName.setBounds(15, 35, 300, 25);
		panelChat.add(textFieldNickName);
		textFieldNickName.setColumns(10);

		btnConnect = new JButton("Conectar");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldNickName.setEditable(false);
				btnConnect.setEnabled(false);
				btnDisconnect.setEnabled(true);
				btnSend.setEnabled(true);
				textToSend.setEditable(true);
				clientController = new ClientController(GameFrame.this);
				if (!textFieldNickName.getText().isEmpty()) {
					clientController.setNickName(textFieldNickName.getText());
				}
			}
		});
		btnConnect.setBounds(15, 66, 130, 25);
		panelChat.add(btnConnect);

		btnDisconnect = new JButton("Sair");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldNickName.setEditable(true);
				btnConnect.setEnabled(true);
				btnDisconnect.setEnabled(false);
				btnSend.setEnabled(false);
				textToSend.setEditable(false);
				clientController.disconnect();
			}
		});
		btnDisconnect.setEnabled(false);
		btnDisconnect.setBounds(187, 66, 130, 25);
		panelChat.add(btnDisconnect);

		JLabel lblUser = new JLabel("Usu\u00E1rio");
		lblUser.setBounds(15, 21, 46, 14);
		panelChat.add(lblUser);
	}

	public JTextArea getTextAreaChat() {
		return textAreaChat;
	}
}
