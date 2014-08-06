package com.ldrr.graphic;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.TransferHandler;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.ldrr.client.ClientController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;

import java.awt.event.MouseEvent;

import javax.swing.UIManager;

import java.awt.event.MouseMotionAdapter;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JScrollPane;

public class GameFrame {

	private ClientController clientController;
	private Sprite sprite;
	private JFrame frmMastermindGame;
	private JTextArea textAreaChat;
	private JTextArea textToSend;
	private boolean challenging;
	private boolean myTurn;
	private boolean firstMoviment = true;
	private JButton btnConnect;
	private JButton btnDisconnect;
	private JLabel move_1;
	private JLabel move_2;
	private JLabel move_3;
	private JLabel move_4;
	private JButton btnSendSequence;
	private JLabel[][] arrayLabelsSequence = new JLabel[10][4];
	private JLabel[][] arrayLabelsResponse = new JLabel[10][4];
	private int[] sequenceToSend = new int[4];
	private int index_move = 0;
	private JLabel lblPassword1;
	private JLabel lblPassword2;
	private JLabel lblPassword3;
	private JLabel lblPassword4;
	private int[] password;
	private JPanel panelBalls;
	private JLabel colorLabel2;
	private JLabel colorLabel1;
	private JLabel colorLabel3;
	private JLabel colorLabel4;
	private JLabel colorLabel5;
	private JLabel colorLabel6;
	private JPanel panelMyAvatar;
	private JPanel panelEnemyAvatar;

	/**
	 * Create the application.
	 */
	public GameFrame(boolean challenging) {
		this.sprite = new Sprite();
		initialize();
		initGame(challenging);
	}

	private void initGame(boolean challenging) {
		this.challenging = challenging;
		this.myTurn = !challenging;
		this.frmMastermindGame.setVisible(true);
		this.clientController = new ClientController(GameFrame.this);
		if (challenging) {
			String address = JOptionPane
					.showInputDialog("Insira o endereço de quem deseja desafiar.");
			int port = Integer.parseInt(JOptionPane
					.showInputDialog("Em qual sala ele está?"));
			this.clientController.initGame(address, port);
			this.clientController.initChat(address, port-1000);
		} else {
			this.clientController.initGame();
			this.clientController.initChat();
		}
		if (JOptionPane.showConfirmDialog(null, "Gostaria de se conectar automaticamente ao chat?") == JOptionPane.OK_OPTION) {
			String nickname = JOptionPane.showInputDialog(null, "Insira o nome de usuário:");
			if (nickname.isEmpty()) {
				clientController.setNickName("Eu");
			}else{
				clientController.setNickName(nickname);
			}
			panelMyAvatar.setBorder(new TitledBorder(null, nickname, TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
			btnConnect.setEnabled(false);
			btnDisconnect.setEnabled(true);
			textToSend.setEnabled(true);
			textToSend.setEditable(true);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMastermindGame = new JFrame();
		frmMastermindGame.setResizable(false);
		frmMastermindGame.setTitle("MasterMind Game");
		frmMastermindGame.setBounds(100, 100, 524, 710);
		frmMastermindGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMastermindGame.getContentPane().setLayout(null);

		JPanel panelGame = new JPanel();
		panelGame.setBorder(new TitledBorder(null, "Game",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGame.setBounds(6, 6, 253, 660);
		frmMastermindGame.getContentPane().add(panelGame);
		panelGame.setLayout(null);

		JPanel panelChance_1 = new JPanel();
		panelChance_1.setLayout(null);
		panelChance_1.setBorder(new TitledBorder(null, "1\u00BA Chance",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_1.setBounds(16, 583, 160, 60);
		panelGame.add(panelChance_1);

		JLabel labelChance11 = new JLabel();
		labelChance11.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance11, index_move, 0);
		panelChance_1.add(labelChance11);

		JLabel labelChance12 = new JLabel();
		labelChance12.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance12, index_move, 1);
		panelChance_1.add(labelChance12);

		JLabel labelChance13 = new JLabel();
		labelChance13.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance13, index_move, 2);
		panelChance_1.add(labelChance13);

		JLabel labelChance14 = new JLabel();
		labelChance14.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance14, index_move++, 3);
		panelChance_1.add(labelChance14);

		JPanel panelChance_2 = new JPanel();
		panelChance_2.setLayout(null);
		panelChance_2.setBorder(new TitledBorder(null, "2\u00BA Chance",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_2.setBounds(16, 527, 160, 60);
		panelGame.add(panelChance_2);

		JLabel labelChance21 = new JLabel();
		labelChance21.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance21, index_move, 0);
		panelChance_2.add(labelChance21);

		JLabel labelChance22 = new JLabel();
		labelChance22.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance22, index_move, 1);
		panelChance_2.add(labelChance22);

		JLabel labelChance23 = new JLabel();
		labelChance23.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance23, index_move, 2);
		panelChance_2.add(labelChance23);

		JLabel labelChance24 = new JLabel();
		labelChance24.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance24, index_move++, 3);
		panelChance_2.add(labelChance24);

		JPanel panelChance_3 = new JPanel();
		panelChance_3.setLayout(null);
		panelChance_3.setBorder(new TitledBorder(null, "3\u00BA Chance",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_3.setBounds(16, 472, 160, 60);
		panelGame.add(panelChance_3);

		JLabel labelChance31 = new JLabel();
		labelChance31.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance31, index_move,0);
		panelChance_3.add(labelChance31);

		JLabel labelChance32 = new JLabel();
		labelChance32.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance32, index_move, 1);
		panelChance_3.add(labelChance32);

		JLabel labelChance33 = new JLabel();
		labelChance33.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance33, index_move, 2);
		panelChance_3.add(labelChance33);

		JLabel labelChance34 = new JLabel();
		labelChance34.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance34, index_move++, 3);
		panelChance_3.add(labelChance34);

		JPanel panelChance_4 = new JPanel();
		panelChance_4.setLayout(null);
		panelChance_4.setBorder(new TitledBorder(null, "4\u00BA Chance",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_4.setBounds(16, 416, 160, 60);
		panelGame.add(panelChance_4);

		JLabel labelChance41 = new JLabel();
		labelChance41.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance41, index_move, 0);
		panelChance_4.add(labelChance41);

		JLabel labelChance42 = new JLabel();
		labelChance42.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance42, index_move, 1);
		panelChance_4.add(labelChance42);

		JLabel labelChance43 = new JLabel();
		labelChance43.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance43, index_move, 2);
		panelChance_4.add(labelChance43);

		JLabel labelChance44 = new JLabel();
		labelChance44.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance44, index_move++, 3);
		panelChance_4.add(labelChance44);

		JPanel panelChance_5 = new JPanel();
		panelChance_5.setLayout(null);
		panelChance_5.setBorder(new TitledBorder(null, "5\u00BA Chance",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_5.setBounds(16, 361, 160, 60);
		panelGame.add(panelChance_5);

		JLabel labelChance51 = new JLabel();
		labelChance51.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance51, index_move, 0);
		panelChance_5.add(labelChance51);

		JLabel labelChance52 = new JLabel();
		labelChance52.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance52, index_move, 1);
		panelChance_5.add(labelChance52);

		JLabel labelChance53 = new JLabel();
		labelChance53.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance53, index_move, 2);
		panelChance_5.add(labelChance53);

		JLabel labelChance54 = new JLabel();
		labelChance54.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance54, index_move++, 3);
		panelChance_5.add(labelChance54);

		JPanel panelChance_6 = new JPanel();
		panelChance_6.setLayout(null);
		panelChance_6.setBorder(new TitledBorder(null, "6\u00BA Chance",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_6.setBounds(16, 306, 160, 60);
		panelGame.add(panelChance_6);

		JLabel labelChance61 = new JLabel();
		labelChance61.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance61, index_move, 0);
		panelChance_6.add(labelChance61);

		JLabel labelChance62 = new JLabel();
		labelChance62.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance62, index_move, 1);
		panelChance_6.add(labelChance62);

		JLabel labelChance63 = new JLabel();
		labelChance63.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance63, index_move, 2);
		panelChance_6.add(labelChance63);

		JLabel labelChance64 = new JLabel();
		labelChance64.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance64, index_move++, 3);
		panelChance_6.add(labelChance64);

		JPanel panelChance_7 = new JPanel();
		panelChance_7.setLayout(null);
		panelChance_7.setBorder(new TitledBorder(null, "7\u00BA Chance",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_7.setBounds(16, 250, 160, 60);
		panelGame.add(panelChance_7);

		JLabel labelChance71 = new JLabel();
		labelChance71.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance71, index_move, 0);
		panelChance_7.add(labelChance71);

		JLabel labelChance72 = new JLabel();
		labelChance72.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance72, index_move, 1);
		panelChance_7.add(labelChance72);

		JLabel labelChance73 = new JLabel();
		labelChance73.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance73, index_move, 2);
		panelChance_7.add(labelChance73);

		JLabel labelChance74 = new JLabel();
		labelChance74.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance74, index_move++, 3);
		panelChance_7.add(labelChance74);

		JPanel panelChance_8 = new JPanel();
		panelChance_8.setLayout(null);
		panelChance_8.setBorder(new TitledBorder(null, "8\u00BA Chance",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_8.setBounds(16, 194, 160, 60);
		panelGame.add(panelChance_8);

		JLabel labelChance81 = new JLabel();
		labelChance81.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance81, index_move, 0);
		panelChance_8.add(labelChance81);

		JLabel labelChance82 = new JLabel();
		labelChance82.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance82, index_move, 1);
		panelChance_8.add(labelChance82);

		JLabel labelChance83 = new JLabel();
		labelChance83.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance83, index_move, 2);
		panelChance_8.add(labelChance83);

		JLabel labelChance84 = new JLabel();
		labelChance84.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance84, index_move++, 3);
		panelChance_8.add(labelChance84);

		JPanel panelChance_9 = new JPanel();
		panelChance_9.setLayout(null);
		panelChance_9.setBorder(new TitledBorder(null, "9\u00BA Chance",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_9.setBounds(16, 138, 160, 60);
		panelGame.add(panelChance_9);

		JLabel labelChance91 = new JLabel();
		labelChance91.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance91, index_move, 0);
		panelChance_9.add(labelChance91);

		JLabel labelChance92 = new JLabel();
		labelChance92.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance92, index_move, 1);
		panelChance_9.add(labelChance92);

		JLabel labelChance93 = new JLabel();
		labelChance93.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance93, index_move, 2);
		panelChance_9.add(labelChance93);

		JLabel labelChance94 = new JLabel();
		labelChance94.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance94, index_move++, 3);
		panelChance_9.add(labelChance94);

		JPanel panelChance_10 = new JPanel();
		panelChance_10.setLayout(null);
		panelChance_10.setBorder(new TitledBorder(null, "10\u00BA Chance",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_10.setBounds(16, 84, 160, 60);
		panelGame.add(panelChance_10);

		JLabel labelChance101 = new JLabel();
		labelChance101.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance101, index_move, 0);
		panelChance_10.add(labelChance101);

		JLabel labelChance102 = new JLabel();
		labelChance102.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance102, index_move, 1);
		panelChance_10.add(labelChance102);

		JLabel labelChance103 = new JLabel();
		labelChance103.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance103, index_move, 2);
		panelChance_10.add(labelChance103);

		JLabel labelChance104 = new JLabel();
		labelChance104.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance104, index_move, 3);
		panelChance_10.add(labelChance104);
		index_move = 0;

		JPanel panelEvalue = new JPanel();
		panelEvalue.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelEvalue.setBounds(192, 101, 45, 540);
		panelGame.add(panelEvalue);
		panelEvalue.setLayout(null);

		JPanel panelEvalueR1 = new JPanel();
		panelEvalueR1.setBorder(new TitledBorder(null, "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEvalueR1.setBounds(6, 503, 33, 31);
		panelEvalue.add(panelEvalueR1);
		panelEvalueR1.setLayout(null);

		JLabel label_40 = new JLabel();
		label_40.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_40, index_move, 0);
		panelEvalueR1.add(label_40);

		JLabel label_41 = new JLabel();
		label_41.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_41, index_move, 1);
		panelEvalueR1.add(label_41);

		JLabel label_42 = new JLabel();
		label_42.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_42, index_move, 2);
		panelEvalueR1.add(label_42);

		JLabel label_43 = new JLabel();
		label_43.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_43, index_move++, 3);
		panelEvalueR1.add(label_43);

		JPanel panelEvalueR2 = new JPanel();
		panelEvalueR2.setLayout(null);
		panelEvalueR2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelEvalueR2.setBounds(6, 449, 33, 31);
		panelEvalue.add(panelEvalueR2);

		JLabel label_44 = new JLabel();
		label_44.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_44, index_move, 0);
		panelEvalueR2.add(label_44);

		JLabel label_45 = new JLabel();
		label_45.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_45, index_move, 1);
		panelEvalueR2.add(label_45);

		JLabel label_46 = new JLabel();
		label_46.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_46, index_move, 2);
		panelEvalueR2.add(label_46);

		JLabel label_47 = new JLabel();
		label_47.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_47, index_move++, 3);
		panelEvalueR2.add(label_47);

		JPanel panelEvalueR3 = new JPanel();
		panelEvalueR3.setLayout(null);
		panelEvalueR3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelEvalueR3.setBounds(6, 393, 33, 31);
		panelEvalue.add(panelEvalueR3);

		JLabel label_48 = new JLabel();
		label_48.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_48, index_move, 0);
		panelEvalueR3.add(label_48);

		JLabel label_49 = new JLabel();
		label_49.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_49, index_move, 1);
		panelEvalueR3.add(label_49);

		JLabel label_50 = new JLabel();
		label_50.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_50, index_move, 2);
		panelEvalueR3.add(label_50);

		JLabel label_51 = new JLabel();
		label_51.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_51, index_move++, 3);
		panelEvalueR3.add(label_51);

		JPanel panelEvalueR4 = new JPanel();
		panelEvalueR4.setLayout(null);
		panelEvalueR4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelEvalueR4.setBounds(6, 337, 33, 31);
		panelEvalue.add(panelEvalueR4);

		JLabel label_52 = new JLabel();
		label_52.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_52, index_move, 0);
		panelEvalueR4.add(label_52);

		JLabel label_53 = new JLabel();
		label_53.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_53, index_move, 1);
		panelEvalueR4.add(label_53);

		JLabel label_54 = new JLabel();
		label_54.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_54, index_move, 2);
		panelEvalueR4.add(label_54);

		JLabel label_55 = new JLabel();
		label_55.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_55, index_move++, 3);
		panelEvalueR4.add(label_55);

		JPanel panelEvalueR5 = new JPanel();
		panelEvalueR5.setLayout(null);
		panelEvalueR5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelEvalueR5.setBounds(6, 282, 33, 31);
		panelEvalue.add(panelEvalueR5);

		JLabel label_56 = new JLabel();
		label_56.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_56, index_move, 0);
		panelEvalueR5.add(label_56);

		JLabel label_57 = new JLabel();
		label_57.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_57, index_move, 1);
		panelEvalueR5.add(label_57);

		JLabel label_58 = new JLabel();
		label_58.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_58, index_move, 2);
		panelEvalueR5.add(label_58);

		JLabel label_59 = new JLabel();
		label_59.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_59, index_move++, 3);
		panelEvalueR5.add(label_59);

		JPanel panelEvalueR6 = new JPanel();
		panelEvalueR6.setLayout(null);
		panelEvalueR6.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelEvalueR6.setBounds(6, 225, 33, 31);
		panelEvalue.add(panelEvalueR6);

		JLabel label_60 = new JLabel();
		label_60.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_60, index_move, 0);
		panelEvalueR6.add(label_60);

		JLabel label_61 = new JLabel();
		label_61.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_61, index_move, 1);
		panelEvalueR6.add(label_61);

		JLabel label_62 = new JLabel();
		label_62.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_62, index_move, 2);
		panelEvalueR6.add(label_62);

		JLabel label_63 = new JLabel();
		label_63.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_63, index_move++, 3);
		panelEvalueR6.add(label_63);

		JPanel panelEvalueR7 = new JPanel();
		panelEvalueR7.setLayout(null);
		panelEvalueR7.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelEvalueR7.setBounds(6, 171, 33, 31);
		panelEvalue.add(panelEvalueR7);

		JLabel label_64 = new JLabel();
		label_64.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_64, index_move, 0);
		panelEvalueR7.add(label_64);

		JLabel label_65 = new JLabel();
		label_65.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_65, index_move, 1);
		panelEvalueR7.add(label_65);

		JLabel label_66 = new JLabel();
		label_66.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_66, index_move, 2);
		panelEvalueR7.add(label_66);

		JLabel label_67 = new JLabel();
		label_67.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_67, index_move++, 3);
		panelEvalueR7.add(label_67);

		JPanel panelEvalueR8 = new JPanel();
		panelEvalueR8.setLayout(null);
		panelEvalueR8.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelEvalueR8.setBounds(6, 116, 33, 31);
		panelEvalue.add(panelEvalueR8);

		JLabel label_68 = new JLabel();
		label_68.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_68, index_move, 0);
		panelEvalueR8.add(label_68);

		JLabel label_69 = new JLabel();
		label_69.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_69, index_move, 1);
		panelEvalueR8.add(label_69);

		JLabel label_70 = new JLabel();
		label_70.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_70, index_move, 2);
		panelEvalueR8.add(label_70);

		JLabel label_71 = new JLabel();
		label_71.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_71, index_move++, 3);
		panelEvalueR8.add(label_71);

		JPanel panelEvalueR9 = new JPanel();
		panelEvalueR9.setLayout(null);
		panelEvalueR9.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelEvalueR9.setBounds(6, 57, 33, 31);
		panelEvalue.add(panelEvalueR9);

		JLabel label_72 = new JLabel();
		label_72.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_72, index_move, 0);
		panelEvalueR9.add(label_72);

		JLabel label_73 = new JLabel();
		label_73.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_73, index_move, 1);
		panelEvalueR9.add(label_73);

		JLabel label_74 = new JLabel();
		label_74.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_74, index_move, 2);
		panelEvalueR9.add(label_74);

		JLabel label_75 = new JLabel();
		label_75.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_75, index_move++, 3);
		panelEvalueR9.add(label_75);

		JPanel panelEvalueR10 = new JPanel();
		panelEvalueR10.setLayout(null);
		panelEvalueR10.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panelEvalueR10.setBounds(6, 6, 33, 31);
		panelEvalue.add(panelEvalueR10);

		JLabel label_76 = new JLabel();
		label_76.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_76, index_move, 0);
		panelEvalueR10.add(label_76);

		JLabel label_77 = new JLabel();
		label_77.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_77, index_move, 1);
		panelEvalueR10.add(label_77);

		JLabel label_78 = new JLabel();
		label_78.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_78, index_move, 2);
		panelEvalueR10.add(label_78);

		JLabel label_79 = new JLabel();
		label_79.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_79, index_move++, 3);
		panelEvalueR10.add(label_79);

		JPanel panelPassword = new JPanel();
		panelPassword.setBounds(18, 27, 219, 60);
		panelGame.add(panelPassword);
		panelPassword.setBorder(new TitledBorder(null, "Senha",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPassword.setLayout(null);

		lblPassword1 = new JLabel();
		lblPassword1.setBounds(15, 22, 35, 35);
		lblPassword1.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		panelPassword.add(lblPassword1);

		lblPassword2 = new JLabel();
		lblPassword2.setBounds(65, 22, 35, 35);
		lblPassword2.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		panelPassword.add(lblPassword2);

		lblPassword3 = new JLabel();
		lblPassword3.setBounds(115, 22, 35, 35);
		lblPassword3.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		panelPassword.add(lblPassword3);

		lblPassword4 = new JLabel();
		lblPassword4.setBounds(165, 22, 35, 35);
		lblPassword4.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		panelPassword.add(lblPassword4);
		index_move = 0;

		JPanel panelChat = new JPanel();
		panelChat.setBorder(new TitledBorder(null, "Chat",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panelChat.setBounds(272, 6, 240, 480);
		frmMastermindGame.getContentPane().add(panelChat);
		panelChat.setLayout(null);

		textToSend = new JTextArea();
		textToSend.setLineWrap(true);
		textToSend.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER) {
					if (!textToSend.getText().isEmpty()) {
						clientController.sendMessageChat(textToSend.getText());
						textAreaChat.append("eu: " + textToSend.getText() + "\n");
						textToSend.setText(null);
						textToSend.requestFocus();
					}
				}
			}
		});

		textToSend.setEnabled(false);
		textToSend.setEditable(false);
		textToSend.setBounds(15, 427, 210, 40);
		textToSend.setColumns(10);
		//panelChat.add(textToSend);

		JScrollPane scrollPaneTextToSend = new JScrollPane(textToSend);
		scrollPaneTextToSend.setBounds(15, 427, 210, 40);
		scrollPaneTextToSend.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelChat.add(scrollPaneTextToSend);

		textAreaChat = new JTextArea();
		textAreaChat.setLineWrap(true);
		textAreaChat.setEnabled(false);
		textAreaChat.setCaretPosition(textAreaChat.getDocument().getLength());
		textAreaChat.setBounds(0, 0, 211, 410);
		textAreaChat.setEditable(false);

		btnConnect = new JButton("Conectar");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nickname = JOptionPane.showInputDialog(null, "Insira o nome de usuário:");
				if (nickname.isEmpty()) {
					clientController.setNickName("Eu");
				}else{
					clientController.setNickName(nickname);
				}
				panelMyAvatar.setBorder(new TitledBorder(null, nickname, TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
				btnConnect.setEnabled(false);
				btnDisconnect.setEnabled(true);
				textToSend.setEnabled(true);
				textToSend.setEditable(true);
			}
		});
		btnConnect.setBounds(24, 128, 87, 25);
		panelChat.add(btnConnect);

		btnDisconnect = new JButton("Sair");
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnConnect.setEnabled(true);
				btnDisconnect.setEnabled(false);
				textToSend.setEnabled(false);
				textToSend.setEditable(false);
				clientController.disconnectFromChat();
			}
		});
		btnDisconnect.setEnabled(false);
		btnDisconnect.setBounds(135, 128, 80, 25);
		panelChat.add(btnDisconnect);

		panelMyAvatar = new JPanel();
		panelMyAvatar.setBorder(new TitledBorder(null, "Eu", TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
		panelMyAvatar.setBounds(11, 29, 80, 84);
		panelChat.add(panelMyAvatar);
		panelMyAvatar.setLayout(null);

		JLabel myAvatar = new JLabel();
		myAvatar.setLocation(7, 0);
		myAvatar.setSize(66, 66);
		myAvatar.setIcon(this.sprite.getEmotion());
		panelMyAvatar.add(myAvatar);

		panelEnemyAvatar = new JPanel();
		panelEnemyAvatar.setBorder(new TitledBorder(null, "An\u00F4nimo", TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
		panelEnemyAvatar.setBounds(146, 29, 80, 84);
		panelChat.add(panelEnemyAvatar);
		panelEnemyAvatar.setLayout(null);

		JLabel enemyAvatar = new JLabel();
		enemyAvatar.setBounds(7, 0, 66, 66);
		enemyAvatar.setIcon(this.sprite.getEmotion());
		panelEnemyAvatar.add(enemyAvatar);

		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblX.setBounds(102, 55, 33, 24);
		panelChat.add(lblX);

		JScrollPane scrollPaneAreaChat = new JScrollPane(textAreaChat);
		scrollPaneAreaChat.setBounds(10, 164, 220, 250);
		scrollPaneAreaChat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelChat.add(scrollPaneAreaChat);

		panelBalls = new JPanel();
		panelBalls.setLayout(null);
		panelBalls.setBorder(new TitledBorder(null, "Cores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBalls.setBounds(271, 601, 240, 60);
		frmMastermindGame.getContentPane().add(panelBalls);

		colorLabel1 = new JLabel();
		colorLabel1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JComponent component = (JComponent) e.getSource();
				TransferHandler handler = component.getTransferHandler();
				handler.exportAsDrag(component, e, TransferHandler.COPY);
			}
		});
		colorLabel1.setBounds(4, 23, 35, 35);
		colorLabel1.setIcon(this.sprite.getColorByIndex(Sprite.RED));
		colorLabel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		colorLabel1.setTransferHandler(new TransferHandler("icon"));
		panelBalls.add(colorLabel1);

		colorLabel2 = new JLabel();
		colorLabel2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JComponent component = (JComponent) e.getSource();
				TransferHandler handler = component.getTransferHandler();
				handler.exportAsDrag(component, e, TransferHandler.COPY);
			}
		});
		colorLabel2.setBounds(43, 23, 35, 35);
		colorLabel2.setIcon(this.sprite.getColorByIndex(Sprite.GREEN));
		colorLabel2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		colorLabel2.setTransferHandler(new TransferHandler("icon"));
		panelBalls.add(colorLabel2);

		colorLabel3 = new JLabel();
		colorLabel3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JComponent component = (JComponent) e.getSource();
				TransferHandler handler = component.getTransferHandler();
				handler.exportAsDrag(component, e, TransferHandler.COPY);
			}
		});
		colorLabel3.setBounds(82, 23, 35, 35);
		colorLabel3.setIcon(this.sprite.getColorByIndex(Sprite.ORANGE));
		colorLabel3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		colorLabel3.setTransferHandler(new TransferHandler("icon"));
		panelBalls.add(colorLabel3);

		colorLabel4 = new JLabel();
		colorLabel4.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JComponent component = (JComponent) e.getSource();
				TransferHandler handler = component.getTransferHandler();
				handler.exportAsDrag(component, e, TransferHandler.COPY);
			}
		});
		colorLabel4.setBounds(121, 23, 35, 35);
		colorLabel4.setIcon(this.sprite.getColorByIndex(Sprite.YELLOW));
		colorLabel4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		colorLabel4.setTransferHandler(new TransferHandler("icon"));
		panelBalls.add(colorLabel4);

		colorLabel5 = new JLabel();
		colorLabel5.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JComponent component = (JComponent) e.getSource();
				TransferHandler handler = component.getTransferHandler();
				handler.exportAsDrag(component, e, TransferHandler.COPY);
			}
		});
		colorLabel5.setBounds(160, 23, 35, 35);
		colorLabel5.setIcon(this.sprite.getColorByIndex(Sprite.BLUE));
		colorLabel5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		colorLabel5.setTransferHandler(new TransferHandler("icon"));
		panelBalls.add(colorLabel5);

		colorLabel6 = new JLabel();
		colorLabel6.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JComponent component = (JComponent) e.getSource();
				TransferHandler handler = component.getTransferHandler();
				handler.exportAsDrag(component, e, TransferHandler.COPY);
			}
		});
		colorLabel6.setBounds(199, 23, 35, 35);
		colorLabel6.setIcon(this.sprite.getColorByIndex(Sprite.DARK_BLUE));
		colorLabel6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		colorLabel6.setTransferHandler(new TransferHandler("icon"));
		panelBalls.add(colorLabel6);

		JPanel panelMove = new JPanel();
		panelMove.setBounds(271, 546, 180, 60);
		frmMastermindGame.getContentPane().add(panelMove);
		panelMove.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Sua Jogada",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		move_1 = new JLabel();
		move_1.setBounds(8, 20, 35, 35);
		move_1.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		move_1.setTransferHandler(new TransferHandler("icon"));
		panelMove.setLayout(null);
		panelMove.add(move_1);

		move_2 = new JLabel();
		move_2.setBounds(51, 20, 35, 35);
		move_2.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		move_2.setTransferHandler(new TransferHandler("icon"));
		panelMove.add(move_2);

		move_3 = new JLabel();
		move_3.setBounds(94, 20, 35, 35);
		move_3.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		move_3.setTransferHandler(new TransferHandler("icon"));
		panelMove.add(move_3);

		move_4 = new JLabel();
		move_4.setBounds(137, 20, 35, 35);
		move_4.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		move_4.setTransferHandler(new TransferHandler("icon"));
		panelMove.add(move_4);

		btnSendSequence = new JButton();
		btnSendSequence.setBounds(466, 561, 45, 45);
		frmMastermindGame.getContentPane().add(btnSendSequence);
		btnSendSequence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (myTurn) {
					sequenceToSend[0] = sprite.getIndexByColor(move_1.getIcon());
					sequenceToSend[1] = sprite.getIndexByColor(move_2.getIcon());
					sequenceToSend[2] = sprite.getIndexByColor(move_3.getIcon());
					sequenceToSend[3] = sprite.getIndexByColor(move_4.getIcon());
					checkSequenceToSend(sequenceToSend);
				}
			}

		});
		btnSendSequence.setIcon(this.sprite.getButton());

		JPanel panelTime = new JPanel();
		panelTime.setBorder(new TitledBorder(null, "Tempo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTime.setBounds(271, 498, 110, 45);
		frmMastermindGame.getContentPane().add(panelTime);
		panelTime.setLayout(null);

		final JLabel labelClock = new JLabel();
		labelClock.setBounds(24, 15, 62, 24);
		panelTime.add(labelClock);

		Timer timer = new Timer(1000, new ActionListener() {
			private long time;
			@Override
			public void actionPerformed(ActionEvent e) {
				labelClock.setText(String.format("%02d : %02d", time/60, time++%60));
			}
		});
		timer.start();

	}

	private void setPassword(int[] sequenceToSend) {
		password = sequenceToSend;
		lblPassword1.setIcon(this.sprite.getColorByIndex(sequenceToSend[0]));
		lblPassword2.setIcon(this.sprite.getColorByIndex(sequenceToSend[1]));
		lblPassword3.setIcon(this.sprite.getColorByIndex(sequenceToSend[2]));
		lblPassword4.setIcon(this.sprite.getColorByIndex(sequenceToSend[3]));
		this.firstMoviment = false;
	}

	private void populeArrayChance(JLabel label, int i, int j) {
		this.arrayLabelsSequence[i][j] = label;
	}

	private void populeArrayResponse(JLabel label, int i, int j) {
		this.arrayLabelsResponse[i][j] = label;
	}

	/**
	 * @return the textAreaChat
	 */
	private JTextArea getTextAreaChat() {
		return textAreaChat;
	}

	/**
	 * @return the arrayLabelsSequence
	 */
	private JLabel[][] getArrayLabelsSequence() {
		return arrayLabelsSequence;
	}

	/**
	 * @return the arrayLabelsResponse
	 */
	public JLabel[][] getArrayLabelsResponse() {
		return arrayLabelsResponse;
	}

	/**
	 * @return the index_row
	 */
	private int getIndex_row() {
		return index_move;
	}

	public void setMessageToTextAreaChat(String message) {
		getTextAreaChat().append(message + "\n");
		getTextAreaChat().setCaretPosition(getTextAreaChat().getDocument().getLength());
	}

	public void setSequenceToGameView(int[] colorResponse) {

		if (challenging) {
			if (firstMoviment) {
				password = colorResponse;
				firstMoviment = false;
			}else{
				for (int i = 0; i < colorResponse.length; i++) {
					arrayLabelsResponse[index_move-1][i].setIcon(sprite.getColorByIndex(colorResponse[i]+3));
				}
				verifyWinner(colorResponse);
			}
		}else {
			for (int j = 0; j < colorResponse.length; j++) {
				arrayLabelsSequence[index_move][j].setIcon(sprite.getColorByIndex(colorResponse[j]));
			}
		}
		JOptionPane.showMessageDialog(null, "Sua Vez.");
		myTurnGame(true);

	}

	private void verifyWinner(int[] colorResponse) {
		for (int i = 0; i < colorResponse.length; i++) {
			if (colorResponse[i] != Sprite.BLACK) {
				if (index_move == 10) {
					setPassword(password);
					JOptionPane.showMessageDialog(null, "Você perdeu. Que pena. Até a próxima.");
					System.exit(0);
				}
				return;
			}
		}


		setPassword(password);
		JOptionPane.showMessageDialog(null, "Parabéns você venceu!!! Até a próxima");
		System.exit(0);
	}

	private void resetMoviment() {
		move_1.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		move_2.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		move_3.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		move_4.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
	}

	private void myTurnGame(boolean turn) {
		if (turn) {

			btnSendSequence.setEnabled(true);
			move_1.setEnabled(true);
			move_2.setEnabled(true);
			move_3.setEnabled(true);
			move_4.setEnabled(true);

		} else {

			btnSendSequence.setEnabled(true);
			move_1.setEnabled(true);
			move_2.setEnabled(true);
			move_3.setEnabled(true);
			move_4.setEnabled(true);

		}
		myTurn = turn;
	}

	private void resetGame() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				arrayLabelsSequence[i][j].setIcon(null);
				arrayLabelsResponse[i][j].setIcon(null);
			}
		}
		this.firstMoviment = true;
		this.password = null;
		this.lblPassword1.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		this.lblPassword2.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		this.lblPassword3.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));
		this.lblPassword4.setIcon(this.sprite.getColorByIndex(Sprite.INIT_BALL));

		this.index_move = 0;
		myTurnGame(true);
	}

	public void Alert(boolean b) {
		if (b) {
			JOptionPane
			.showMessageDialog(
					null,
					"O outro jogador desconectou e como não dá pra jogar só...\nO jogo vai encerrar.\nAté a próxima.");
			System.exit(0);
		} else {
			resetGame();
		}
	}

	private void checkSequenceToSend(int[] sequence) {

		if (challenging) {
			for (int i = 0; i < sequence.length; i++) {
				for (int j = i+1; j < sequence.length; j++) {
					if (sequence[i] == sequence[j]) {
						JOptionPane.showMessageDialog(null, "Desculpe mas não são permitidas peças repetidas.\nTente outra combinação por favor.");
						return;
					}
				}
			}
			for (int i = 0; i < sequence.length; i++) {
				this.arrayLabelsSequence[this.index_move][i].setIcon(this.sprite.getColorByIndex(sequence[i]));
			}
		}else {
			if (firstMoviment) {
				for (int i = 0; i < sequence.length; i++) {
					for (int j = i+1; j < sequence.length; j++) {
						if (sequence[i] == sequence[j]) {
							JOptionPane.showMessageDialog(null, "Desculpe mas não são permitidas peças repetidas.\nTente outra combinação por favor.");
							return;
						}
					}
				}
				colorLabel1.setBounds(33, 23, 35, 35);
				colorLabel1.setIcon(sprite.getColorByIndex(Sprite.BLACK));
				colorLabel2.setBounds(101, 23, 35, 35);
				colorLabel2.setIcon(sprite.getColorByIndex(Sprite.WHITE));
				colorLabel3.setBounds(169, 23, 35, 35);
				colorLabel3.setIcon(sprite.getColorByIndex(Sprite.BLANCK_BALL));
				panelBalls.remove(colorLabel4);
				panelBalls.remove(colorLabel5);
				panelBalls.remove(colorLabel6);
				panelBalls.repaint();
			}else{
				for (int i = 0; i < sequence.length; i++) {
					arrayLabelsResponse[index_move][i].setIcon(this.sprite.getColorByIndex(sequence[i]+3));
				}
			}
		}


		clientController.sendSequenceColors(sequence);
		myTurnGame(false);
		index_move++;
		resetMoviment();
		if (firstMoviment) {
			setPassword(sequence);
			index_move = 0;
		}
	}
}
