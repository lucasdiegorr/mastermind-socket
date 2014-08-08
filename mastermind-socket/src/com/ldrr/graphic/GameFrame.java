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
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import java.awt.BorderLayout;
import java.beans.PropertyVetoException;

import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

import java.awt.event.MouseAdapter;

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
	private JTextField internalTextFieldAddressServerGame;
	private JTextField internalTextFielRoomServerGame;
	private JLabel internalMessageGame;
	private JInternalFrame internalFrame;
	private JDesktopPane desktopPane;
	private JLabel enemyAvatar;
	private JLabel myAvatar;

	/**
	 * Create the application.
	 */
	public GameFrame(boolean challenging) {
		this.setSprite(new Sprite());
		initialize();
		initGame(challenging);
	}

	private void initGame(boolean challenging) {
		this.challenging = challenging;
		this.setMyTurn(!challenging);
		this.getFrmMastermindGame().setVisible(true);
		this.setClientController(new ClientController(GameFrame.this));
		if (!challenging) {
			getDesktopPane().setVisible(false);
			this.getInternalFrame().setVisible(false);
			getBtnConnect().setEnabled(true);
			this.getClientController().initGame();
			this.getClientController().initChat();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmMastermindGame(new JFrame());
		getFrmMastermindGame().setResizable(false);
		getFrmMastermindGame().setTitle("MasterMind Game");
		getFrmMastermindGame().setBounds(100, 100, 524, 710);
		getFrmMastermindGame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmMastermindGame().getContentPane().setLayout(null);

		JPanel panelGame = new JPanel();
		panelGame.setBorder(new TitledBorder(null, "Game",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGame.setBounds(6, 6, 253, 660);
		getFrmMastermindGame().getContentPane().add(panelGame);
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

		setLblPassword1(new JLabel());
		getLblPassword1().setBounds(15, 22, 35, 35);
		getLblPassword1().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		panelPassword.add(getLblPassword1());

		setLblPassword2(new JLabel());
		getLblPassword2().setBounds(65, 22, 35, 35);
		getLblPassword2().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		panelPassword.add(getLblPassword2());

		setLblPassword3(new JLabel());
		getLblPassword3().setBounds(115, 22, 35, 35);
		getLblPassword3().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		panelPassword.add(getLblPassword3());

		setLblPassword4(new JLabel());
		getLblPassword4().setBounds(165, 22, 35, 35);
		getLblPassword4().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		panelPassword.add(getLblPassword4());
		index_move = 0;

		JPanel panelChat = new JPanel();
		panelChat.setBorder(new TitledBorder(null, "Chat",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panelChat.setBounds(272, 6, 240, 480);
		getFrmMastermindGame().getContentPane().add(panelChat);
		panelChat.setLayout(null);

		setTextToSend(new JTextArea());
		getTextToSend().setLineWrap(true);
		getTextToSend().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!getTextToSend().getText().isEmpty()) {
						getClientController().sendMessageChat(getTextToSend().getText());
						getTextAreaChat().append("eu: " + getTextToSend().getText());
						getTextToSend().setText(null);
						getTextToSend().requestFocus();
					}
				}
			}
		});

		getTextToSend().setEnabled(false);
		getTextToSend().setEditable(false);
		getTextToSend().setBounds(15, 427, 210, 40);
		getTextToSend().setColumns(10);

		JScrollPane scrollPaneTextToSend = new JScrollPane(getTextToSend());
		scrollPaneTextToSend.setBounds(15, 427, 210, 40);
		scrollPaneTextToSend.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelChat.add(scrollPaneTextToSend);

		setTextAreaChat(new JTextArea());
		getTextAreaChat().setLineWrap(true);
		getTextAreaChat().setEnabled(false);
		getTextAreaChat().setCaretPosition(getTextAreaChat().getDocument().getLength());
		getTextAreaChat().setBounds(0, 0, 211, 410);
		getTextAreaChat().setEditable(false);

		setBtnConnect(new JButton("Conectar"));
		getBtnConnect().setEnabled(false);
		getBtnConnect().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nickname = JOptionPane.showInputDialog(null, "Insira o nome de usu�rio:");
				if (nickname.isEmpty()) {
					getClientController().setNickName("Eu");
				}else{
					getClientController().setNickName(nickname);
				}
				getPanelMyAvatar().setBorder(new TitledBorder(null, nickname, TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
				getBtnConnect().setEnabled(false);
				getBtnDisconnect().setEnabled(true);
				getTextToSend().setEnabled(true);
				getTextToSend().setEditable(true);
			}
		});
		getBtnConnect().setBounds(24, 128, 87, 25);
		panelChat.add(getBtnConnect());

		setBtnDisconnect(new JButton("Sair"));
		getBtnDisconnect().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getBtnConnect().setEnabled(true);
				getBtnDisconnect().setEnabled(false);
				getTextToSend().setEnabled(false);
				getTextToSend().setEditable(false);
				getClientController().disconnectFromChat();
			}
		});
		getBtnDisconnect().setEnabled(false);
		getBtnDisconnect().setBounds(135, 128, 80, 25);
		panelChat.add(getBtnDisconnect());

		setPanelMyAvatar(new JPanel());
		getPanelMyAvatar().setBorder(new TitledBorder(null, "Eu", TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
		getPanelMyAvatar().setBounds(11, 29, 80, 84);
		panelChat.add(getPanelMyAvatar());
		getPanelMyAvatar().setLayout(null);

		setMyAvatar(new JLabel());
		getMyAvatar().addMouseListener(new MouseAdapter() {
			int indexAvatar = 0;
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (indexAvatar == 8) {
					indexAvatar = 0;
				}
				getMyAvatar().setIcon(getSprite().getEmoticonByIndex(indexAvatar));
				getClientController().setEmoticon(indexAvatar++);
			}
		});
		getMyAvatar().setLocation(7, 0);
		getMyAvatar().setSize(66, 66);
		getMyAvatar().setIcon(this.getSprite().getEmoticonByIndex(0));
		getPanelMyAvatar().add(getMyAvatar());

		setPanelEnemyAvatar(new JPanel());
		getPanelEnemyAvatar().setBorder(new TitledBorder(null, "An\u00F4nimo", TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
		getPanelEnemyAvatar().setBounds(146, 29, 80, 84);
		panelChat.add(getPanelEnemyAvatar());
		getPanelEnemyAvatar().setLayout(null);

		enemyAvatar = new JLabel();
		getEnemyAvatar().setBounds(7, 0, 66, 66);
		getEnemyAvatar().setIcon(this.getSprite().getEmoticonByIndex(0));
		getPanelEnemyAvatar().add(getEnemyAvatar());

		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Dialog", Font.PLAIN, 40));
		lblX.setBounds(102, 55, 33, 24);
		panelChat.add(lblX);

		JScrollPane scrollPaneAreaChat = new JScrollPane(getTextAreaChat());
		scrollPaneAreaChat.setBounds(10, 164, 220, 250);
		scrollPaneAreaChat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		panelChat.add(scrollPaneAreaChat);

		setPanelBalls(new JPanel());
		getPanelBalls().setLayout(null);
		getPanelBalls().setBorder(new TitledBorder(null, "Cores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getPanelBalls().setBounds(271, 601, 240, 60);
		getFrmMastermindGame().getContentPane().add(getPanelBalls());

		setColorLabel1(new JLabel());
		getColorLabel1().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JComponent component = (JComponent) e.getSource();
				TransferHandler handler = component.getTransferHandler();
				handler.exportAsDrag(component, e, TransferHandler.COPY);
			}
		});
		getColorLabel1().setBounds(4, 23, 35, 35);
		getColorLabel1().setIcon(this.getSprite().getColorByIndex(Sprite.RED));
		getColorLabel1().setCursor(new Cursor(Cursor.HAND_CURSOR));
		getColorLabel1().setTransferHandler(new TransferHandler("icon"));
		getPanelBalls().add(getColorLabel1());

		setColorLabel2(new JLabel());
		getColorLabel2().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JComponent component = (JComponent) e.getSource();
				TransferHandler handler = component.getTransferHandler();
				handler.exportAsDrag(component, e, TransferHandler.COPY);
			}
		});
		getColorLabel2().setBounds(43, 23, 35, 35);
		getColorLabel2().setIcon(this.getSprite().getColorByIndex(Sprite.GREEN));
		getColorLabel2().setCursor(new Cursor(Cursor.HAND_CURSOR));
		getColorLabel2().setTransferHandler(new TransferHandler("icon"));
		getPanelBalls().add(getColorLabel2());

		setColorLabel3(new JLabel());
		getColorLabel3().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JComponent component = (JComponent) e.getSource();
				TransferHandler handler = component.getTransferHandler();
				handler.exportAsDrag(component, e, TransferHandler.COPY);
			}
		});
		getColorLabel3().setBounds(82, 23, 35, 35);
		getColorLabel3().setIcon(this.getSprite().getColorByIndex(Sprite.ORANGE));
		getColorLabel3().setCursor(new Cursor(Cursor.HAND_CURSOR));
		getColorLabel3().setTransferHandler(new TransferHandler("icon"));
		getPanelBalls().add(getColorLabel3());

		setColorLabel4(new JLabel());
		getColorLabel4().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JComponent component = (JComponent) e.getSource();
				TransferHandler handler = component.getTransferHandler();
				handler.exportAsDrag(component, e, TransferHandler.COPY);
			}
		});
		getColorLabel4().setBounds(121, 23, 35, 35);
		getColorLabel4().setIcon(this.getSprite().getColorByIndex(Sprite.YELLOW));
		getColorLabel4().setCursor(new Cursor(Cursor.HAND_CURSOR));
		getColorLabel4().setTransferHandler(new TransferHandler("icon"));
		getPanelBalls().add(getColorLabel4());

		setColorLabel5(new JLabel());
		getColorLabel5().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JComponent component = (JComponent) e.getSource();
				TransferHandler handler = component.getTransferHandler();
				handler.exportAsDrag(component, e, TransferHandler.COPY);
			}
		});
		getColorLabel5().setBounds(160, 23, 35, 35);
		getColorLabel5().setIcon(this.getSprite().getColorByIndex(Sprite.BLUE));
		getColorLabel5().setCursor(new Cursor(Cursor.HAND_CURSOR));
		getColorLabel5().setTransferHandler(new TransferHandler("icon"));
		getPanelBalls().add(getColorLabel5());

		setColorLabel6(new JLabel());
		getColorLabel6().addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				JComponent component = (JComponent) e.getSource();
				TransferHandler handler = component.getTransferHandler();
				handler.exportAsDrag(component, e, TransferHandler.COPY);
			}
		});
		getColorLabel6().setBounds(199, 23, 35, 35);
		getColorLabel6().setIcon(this.getSprite().getColorByIndex(Sprite.DARK_BLUE));
		getColorLabel6().setCursor(new Cursor(Cursor.HAND_CURSOR));
		getColorLabel6().setTransferHandler(new TransferHandler("icon"));
		getPanelBalls().add(getColorLabel6());

		JPanel panelMove = new JPanel();
		panelMove.setBounds(271, 546, 180, 60);
		getFrmMastermindGame().getContentPane().add(panelMove);
		panelMove.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Sua Jogada",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setMove_1(new JLabel());
		getMove_1().setBounds(8, 20, 35, 35);
		getMove_1().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		getMove_1().setTransferHandler(new TransferHandler("icon"));
		panelMove.setLayout(null);
		panelMove.add(getMove_1());

		setMove_2(new JLabel());
		getMove_2().setBounds(51, 20, 35, 35);
		getMove_2().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		getMove_2().setTransferHandler(new TransferHandler("icon"));
		panelMove.add(getMove_2());

		setMove_3(new JLabel());
		getMove_3().setBounds(94, 20, 35, 35);
		getMove_3().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		getMove_3().setTransferHandler(new TransferHandler("icon"));
		panelMove.add(getMove_3());

		setMove_4(new JLabel());
		getMove_4().setBounds(137, 20, 35, 35);
		getMove_4().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		getMove_4().setTransferHandler(new TransferHandler("icon"));
		panelMove.add(getMove_4());

		setBtnSendSequence(new JButton());
		getBtnSendSequence().setBounds(466, 561, 45, 45);
		getFrmMastermindGame().getContentPane().add(getBtnSendSequence());
		getBtnSendSequence().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (isMyTurn()) {
					getSequenceToSend()[0] = getSprite().getIndexByColor(getMove_1().getIcon());
					getSequenceToSend()[1] = getSprite().getIndexByColor(getMove_2().getIcon());
					getSequenceToSend()[2] = getSprite().getIndexByColor(getMove_3().getIcon());
					getSequenceToSend()[3] = getSprite().getIndexByColor(getMove_4().getIcon());
					checkSequenceToSend(getSequenceToSend());
				}
			}

		});
		getBtnSendSequence().setIcon(this.getSprite().getButton());

		JPanel panelTime = new JPanel();
		panelTime.setBorder(new TitledBorder(null, "Tempo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTime.setBounds(271, 498, 110, 45);
		getFrmMastermindGame().getContentPane().add(panelTime);
		panelTime.setLayout(null);

		final JLabel labelClock = new JLabel();
		labelClock.setBounds(24, 15, 62, 24);
		panelTime.add(labelClock);
		
		setDesktopPane(new JDesktopPane());
		getDesktopPane().setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		getDesktopPane().setBackground(new Color(128, 128, 128));
		getDesktopPane().setBounds(6, 6, 253, 660);
		getFrmMastermindGame().getContentPane().add(getDesktopPane());
		getDesktopPane().setLayout(null);
		
		setInternalFrame(new JInternalFrame());
		getInternalFrame().setTitle("Endere\u00E7o do Game Server");
		getInternalFrame().setBounds(1, 205, 250, 250);
		getDesktopPane().add(getInternalFrame());
		
		JPanel InternalPanelGame = new JPanel();
		getInternalFrame().getContentPane().add(InternalPanelGame, BorderLayout.CENTER);
		InternalPanelGame.setLayout(null);
		
		setInternalMessageGame(new JLabel("Qual o server do seu amigo?"));
		getInternalMessageGame().setBounds(32, 7, 175, 25);
		InternalPanelGame.add(getInternalMessageGame());
		
		JLabel lblInternalAddressServerGame = new JLabel("Endere\u00E7o do Game Server:");
		lblInternalAddressServerGame.setBounds(39, 39, 162, 25);
		InternalPanelGame.add(lblInternalAddressServerGame);
		
		setInternalTextFieldAddressServerGame(new JTextField());
		getInternalTextFieldAddressServerGame().setBounds(60, 71, 120, 30);
		InternalPanelGame.add(getInternalTextFieldAddressServerGame());
		getInternalTextFieldAddressServerGame().setColumns(10);
		
		JLabel internalLblRommServerGame = new JLabel("Sala:");
		internalLblRommServerGame.setBounds(102, 108, 36, 25);
		InternalPanelGame.add(internalLblRommServerGame);
		
		setInternalTextFielRoomServerGame(new JTextField());
		getInternalTextFielRoomServerGame().setBounds(60, 140, 120, 30);
		getInternalTextFielRoomServerGame().setColumns(10);
		InternalPanelGame.add(getInternalTextFielRoomServerGame());
		
		JButton btnInitGame = new JButton("Iniciar");
		btnInitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String address = getInternalTextFieldAddressServerGame().getText();
				int port = Integer.parseInt(getInternalTextFielRoomServerGame().getText());
				getClientController().initGame(address, port);
				getClientController().initChat(address, port-1000);
				getInternalFrame().setVisible(false);
				getDesktopPane().setVisible(false);
				getBtnConnect().setEnabled(true);
			}
		});
		btnInitGame.setBounds(73, 177, 93, 29);
		InternalPanelGame.add(btnInitGame);
		getInternalFrame().setVisible(true);

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
		getLblPassword1().setIcon(this.getSprite().getColorByIndex(sequenceToSend[0]));
		getLblPassword2().setIcon(this.getSprite().getColorByIndex(sequenceToSend[1]));
		getLblPassword3().setIcon(this.getSprite().getColorByIndex(sequenceToSend[2]));
		getLblPassword4().setIcon(this.getSprite().getColorByIndex(sequenceToSend[3]));
		this.setFirstMoviment(false);
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
	private int getIndex_move() {
		return index_move;
	}

	public void setMessageToTextAreaChat(String message) {
		getTextAreaChat().append(message);
		getTextAreaChat().setCaretPosition(getTextAreaChat().getDocument().getLength());
		
	}

	public void setSequenceToGameView(int[] colorResponse) {

		if (challenging) {
			if (isFirstMoviment()) {
				password = colorResponse;
				setFirstMoviment(false);
			}else{
				for (int i = 0; i < colorResponse.length; i++) {
					arrayLabelsResponse[index_move-1][i].setIcon(getSprite().getColorByIndex(colorResponse[i]+3));
				}
				verifyWinner(colorResponse);
			}
		}else {
			for (int j = 0; j < colorResponse.length; j++) {
				arrayLabelsSequence[index_move][j].setIcon(getSprite().getColorByIndex(colorResponse[j]));
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
					JOptionPane.showMessageDialog(null, "Voc� perdeu. Que pena. At� a pr�xima.");
					System.exit(0);
				}
				return;
			}
		}


		setPassword(password);
		JOptionPane.showMessageDialog(null, "Parab�ns voc� venceu!!! At� a pr�xima");
		System.exit(0);
	}

	private void resetMoviment() {
		getMove_1().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		getMove_2().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		getMove_3().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		getMove_4().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
	}

	private void myTurnGame(boolean turn) {
		if (turn) {

			getBtnSendSequence().setEnabled(true);
			getMove_1().setEnabled(true);
			getMove_2().setEnabled(true);
			getMove_3().setEnabled(true);
			getMove_4().setEnabled(true);

		} else {

			getBtnSendSequence().setEnabled(true);
			getMove_1().setEnabled(true);
			getMove_2().setEnabled(true);
			getMove_3().setEnabled(true);
			getMove_4().setEnabled(true);

		}
		setMyTurn(turn);
	}

	private void resetGame() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 4; j++) {
				arrayLabelsSequence[i][j].setIcon(null);
				arrayLabelsResponse[i][j].setIcon(null);
			}
		}
		this.setFirstMoviment(true);
		this.password = null;
		this.getLblPassword1().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		this.getLblPassword2().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		this.getLblPassword3().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));
		this.getLblPassword4().setIcon(this.getSprite().getColorByIndex(Sprite.INIT_BALL));

		this.index_move = 0;
		myTurnGame(true);
	}

	public void Alert(boolean b) {
		if (b) {
			JOptionPane
			.showMessageDialog(
					null,
					"O outro jogador desconectou e como n�o d� pra jogar s�...\nO jogo vai encerrar.\nAt� a pr�xima.");
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
						JOptionPane.showMessageDialog(null, "Desculpe mas n�o s�o permitidas pe�as repetidas.\nTente outra combina��o por favor.");
						return;
					}
				}
			}
			for (int i = 0; i < sequence.length; i++) {
				this.arrayLabelsSequence[this.index_move][i].setIcon(this.getSprite().getColorByIndex(sequence[i]));
			}
		}else {
			if (isFirstMoviment()) {
				for (int i = 0; i < sequence.length; i++) {
					for (int j = i+1; j < sequence.length; j++) {
						if (sequence[i] == sequence[j]) {
							JOptionPane.showMessageDialog(null, "Desculpe mas n�o s�o permitidas pe�as repetidas.\nTente outra combina��o por favor.");
							return;
						}
					}
				}
				getColorLabel1().setBounds(33, 23, 35, 35);
				getColorLabel1().setIcon(getSprite().getColorByIndex(Sprite.BLACK));
				getColorLabel2().setBounds(101, 23, 35, 35);
				getColorLabel2().setIcon(getSprite().getColorByIndex(Sprite.WHITE));
				getColorLabel3().setBounds(169, 23, 35, 35);
				getColorLabel3().setIcon(getSprite().getColorByIndex(Sprite.BLANCK_BALL));
				getPanelBalls().remove(getColorLabel4());
				getPanelBalls().remove(getColorLabel5());
				getPanelBalls().remove(getColorLabel6());
				getPanelBalls().repaint();
			}else{
				for (int i = 0; i < sequence.length; i++) {
					arrayLabelsResponse[index_move][i].setIcon(this.getSprite().getColorByIndex(sequence[i]+3));
				}
			}
		}


		getClientController().sendSequenceColors(sequence);
		myTurnGame(false);
		index_move++;
		resetMoviment();
		if (isFirstMoviment()) {
			setPassword(sequence);
			index_move = 0;
		}
	}

	/**
	 * @return the lblPassword1
	 */
	public JLabel getLblPassword1() {
		return lblPassword1;
	}

	/**
	 * @param lblPassword1 the lblPassword1 to set
	 */
	public void setLblPassword1(JLabel lblPassword1) {
		this.lblPassword1 = lblPassword1;
	}

	/**
	 * @return the lblPassword2
	 */
	public JLabel getLblPassword2() {
		return lblPassword2;
	}

	/**
	 * @param lblPassword2 the lblPassword2 to set
	 */
	public void setLblPassword2(JLabel lblPassword2) {
		this.lblPassword2 = lblPassword2;
	}

	/**
	 * @return the lblPassword3
	 */
	public JLabel getLblPassword3() {
		return lblPassword3;
	}

	/**
	 * @param lblPassword3 the lblPassword3 to set
	 */
	public void setLblPassword3(JLabel lblPassword3) {
		this.lblPassword3 = lblPassword3;
	}

	/**
	 * @return the lblPassword4
	 */
	public JLabel getLblPassword4() {
		return lblPassword4;
	}

	/**
	 * @param lblPassword4 the lblPassword4 to set
	 */
	public void setLblPassword4(JLabel lblPassword4) {
		this.lblPassword4 = lblPassword4;
	}

	/**
	 * @return the firstMoviment
	 */
	public boolean isFirstMoviment() {
		return firstMoviment;
	}

	/**
	 * @param firstMoviment the firstMoviment to set
	 */
	public void setFirstMoviment(boolean firstMoviment) {
		this.firstMoviment = firstMoviment;
	}

	/**
	 * @return the sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}

	/**
	 * @param sprite the sprite to set
	 */
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * @return the clientController
	 */
	public ClientController getClientController() {
		return clientController;
	}

	/**
	 * @param clientController the clientController to set
	 */
	public void setClientController(ClientController clientController) {
		this.clientController = clientController;
	}

	/**
	 * @return the internalFrame
	 */
	public JInternalFrame getInternalFrame() {
		return internalFrame;
	}

	/**
	 * @param internalFrame the internalFrame to set
	 */
	public void setInternalFrame(JInternalFrame internalFrame) {
		this.internalFrame = internalFrame;
	}

	/**
	 * @return the desktopPane
	 */
	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	/**
	 * @param desktopPane the desktopPane to set
	 */
	public void setDesktopPane(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

	/**
	 * @return the btnConnect
	 */
	public JButton getBtnConnect() {
		return btnConnect;
	}

	/**
	 * @param btnConnect the btnConnect to set
	 */
	public void setBtnConnect(JButton btnConnect) {
		this.btnConnect = btnConnect;
	}

	/**
	 * @return the internalTextFielRoomServerGame
	 */
	public JTextField getInternalTextFielRoomServerGame() {
		return internalTextFielRoomServerGame;
	}

	/**
	 * @param internalTextFielRoomServerGame the internalTextFielRoomServerGame to set
	 */
	public void setInternalTextFielRoomServerGame(
			JTextField internalTextFielRoomServerGame) {
		this.internalTextFielRoomServerGame = internalTextFielRoomServerGame;
	}

	/**
	 * @return the internalTextFieldAddressServerGame
	 */
	public JTextField getInternalTextFieldAddressServerGame() {
		return internalTextFieldAddressServerGame;
	}

	/**
	 * @param internalTextFieldAddressServerGame the internalTextFieldAddressServerGame to set
	 */
	public void setInternalTextFieldAddressServerGame(
			JTextField internalTextFieldAddressServerGame) {
		this.internalTextFieldAddressServerGame = internalTextFieldAddressServerGame;
	}

	/**
	 * @return the internalMessageGame
	 */
	public JLabel getInternalMessageGame() {
		return internalMessageGame;
	}

	/**
	 * @param internalMessageGame the internalMessageGame to set
	 */
	public void setInternalMessageGame(JLabel internalMessageGame) {
		this.internalMessageGame = internalMessageGame;
	}

	/**
	 * @return the frmMastermindGame
	 */
	public JFrame getFrmMastermindGame() {
		return frmMastermindGame;
	}

	/**
	 * @param frmMastermindGame the frmMastermindGame to set
	 */
	public void setFrmMastermindGame(JFrame frmMastermindGame) {
		this.frmMastermindGame = frmMastermindGame;
	}

	/**
	 * @return the btnSendSequence
	 */
	public JButton getBtnSendSequence() {
		return btnSendSequence;
	}

	/**
	 * @param btnSendSequence the btnSendSequence to set
	 */
	public void setBtnSendSequence(JButton btnSendSequence) {
		this.btnSendSequence = btnSendSequence;
	}

	/**
	 * @return the sequenceToSend
	 */
	public int[] getSequenceToSend() {
		return sequenceToSend;
	}

	/**
	 * @param sequenceToSend the sequenceToSend to set
	 */
	public void setSequenceToSend(int[] sequenceToSend) {
		this.sequenceToSend = sequenceToSend;
	}

	/**
	 * @return the move_1
	 */
	public JLabel getMove_1() {
		return move_1;
	}

	/**
	 * @param move_1 the move_1 to set
	 */
	public void setMove_1(JLabel move_1) {
		this.move_1 = move_1;
	}

	/**
	 * @return the move_2
	 */
	public JLabel getMove_2() {
		return move_2;
	}

	/**
	 * @param move_2 the move_2 to set
	 */
	public void setMove_2(JLabel move_2) {
		this.move_2 = move_2;
	}

	/**
	 * @return the move_3
	 */
	public JLabel getMove_3() {
		return move_3;
	}

	/**
	 * @param move_3 the move_3 to set
	 */
	public void setMove_3(JLabel move_3) {
		this.move_3 = move_3;
	}

	/**
	 * @return the move_4
	 */
	public JLabel getMove_4() {
		return move_4;
	}

	/**
	 * @param move_4 the move_4 to set
	 */
	public void setMove_4(JLabel move_4) {
		this.move_4 = move_4;
	}

	/**
	 * @return the myTurn
	 */
	public boolean isMyTurn() {
		return myTurn;
	}

	/**
	 * @param myTurn the myTurn to set
	 */
	public void setMyTurn(boolean myTurn) {
		this.myTurn = myTurn;
	}

	/**
	 * @return the colorLabel6
	 */
	public JLabel getColorLabel6() {
		return colorLabel6;
	}

	/**
	 * @param colorLabel6 the colorLabel6 to set
	 */
	public void setColorLabel6(JLabel colorLabel6) {
		this.colorLabel6 = colorLabel6;
	}

	/**
	 * @return the panelBalls
	 */
	public JPanel getPanelBalls() {
		return panelBalls;
	}

	/**
	 * @param panelBalls the panelBalls to set
	 */
	public void setPanelBalls(JPanel panelBalls) {
		this.panelBalls = panelBalls;
	}

	/**
	 * @return the colorLabel5
	 */
	public JLabel getColorLabel5() {
		return colorLabel5;
	}

	/**
	 * @param colorLabel5 the colorLabel5 to set
	 */
	public void setColorLabel5(JLabel colorLabel5) {
		this.colorLabel5 = colorLabel5;
	}

	/**
	 * @return the colorLabel4
	 */
	public JLabel getColorLabel4() {
		return colorLabel4;
	}

	/**
	 * @param colorLabel4 the colorLabel4 to set
	 */
	public void setColorLabel4(JLabel colorLabel4) {
		this.colorLabel4 = colorLabel4;
	}

	/**
	 * @return the colorLabel3
	 */
	public JLabel getColorLabel3() {
		return colorLabel3;
	}

	/**
	 * @param colorLabel3 the colorLabel3 to set
	 */
	public void setColorLabel3(JLabel colorLabel3) {
		this.colorLabel3 = colorLabel3;
	}

	/**
	 * @return the colorLabel2
	 */
	public JLabel getColorLabel2() {
		return colorLabel2;
	}

	/**
	 * @param colorLabel2 the colorLabel2 to set
	 */
	public void setColorLabel2(JLabel colorLabel2) {
		this.colorLabel2 = colorLabel2;
	}

	/**
	 * @return the colorLabel1
	 */
	public JLabel getColorLabel1() {
		return colorLabel1;
	}

	/**
	 * @param colorLabel1 the colorLabel1 to set
	 */
	public void setColorLabel1(JLabel colorLabel1) {
		this.colorLabel1 = colorLabel1;
	}

	/**
	 * @return the panelEnemyAvatar
	 */
	public JPanel getPanelEnemyAvatar() {
		return panelEnemyAvatar;
	}

	/**
	 * @param panelEnemyAvatar the panelEnemyAvatar to set
	 */
	public void setPanelEnemyAvatar(JPanel panelEnemyAvatar) {
		this.panelEnemyAvatar = panelEnemyAvatar;
	}

	/**
	 * @return the panelMyAvatar
	 */
	public JPanel getPanelMyAvatar() {
		return panelMyAvatar;
	}

	/**
	 * @param panelMyAvatar the panelMyAvatar to set
	 */
	public void setPanelMyAvatar(JPanel panelMyAvatar) {
		this.panelMyAvatar = panelMyAvatar;
	}

	/**
	 * @return the btnDisconnect
	 */
	public JButton getBtnDisconnect() {
		return btnDisconnect;
	}

	/**
	 * @param btnDisconnect the btnDisconnect to set
	 */
	public void setBtnDisconnect(JButton btnDisconnect) {
		this.btnDisconnect = btnDisconnect;
	}

	/**
	 * @return the textToSend
	 */
	public JTextArea getTextToSend() {
		return textToSend;
	}

	/**
	 * @param textToSend the textToSend to set
	 */
	public void setTextToSend(JTextArea textToSend) {
		this.textToSend = textToSend;
	}

	/**
	 * @param textAreaChat the textAreaChat to set
	 */
	public void setTextAreaChat(JTextArea textAreaChat) {
		this.textAreaChat = textAreaChat;
	}

	/**
	 * @return the enemyAvatar
	 */
	public JLabel getEnemyAvatar() {
		return enemyAvatar;
	}

	/**
	 * @param enemyAvatar the enemyAvatar to set
	 */
	public void setEnemyAvatar(int enemyAvatar) {
		this.enemyAvatar.setIcon(getSprite().getEmoticonByIndex(enemyAvatar));
	}

	public void setEnemyNick(String nickName) {
		getPanelEnemyAvatar().setBorder(new TitledBorder(null, nickName, TitledBorder.CENTER, TitledBorder.BOTTOM, null, null));
	}

	/**
	 * @return the myAvatar
	 */
	public JLabel getMyAvatar() {
		return myAvatar;
	}

	/**
	 * @param myAvatar the myAvatar to set
	 */
	public void setMyAvatar(JLabel myAvatar) {
		this.myAvatar = myAvatar;
	}
}
