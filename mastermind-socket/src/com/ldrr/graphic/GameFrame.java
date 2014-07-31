package com.ldrr.graphic;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.ldrr.client.ClientController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.JLabel;



import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.UIManager;


public class GameFrame {

	private static ClientController clientController;
	private JFrame frmMastermindGame;
	private JTextArea textAreaChat;
	private JTextField textToSend;
	private JTextField textFieldNickName;
	private boolean challenging;
	private boolean myTurn;
	private JButton btnConnect;
	private JButton btnDisconnect;
	private JButton btnSend;
	private JLabel move_1;
	private JLabel move_2;
	private JLabel move_3;
	private JLabel move_4;
	private JButton btnSendSequence;
	private JLabel[][] arrayLabelsSequence = new JLabel[10][4];
	private JLabel[][] arrayLabelsResponse = new JLabel[10][4];
	private int[] sequenceToSend = {-1,-1,-1,-1};
	private int index_collum = 0;
	private int index_row = 0;

	/**
	 * Launch the application.
	 */
		public static void main(String[] args) {
			try {
				UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e1) {
				e1.printStackTrace();
			}
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GameFrame window = new GameFrame(false);
						window.frmMastermindGame.setVisible(true);
						clientController.initGame();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	
		}

	/**
	 * Create the application.
	 */
	public GameFrame(boolean challenging) {
		initialize();
		this.challenging = challenging;
		this.myTurn = !challenging;
		this.frmMastermindGame.setVisible(true);
		clientController = new ClientController(GameFrame.this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMastermindGame = new JFrame();
		frmMastermindGame.setResizable(false);
		frmMastermindGame.setTitle("MasterMind Game");
		frmMastermindGame.setBounds(100, 100, 630, 710);
		frmMastermindGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMastermindGame.getContentPane().setLayout(null);

		JPanel panelGame = new JPanel();
		panelGame.setBorder(new TitledBorder(null, "Game", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGame.setBounds(6, 6, 253, 660);
		frmMastermindGame.getContentPane().add(panelGame);
		panelGame.setLayout(null);

		JPanel panelMove = new JPanel();
		panelMove.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Sua Jogada", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMove.setBounds(16, 593, 160, 60);
		panelGame.add(panelMove);

		move_1 = new JLabel();
		move_1.setBounds(4, 20, 35, 35);
		move_1.setIcon(Sprite.getColor(6));
		move_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (myTurn) {
					if (challenging) {
						if (sequenceToSend[0] == 5) {
							sequenceToSend[0] = -1;
						}
						move_1.setIcon(Sprite.getColor(++sequenceToSend[0]));
					}else {
						if (sequenceToSend[0] == 1) {
							sequenceToSend[0] = -1;
						}
						move_1.setIcon(Sprite.getEvalueColors(++sequenceToSend[0]));
					}
				}
			}
		});
		panelMove.setLayout(null);
		panelMove.add(move_1);

		move_2 = new JLabel();
		move_2.setBounds(43, 20, 35, 35);
		move_2.setIcon(Sprite.getColor(6));
		move_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (myTurn) {
					if (challenging) {
						if (sequenceToSend[1] == 5) {
							sequenceToSend[1] = -1;
						}
						move_2.setIcon(Sprite.getColor(++sequenceToSend[1]));
					}else {
						if (sequenceToSend[1] == 1) {
							sequenceToSend[1] = -1;
						}
						move_2.setIcon(Sprite.getEvalueColors(++sequenceToSend[1]));
					}
				}
			}
		});
		panelMove.add(move_2);

		move_3 = new JLabel();
		move_3.setBounds(82, 20, 35, 35);
		move_3.setIcon(Sprite.getColor(6));
		move_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (myTurn) {
					if (challenging) {
						if (sequenceToSend[2] == 5) {
							sequenceToSend[2] = -1;
						}
						move_3.setIcon(Sprite.getColor(++sequenceToSend[2]));
					}else {
						if (sequenceToSend[2] == 1) {
							sequenceToSend[2] = -1;
						}
						move_3.setIcon(Sprite.getEvalueColors(++sequenceToSend[2]));
					}
				}
			}
		});
		panelMove.add(move_3);

		move_4 = new JLabel();
		move_4.setBounds(121, 20, 35, 35);
		move_4.setIcon(Sprite.getColor(6));
		move_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (myTurn) {
					if (challenging) {
						if (sequenceToSend[3] == 5) {
							sequenceToSend[3] = -1;
						}
						move_4.setIcon(Sprite.getColor(++sequenceToSend[3]));
					}else {
						if (sequenceToSend[3] == 1) {
							sequenceToSend[3] = -1;
						}
						move_4.setIcon(Sprite.getEvalueColors(++sequenceToSend[3]));
					}
				}
			}
		});
		panelMove.add(move_4);

		btnSendSequence = new JButton();
		btnSendSequence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (challenging) {
					for (int i = 0; i < sequenceToSend.length; i++) {
						getArrayLabels()[getIndex_row()][i].setIcon(Sprite.getColor(sequenceToSend[i]));
					}
					//clientController.sendSequenceColors(sequenceToSend);
				}else {
					for (int i = 0; i < sequenceToSend.length; i++) {
						arrayLabelsResponse[getIndex_row()][i].setIcon(Sprite.getColor(sequenceToSend[i]));
					}
					//clientController.sendResponseGame(sequenceToSend);
				}
				myTurnGame(false);
				index_row++;
				resetMoviment();
			}

		});
		btnSendSequence.setIcon(Sprite.getIconButton(0));
		btnSendSequence.setBounds(188, 609, 45, 45);
		panelGame.add(btnSendSequence);

		JPanel panelChance_1 = new JPanel();
		panelChance_1.setLayout(null);
		panelChance_1.setBorder(new TitledBorder(null, "1\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_1.setBounds(16, 529, 160, 60);
		panelGame.add(panelChance_1);

		JLabel labelChance11 = new JLabel();
		labelChance11.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance11,index_row,index_collum++);
		panelChance_1.add(labelChance11);

		JLabel labelChance12 = new JLabel();
		labelChance12.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance12,index_row,index_collum++);
		panelChance_1.add(labelChance12);

		JLabel labelChance13 = new JLabel();
		labelChance13.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance13,index_row, index_collum++);
		panelChance_1.add(labelChance13);

		JLabel labelChance14 = new JLabel();
		labelChance14.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance14,index_row++,index_collum);
		panelChance_1.add(labelChance14);
		index_collum = 0;

		JPanel panelChance_2 = new JPanel();
		panelChance_2.setLayout(null);
		panelChance_2.setBorder(new TitledBorder(null, "2\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_2.setBounds(16, 473, 160, 60);
		panelGame.add(panelChance_2);

		JLabel labelChance21 = new JLabel();
		labelChance21.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance21,index_row,index_collum++);
		panelChance_2.add(labelChance21);

		JLabel labelChance22 = new JLabel();
		labelChance22.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance22,index_row,index_collum++);
		panelChance_2.add(labelChance22);

		JLabel labelChance23 = new JLabel();
		labelChance23.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance23,index_row,index_collum++);
		panelChance_2.add(labelChance23);

		JLabel labelChance24 = new JLabel();
		labelChance24.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance24,index_row++,index_collum++);
		panelChance_2.add(labelChance24);
		index_collum = 0;

		JPanel panelChance_3 = new JPanel();
		panelChance_3.setLayout(null);
		panelChance_3.setBorder(new TitledBorder(null, "3\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_3.setBounds(16, 418, 160, 60);
		panelGame.add(panelChance_3);

		JLabel labelChance31 = new JLabel();
		labelChance31.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance31,index_row,index_collum++);
		panelChance_3.add(labelChance31);

		JLabel labelChance32 = new JLabel();
		labelChance32.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance32,index_row,index_collum++);
		panelChance_3.add(labelChance32);

		JLabel labelChance33 = new JLabel();
		labelChance33.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance33,index_row,index_collum++);
		panelChance_3.add(labelChance33);

		JLabel labelChance34 = new JLabel();
		labelChance34.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance34,index_row++,index_collum++);
		panelChance_3.add(labelChance34);
		index_collum = 0;

		JPanel panelChance_4 = new JPanel();
		panelChance_4.setLayout(null);
		panelChance_4.setBorder(new TitledBorder(null, "4\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_4.setBounds(16, 362, 160, 60);
		panelGame.add(panelChance_4);

		JLabel labelChance41 = new JLabel();
		labelChance41.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance41,index_row,index_collum++);
		panelChance_4.add(labelChance41);

		JLabel labelChance42 = new JLabel();
		labelChance42.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance42,index_row,index_collum++);
		panelChance_4.add(labelChance42);

		JLabel labelChance43 = new JLabel();
		labelChance43.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance43,index_row,index_collum++);
		panelChance_4.add(labelChance43);

		JLabel labelChance44 = new JLabel();
		labelChance44.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance44,index_row++,index_collum++);
		panelChance_4.add(labelChance44);
		index_collum = 0;

		JPanel panelChance_5 = new JPanel();
		panelChance_5.setLayout(null);
		panelChance_5.setBorder(new TitledBorder(null, "5\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_5.setBounds(16, 307, 160, 60);
		panelGame.add(panelChance_5);

		JLabel labelChance51 = new JLabel();
		labelChance51.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance51,index_row,index_collum++);
		panelChance_5.add(labelChance51);

		JLabel labelChance52 = new JLabel();
		labelChance52.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance52,index_row,index_collum++);
		panelChance_5.add(labelChance52);

		JLabel labelChance53 = new JLabel();
		labelChance53.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance53,index_row,index_collum++);
		panelChance_5.add(labelChance53);

		JLabel labelChance54 = new JLabel();
		labelChance54.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance54,index_row++,index_collum++);
		panelChance_5.add(labelChance54);
		index_collum = 0;

		JPanel panelChance_6 = new JPanel();
		panelChance_6.setLayout(null);
		panelChance_6.setBorder(new TitledBorder(null, "6\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_6.setBounds(16, 252, 160, 60);
		panelGame.add(panelChance_6);

		JLabel labelChance61 = new JLabel();
		labelChance61.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance61,index_row,index_collum++);
		panelChance_6.add(labelChance61);

		JLabel labelChance62 = new JLabel();
		labelChance62.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance62,index_row,index_collum++);
		panelChance_6.add(labelChance62);

		JLabel labelChance63 = new JLabel();
		labelChance63.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance63,index_row,index_collum++);
		panelChance_6.add(labelChance63);

		JLabel labelChance64 = new JLabel();
		labelChance64.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance64,index_row++,index_collum++);
		panelChance_6.add(labelChance64);
		index_collum = 0;

		JPanel panelChance_7 = new JPanel();
		panelChance_7.setLayout(null);
		panelChance_7.setBorder(new TitledBorder(null, "7\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_7.setBounds(16, 196, 160, 60);
		panelGame.add(panelChance_7);

		JLabel labelChance71 = new JLabel();
		labelChance71.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance71,index_row,index_collum++);
		panelChance_7.add(labelChance71);

		JLabel labelChance72 = new JLabel();
		labelChance72.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance72,index_row,index_collum++);
		panelChance_7.add(labelChance72);

		JLabel labelChance73 = new JLabel();
		labelChance73.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance73,index_row,index_collum++);
		panelChance_7.add(labelChance73);

		JLabel labelChance74 = new JLabel();
		labelChance74.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance74,index_row++,index_collum++);
		panelChance_7.add(labelChance74);
		index_collum = 0;

		JPanel panelChance_8 = new JPanel();
		panelChance_8.setLayout(null);
		panelChance_8.setBorder(new TitledBorder(null, "8\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_8.setBounds(16, 140, 160, 60);
		panelGame.add(panelChance_8);

		JLabel labelChance81 = new JLabel();
		labelChance81.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance81,index_row,index_collum++);
		panelChance_8.add(labelChance81);

		JLabel labelChance82 = new JLabel();
		labelChance82.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance82,index_row,index_collum++);
		panelChance_8.add(labelChance82);

		JLabel labelChance83 = new JLabel();
		labelChance83.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance83,index_row,index_collum++);
		panelChance_8.add(labelChance83);

		JLabel labelChance84 = new JLabel();
		labelChance84.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance84,index_row++,index_collum++);
		panelChance_8.add(labelChance84);
		index_collum = 0;

		JPanel panelChance_9 = new JPanel();
		panelChance_9.setLayout(null);
		panelChance_9.setBorder(new TitledBorder(null, "9\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_9.setBounds(16, 84, 160, 60);
		panelGame.add(panelChance_9);

		JLabel labelChance91 = new JLabel();
		labelChance91.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance91,index_row,index_collum++);
		panelChance_9.add(labelChance91);

		JLabel labelChance92 = new JLabel();
		labelChance92.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance92,index_row,index_collum++);
		panelChance_9.add(labelChance92);

		JLabel labelChance93 = new JLabel();
		labelChance93.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance93,index_row,index_collum++);
		panelChance_9.add(labelChance93);

		JLabel labelChance94 = new JLabel();
		labelChance94.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance94,index_row++,index_collum++);
		panelChance_9.add(labelChance94);
		index_collum = 0;

		JPanel panelChance_10 = new JPanel();
		panelChance_10.setLayout(null);
		panelChance_10.setBorder(new TitledBorder(null, "10\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_10.setBounds(16, 30, 160, 60);
		panelGame.add(panelChance_10);

		JLabel labelChance101 = new JLabel();
		labelChance101.setBounds(4, 20, 35, 35);
		populeArrayChance(labelChance101,index_row,index_collum++);
		panelChance_10.add(labelChance101);

		JLabel labelChance102 = new JLabel();
		labelChance102.setBounds(43, 20, 35, 35);
		populeArrayChance(labelChance102,index_row,index_collum++);
		panelChance_10.add(labelChance102);

		JLabel labelChance103 = new JLabel();
		labelChance103.setBounds(82, 20, 35, 35);
		populeArrayChance(labelChance103,index_row,index_collum++);
		panelChance_10.add(labelChance103);

		JLabel labelChance104 = new JLabel();
		labelChance104.setBounds(121, 20, 35, 35);
		populeArrayChance(labelChance104,index_row,index_collum++);
		panelChance_10.add(labelChance104);
		index_collum = 0;
		index_row = 0;

		JPanel panelEvalue = new JPanel();
		panelEvalue.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEvalue.setBounds(188, 47, 45, 540);
		panelGame.add(panelEvalue);
		panelEvalue.setLayout(null);

		JPanel panelEvalueR1 = new JPanel();
		panelEvalueR1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEvalueR1.setBounds(6, 503, 33, 31);
		panelEvalue.add(panelEvalueR1);
		panelEvalueR1.setLayout(null);

		JLabel label_40 = new JLabel();
		label_40.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_40, index_row, index_collum++);
		panelEvalueR1.add(label_40);

		JLabel label_41 = new JLabel();
		label_41.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_41, index_row, index_collum++);
		panelEvalueR1.add(label_41);

		JLabel label_42 = new JLabel();
		label_42.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_42, index_row, index_collum++);
		panelEvalueR1.add(label_42);

		JLabel label_43 = new JLabel();
		label_43.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_43, index_row++, index_collum);
		panelEvalueR1.add(label_43);
		index_collum = 0;

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 449, 33, 31);
		panelEvalue.add(panel);

		JLabel label_44 = new JLabel();
		label_44.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_44, index_row, index_collum++);
		panel.add(label_44);

		JLabel label_45 = new JLabel();
		label_45.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_45, index_row, index_collum++);
		panel.add(label_45);

		JLabel label_46 = new JLabel();
		label_46.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_46, index_row, index_collum++);
		panel.add(label_46);

		JLabel label_47 = new JLabel();
		label_47.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_47, index_row++, index_collum);
		panel.add(label_47);
		index_collum = 0;

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 393, 33, 31);
		panelEvalue.add(panel_1);

		JLabel label_48 = new JLabel();
		label_48.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_48, index_row, index_collum++);
		panel_1.add(label_48);

		JLabel label_49 = new JLabel();
		label_49.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_49, index_row, index_collum++);
		panel_1.add(label_49);

		JLabel label_50 = new JLabel();
		label_50.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_50, index_row, index_collum++);
		panel_1.add(label_50);

		JLabel label_51 = new JLabel();
		label_51.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_51, index_row++, index_collum);
		panel_1.add(label_51);
		index_collum = 0;

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(6, 337, 33, 31);
		panelEvalue.add(panel_2);

		JLabel label_52 = new JLabel();
		label_52.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_52, index_row, index_collum++);
		panel_2.add(label_52);

		JLabel label_53 = new JLabel();
		label_53.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_53, index_row, index_collum++);
		panel_2.add(label_53);

		JLabel label_54 = new JLabel();
		label_54.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_54, index_row, index_collum++);
		panel_2.add(label_54);

		JLabel label_55 = new JLabel();
		label_55.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_55, index_row++, index_collum);
		panel_2.add(label_55);
		index_collum = 0;

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(6, 282, 33, 31);
		panelEvalue.add(panel_3);

		JLabel label_56 = new JLabel();
		label_56.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_56, index_row, index_collum++);
		panel_3.add(label_56);

		JLabel label_57 = new JLabel();
		label_57.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_57, index_row, index_collum++);
		panel_3.add(label_57);

		JLabel label_58 = new JLabel();
		label_58.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_58, index_row, index_collum++);
		panel_3.add(label_58);

		JLabel label_59 = new JLabel();
		label_59.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_59, index_row++, index_collum);
		panel_3.add(label_59);
		index_collum = 0;

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(6, 225, 33, 31);
		panelEvalue.add(panel_4);

		JLabel label_60 = new JLabel();
		label_60.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_60, index_row, index_collum++);
		panel_4.add(label_60);

		JLabel label_61 = new JLabel();
		label_61.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_61, index_row, index_collum++);
		panel_4.add(label_61);

		JLabel label_62 = new JLabel();
		label_62.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_62, index_row, index_collum++);
		panel_4.add(label_62);

		JLabel label_63 = new JLabel();
		label_63.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_63, index_row++, index_collum);
		panel_4.add(label_63);
		index_collum = 0;

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(6, 171, 33, 31);
		panelEvalue.add(panel_5);

		JLabel label_64 = new JLabel();
		label_64.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_64, index_row, index_collum++);
		panel_5.add(label_64);

		JLabel label_65 = new JLabel();
		label_65.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_65, index_row, index_collum++);
		panel_5.add(label_65);

		JLabel label_66 = new JLabel();
		label_66.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_66, index_row, index_collum++);
		panel_5.add(label_66);

		JLabel label_67 = new JLabel();
		label_67.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_67, index_row++, index_collum);
		panel_5.add(label_67);
		index_collum = 0;

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(6, 116, 33, 31);
		panelEvalue.add(panel_6);

		JLabel label_68 = new JLabel();
		label_68.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_68, index_row, index_collum++);
		panel_6.add(label_68);

		JLabel label_69 = new JLabel();
		label_69.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_69, index_row, index_collum++);
		panel_6.add(label_69);

		JLabel label_70 = new JLabel();
		label_70.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_70, index_row, index_collum++);
		panel_6.add(label_70);

		JLabel label_71 = new JLabel();
		label_71.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_71, index_row++, index_collum);
		panel_6.add(label_71);
		index_collum = 0;

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(6, 57, 33, 31);
		panelEvalue.add(panel_7);

		JLabel label_72 = new JLabel();
		label_72.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_72, index_row, index_collum++);
		panel_7.add(label_72);

		JLabel label_73 = new JLabel();
		label_73.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_73, index_row, index_collum++);
		panel_7.add(label_73);

		JLabel label_74 = new JLabel();
		label_74.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_74, index_row, index_collum++);
		panel_7.add(label_74);

		JLabel label_75 = new JLabel();
		label_75.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_75, index_row++, index_collum);
		panel_7.add(label_75);
		index_collum = 0;

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(6, 6, 33, 31);
		panelEvalue.add(panel_8);

		JLabel label_76 = new JLabel();
		label_76.setBounds(18, 2, 12, 12);
		populeArrayResponse(label_76, index_row, index_collum++);
		panel_8.add(label_76);

		JLabel label_77 = new JLabel();
		label_77.setBounds(3, 16, 12, 12);
		populeArrayResponse(label_77, index_row, index_collum++);
		panel_8.add(label_77);

		JLabel label_78 = new JLabel();
		label_78.setBounds(18, 16, 12, 12);
		populeArrayResponse(label_78, index_row, index_collum++);
		panel_8.add(label_78);

		JLabel label_79 = new JLabel();
		label_79.setBounds(3, 2, 12, 12);
		populeArrayResponse(label_79, index_row++, index_collum);
		panel_8.add(label_79);
		index_collum = 0;
		index_row = 0;

		JPanel panelChat = new JPanel();
		panelChat.setBorder(new TitledBorder(null, "Chat", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panelChat.setBounds(271, 256, 330, 410);
		frmMastermindGame.getContentPane().add(panelChat);
		panelChat.setLayout(null);

		btnSend = new JButton("Enviar");
		btnSend.setEnabled(false);
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String message = null;;
				if ((message = textToSend.getText()) != null) {
					clientController.sendMessageChat(textToSend.getText());
					textAreaChat.append("eu: " + message + "\n");
					textToSend.setText(null);
					textToSend.requestFocus();
				}
			}
		});
		btnSend.setBounds(247, 370, 70, 25);
		panelChat.add(btnSend);

		textToSend = new JTextField();
		textToSend.setEnabled(false);
		textToSend.setEditable(false);
		textToSend.setBounds(15, 370, 230, 25);
		panelChat.add(textToSend);
		textToSend.setColumns(10);

		textAreaChat = new JTextArea();
		textAreaChat.setEnabled(false);
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
				textToSend.setEnabled(true);
				textToSend.setEditable(true);
				clientController.initChat();
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
				textToSend.setEnabled(false);
				textToSend.setEditable(false);
				clientController.disconnectFromChat();
			}
		});
		btnDisconnect.setEnabled(false);
		btnDisconnect.setBounds(187, 66, 130, 25);
		panelChat.add(btnDisconnect);

		JLabel lblUser = new JLabel("Usu\u00E1rio");
		lblUser.setBounds(15, 21, 55, 14);
		panelChat.add(lblUser);

		JPanel panelPassword = new JPanel();
		panelPassword.setBorder(new TitledBorder(null, "Senha", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPassword.setBounds(271, 25, 330, 80);
		frmMastermindGame.getContentPane().add(panelPassword);
		panelPassword.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(22, 22, 54, 52);
		lblNewLabel.setIcon(Sprite.getColor(7));
		panelPassword.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(98, 22, 54, 52);
		lblNewLabel_1.setIcon(Sprite.getColor(7));
		panelPassword.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(174, 22, 54, 52);
		lblNewLabel_2.setIcon(Sprite.getColor(7));
		panelPassword.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(250, 22, 54, 52);
		lblNewLabel_3.setIcon(Sprite.getColor(7));
		panelPassword.add(lblNewLabel_3);

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
	private JLabel[][] getArrayLabels() {
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
		return index_row;
	}

	public void setMessageToTextAreaChat(String message) {
		getTextAreaChat().append(message + "\n");
	}

	public void setSequenceToGameView(int[] colorResponse) {
		for (int i = 0; i < colorResponse.length; i++) {
			getArrayLabels()[getIndex_row()][i].setIcon(Sprite.getColor(colorResponse[i]));
		}
	}

	public void setResponseToGameView(int[] colorResponse) {
		for (int i = 0; i < colorResponse.length; i++) {
			getArrayLabelsResponse()[getIndex_row()][i].setIcon(Sprite.getEvalueColors(colorResponse[i]));
		}
	}

	private void resetMoviment() {
		sequenceToSend[0] = sequenceToSend[1] = sequenceToSend[2] = sequenceToSend[3] = -1;
		move_1.setIcon(Sprite.getColor(6));
		move_2.setIcon(Sprite.getColor(6));
		move_3.setIcon(Sprite.getColor(6));
		move_4.setIcon(Sprite.getColor(6));
	}

	private void myTurnGame(boolean turn) {
		if (turn) {

			btnSendSequence.setEnabled(true);
			move_1.setEnabled(true);
			move_2.setEnabled(true);
			move_3.setEnabled(true);
			move_4.setEnabled(true);

		}else{

			btnSendSequence.setEnabled(true);
			move_1.setEnabled(true);
			move_2.setEnabled(true);
			move_3.setEnabled(true);
			move_4.setEnabled(true);

		}
		myTurn = turn;
	}

}
