package com.ldrr.graphic;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
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
import javax.swing.UIManager;


public class GameFrame {

	private static ClientController clientController;
	private JFrame frmMastermindGame;
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
	private JLabel[][] arrayLabels;
	private int chance = 0;
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
					GameFrame window = new GameFrame();
					window.frmMastermindGame.setVisible(true);
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
		frmMastermindGame = new JFrame();
		frmMastermindGame.setTitle("MasterMind Game");
		frmMastermindGame.setBounds(100, 100, 630, 710);
		frmMastermindGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMastermindGame.getContentPane().setLayout(null);

		JPanel panelGame = new JPanel();
		panelGame.setBackground(Color.WHITE);
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
		panelMove.add(move_1);

		move_2 = new JLabel();
		move_2.setBounds(43, 20, 35, 35);
		move_2.setIcon(Sprite.getColor(6));
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
		panelMove.add(move_2);

		move_3 = new JLabel();
		move_3.setBounds(82, 20, 35, 35);
		move_3.setIcon(Sprite.getColor(6));
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
		panelMove.add(move_3);

		move_4 = new JLabel();
		move_4.setBounds(121, 20, 35, 35);
		move_4.setIcon(Sprite.getColor(6));
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
		panelMove.add(move_4);
		
		btnSendSequence = new JButton();
		btnSendSequence.setIcon(Sprite.getIconButton(0));
		btnSendSequence.setBounds(188, 609, 45, 45);
		panelGame.add(btnSendSequence);
		
		JPanel panelChance_1 = new JPanel();
		panelChance_1.setLayout(null);
		panelChance_1.setBorder(new TitledBorder(null, "1\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_1.setBounds(16, 529, 160, 60);
		panelGame.add(panelChance_1);
		
		JLabel label = new JLabel();
		label.setBounds(4, 20, 35, 35);
		populeArray(label,index_row,index_collum++);
		panelChance_1.add(label);
		
		JLabel label_1 = new JLabel();
		label_1.setBounds(43, 20, 35, 35);
		populeArray(label_1,index_row,index_collum++);
		panelChance_1.add(label_1);
		
		JLabel label_2 = new JLabel();
		label_2.setBounds(82, 20, 35, 35);
		populeArray(label_2,index_row, index_collum++);
		panelChance_1.add(label_2);
		
		JLabel label_3 = new JLabel();
		label_3.setBounds(121, 20, 35, 35);
		populeArray(label_3,index_row++,index_collum);
		panelChance_1.add(label_3);
		index_collum = 0;
		
		JPanel panelChance_2 = new JPanel();
		panelChance_2.setLayout(null);
		panelChance_2.setBorder(new TitledBorder(null, "2\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_2.setBounds(16, 473, 160, 60);
		panelGame.add(panelChance_2);
		
		JLabel label_4 = new JLabel();
		label_4.setBounds(4, 20, 35, 35);
		populeArray(label_4,index_row,index_collum++);
		panelChance_2.add(label_4);
		
		JLabel label_5 = new JLabel();
		label_5.setBounds(43, 20, 35, 35);
		populeArray(label_5,index_row,index_collum++);
		panelChance_2.add(label_5);
		
		JLabel label_6 = new JLabel();
		label_6.setBounds(82, 20, 35, 35);
		populeArray(label_6,index_row,index_collum++);
		panelChance_2.add(label_6);
		
		JLabel label_7 = new JLabel();
		label_7.setBounds(121, 20, 35, 35);
		populeArray(label_7,index_row++,index_collum++);
		panelChance_2.add(label_7);
		index_collum = 0;
		
		JPanel panelChance_3 = new JPanel();
		panelChance_3.setLayout(null);
		panelChance_3.setBorder(new TitledBorder(null, "3\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_3.setBounds(16, 418, 160, 60);
		panelGame.add(panelChance_3);
		
		JLabel label_8 = new JLabel();
		label_8.setBounds(4, 20, 35, 35);
		populeArray(label_8,index_row,index_collum++);
		panelChance_3.add(label_8);
		
		JLabel label_9 = new JLabel();
		populeArray(label_9,index_row,index_collum++);
		panelChance_3.add(label_9);
		
		JLabel label_10 = new JLabel();
		label_10.setBounds(82, 20, 35, 35);
		populeArray(label_10,index_row,index_collum++);
		panelChance_3.add(label_10);
		
		JLabel label_11 = new JLabel();
		label_11.setBounds(121, 20, 35, 35);
		populeArray(label_11,index_row++,index_collum++);
		panelChance_3.add(label_11);
		index_collum = 0;
		
		JPanel panelChance_4 = new JPanel();
		panelChance_4.setLayout(null);
		panelChance_4.setBorder(new TitledBorder(null, "4\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_4.setBounds(16, 362, 160, 60);
		panelGame.add(panelChance_4);
		
		JLabel label_12 = new JLabel();
		label_12.setBounds(4, 20, 35, 35);
		populeArray(label_12,index_row,index_collum++);
		panelChance_4.add(label_12);
		
		JLabel label_13 = new JLabel();
		label_13.setBounds(43, 20, 35, 35);
		populeArray(label_13,index_row,index_collum++);
		panelChance_4.add(label_13);
		
		JLabel label_14 = new JLabel();
		label_14.setBounds(82, 20, 35, 35);
		populeArray(label_14,index_row,index_collum++);
		panelChance_4.add(label_14);
		
		JLabel label_15 = new JLabel();
		label_15.setBounds(121, 20, 35, 35);
		populeArray(label_15,index_row++,index_collum++);
		panelChance_4.add(label_15);
		index_collum = 0;
		
		JPanel panelChance_5 = new JPanel();
		panelChance_5.setLayout(null);
		panelChance_5.setBorder(new TitledBorder(null, "5\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_5.setBounds(16, 307, 160, 60);
		panelGame.add(panelChance_5);
		
		JLabel label_16 = new JLabel();
		label_16.setBounds(4, 20, 35, 35);
		populeArray(label_16,index_row,index_collum++);
		panelChance_5.add(label_16);
		
		JLabel label_17 = new JLabel();
		label_17.setBounds(43, 20, 35, 35);
		populeArray(label_17,index_row,index_collum++);
		panelChance_5.add(label_17);
		
		JLabel label_18 = new JLabel();
		label_18.setBounds(82, 20, 35, 35);
		populeArray(label_18,index_row,index_collum++);
		panelChance_5.add(label_18);
		
		JLabel label_19 = new JLabel();
		label_19.setBounds(121, 20, 35, 35);
		populeArray(label_19,index_row++,index_collum++);
		panelChance_5.add(label_19);
		index_collum = 0;
		
		JPanel panelChance_6 = new JPanel();
		panelChance_6.setLayout(null);
		panelChance_6.setBorder(new TitledBorder(null, "6\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_6.setBounds(16, 252, 160, 60);
		panelGame.add(panelChance_6);
		
		JLabel label_20 = new JLabel();
		label_20.setBounds(4, 20, 35, 35);
		populeArray(label_20,index_row,index_collum++);
		panelChance_6.add(label_20);
		
		JLabel label_21 = new JLabel();
		label_21.setBounds(43, 20, 35, 35);
		populeArray(label_21,index_row,index_collum++);
		panelChance_6.add(label_21);
		
		JLabel label_22 = new JLabel();
		label_22.setBounds(82, 20, 35, 35);
		populeArray(label_22,index_row,index_collum++);
		panelChance_6.add(label_22);
		
		JLabel label_23 = new JLabel();
		label_23.setBounds(121, 20, 35, 35);
		populeArray(label_23,index_row++,index_collum++);
		panelChance_6.add(label_23);
		index_collum = 0;
		
		JPanel panelChance_7 = new JPanel();
		panelChance_7.setLayout(null);
		panelChance_7.setBorder(new TitledBorder(null, "7\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_7.setBounds(16, 196, 160, 60);
		panelGame.add(panelChance_7);
		
		JLabel label_24 = new JLabel();
		label_24.setBounds(4, 20, 35, 35);
		populeArray(label_24,index_row,index_collum++);
		panelChance_7.add(label_24);
		
		JLabel label_25 = new JLabel();
		label_25.setBounds(43, 20, 35, 35);
		populeArray(label_25,index_row,index_collum++);
		panelChance_7.add(label_25);
		
		JLabel label_26 = new JLabel();
		label_26.setBounds(82, 20, 35, 35);
		populeArray(label_26,index_row,index_collum++);
		panelChance_7.add(label_26);
		
		JLabel label_27 = new JLabel();
		label_27.setBounds(121, 20, 35, 35);
		populeArray(label_27,index_row++,index_collum++);
		panelChance_7.add(label_27);
		index_collum = 0;
		
		JPanel panelChance_8 = new JPanel();
		panelChance_8.setLayout(null);
		panelChance_8.setBorder(new TitledBorder(null, "8\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_8.setBounds(16, 140, 160, 60);
		panelGame.add(panelChance_8);
		
		JLabel label_28 = new JLabel();
		label_28.setBounds(4, 20, 35, 35);
		populeArray(label_28,index_row,index_collum++);
		panelChance_8.add(label_28);
		
		JLabel label_29 = new JLabel();
		label_29.setBounds(43, 20, 35, 35);
		populeArray(label_29,index_row,index_collum++);
		panelChance_8.add(label_29);
		
		JLabel label_30 = new JLabel();
		label_30.setBounds(82, 20, 35, 35);
		populeArray(label_30,index_row,index_collum++);
		panelChance_8.add(label_30);
		
		JLabel label_31 = new JLabel();
		label_31.setBounds(121, 20, 35, 35);
		populeArray(label_31,index_row++,index_collum++);
		panelChance_8.add(label_31);
		index_collum = 0;
		
		JPanel panelChance_9 = new JPanel();
		panelChance_9.setLayout(null);
		panelChance_9.setBorder(new TitledBorder(null, "9\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_9.setBounds(16, 84, 160, 60);
		panelGame.add(panelChance_9);
		
		JLabel label_32 = new JLabel();
		label_32.setBounds(4, 20, 35, 35);
		populeArray(label_32,index_row,index_collum++);
		panelChance_9.add(label_32);
		
		JLabel label_33 = new JLabel();
		label_33.setBounds(43, 20, 35, 35);
		populeArray(label_33,index_row,index_collum++);
		panelChance_9.add(label_33);
		
		JLabel label_34 = new JLabel();
		label_34.setBounds(82, 20, 35, 35);
		populeArray(label_34,index_row,index_collum++);
		panelChance_9.add(label_34);
		
		JLabel label_35 = new JLabel();
		label_35.setBounds(121, 20, 35, 35);
		populeArray(label_35,index_row++,index_collum++);
		panelChance_9.add(label_35);
		index_collum = 0;
		
		JPanel panelChance_10 = new JPanel();
		panelChance_10.setLayout(null);
		panelChance_10.setBorder(new TitledBorder(null, "10\u00BA Chance", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChance_10.setBounds(16, 30, 160, 60);
		panelGame.add(panelChance_10);
		
		JLabel label_36 = new JLabel();
		label_36.setBounds(4, 20, 35, 35);
		populeArray(label_36,index_row,index_collum++);
		panelChance_10.add(label_36);
		
		JLabel label_37 = new JLabel();
		label_37.setBounds(43, 20, 35, 35);
		populeArray(label_37,index_row,index_collum++);
		panelChance_10.add(label_37);
		
		JLabel label_38 = new JLabel();
		label_38.setBounds(82, 20, 35, 35);
		populeArray(label_38,index_row,index_collum++);
		panelChance_10.add(label_38);
		
		JLabel label_39 = new JLabel();
		label_39.setBounds(121, 20, 35, 35);
		populeArray(label_39,index_row,index_collum++);
		panelChance_10.add(label_39);
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
		label_40.setIcon(Sprite.getEvalueColors(0));
		panelEvalueR1.add(label_40);
		
		JLabel label_41 = new JLabel();
		label_41.setBounds(3, 16, 12, 12);
		label_41.setIcon(Sprite.getEvalueColors(0));
		panelEvalueR1.add(label_41);
		
		JLabel label_42 = new JLabel();
		label_42.setBounds(18, 16, 12, 12);
		label_42.setIcon(Sprite.getEvalueColors(0));
		panelEvalueR1.add(label_42);
		
		JLabel label_43 = new JLabel();
		label_43.setBounds(3, 2, 12, 12);
		label_43.setIcon(Sprite.getEvalueColors(0));
		panelEvalueR1.add(label_43);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 449, 33, 31);
		panelEvalue.add(panel);
		
		JLabel label_44 = new JLabel();
		label_44.setBounds(18, 2, 12, 12);
		panel.add(label_44);
		
		JLabel label_45 = new JLabel();
		label_45.setBounds(3, 16, 12, 12);
		panel.add(label_45);
		
		JLabel label_46 = new JLabel();
		label_46.setBounds(18, 16, 12, 12);
		panel.add(label_46);
		
		JLabel label_47 = new JLabel();
		label_47.setBounds(3, 2, 12, 12);
		panel.add(label_47);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(6, 393, 33, 31);
		panelEvalue.add(panel_1);
		
		JLabel label_48 = new JLabel();
		label_48.setBounds(18, 2, 12, 12);
		panel_1.add(label_48);
		
		JLabel label_49 = new JLabel();
		label_49.setBounds(3, 16, 12, 12);
		panel_1.add(label_49);
		
		JLabel label_50 = new JLabel();
		label_50.setBounds(18, 16, 12, 12);
		panel_1.add(label_50);
		
		JLabel label_51 = new JLabel();
		label_51.setBounds(3, 2, 12, 12);
		panel_1.add(label_51);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(6, 337, 33, 31);
		panelEvalue.add(panel_2);
		
		JLabel label_52 = new JLabel();
		label_52.setBounds(18, 2, 12, 12);
		panel_2.add(label_52);
		
		JLabel label_53 = new JLabel();
		label_53.setBounds(3, 16, 12, 12);
		panel_2.add(label_53);
		
		JLabel label_54 = new JLabel();
		label_54.setBounds(18, 16, 12, 12);
		panel_2.add(label_54);
		
		JLabel label_55 = new JLabel();
		label_55.setBounds(3, 2, 12, 12);
		panel_2.add(label_55);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(6, 282, 33, 31);
		panelEvalue.add(panel_3);
		
		JLabel label_56 = new JLabel();
		label_56.setBounds(18, 2, 12, 12);
		panel_3.add(label_56);
		
		JLabel label_57 = new JLabel();
		label_57.setBounds(3, 16, 12, 12);
		panel_3.add(label_57);
		
		JLabel label_58 = new JLabel();
		label_58.setBounds(18, 16, 12, 12);
		panel_3.add(label_58);
		
		JLabel label_59 = new JLabel();
		label_59.setBounds(3, 2, 12, 12);
		panel_3.add(label_59);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(6, 225, 33, 31);
		panelEvalue.add(panel_4);
		
		JLabel label_60 = new JLabel();
		label_60.setBounds(18, 2, 12, 12);
		panel_4.add(label_60);
		
		JLabel label_61 = new JLabel();
		label_61.setBounds(3, 16, 12, 12);
		panel_4.add(label_61);
		
		JLabel label_62 = new JLabel();
		label_62.setBounds(18, 16, 12, 12);
		panel_4.add(label_62);
		
		JLabel label_63 = new JLabel();
		label_63.setBounds(3, 2, 12, 12);
		panel_4.add(label_63);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(6, 171, 33, 31);
		panelEvalue.add(panel_5);
		
		JLabel label_64 = new JLabel();
		label_64.setBounds(18, 2, 12, 12);
		panel_5.add(label_64);
		
		JLabel label_65 = new JLabel();
		label_65.setBounds(3, 16, 12, 12);
		panel_5.add(label_65);
		
		JLabel label_66 = new JLabel();
		label_66.setBounds(18, 16, 12, 12);
		panel_5.add(label_66);
		
		JLabel label_67 = new JLabel();
		label_67.setBounds(3, 2, 12, 12);
		panel_5.add(label_67);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(6, 116, 33, 31);
		panelEvalue.add(panel_6);
		
		JLabel label_68 = new JLabel();
		label_68.setBounds(18, 2, 12, 12);
		panel_6.add(label_68);
		
		JLabel label_69 = new JLabel();
		label_69.setBounds(3, 16, 12, 12);
		panel_6.add(label_69);
		
		JLabel label_70 = new JLabel();
		label_70.setBounds(18, 16, 12, 12);
		panel_6.add(label_70);
		
		JLabel label_71 = new JLabel();
		label_71.setBounds(3, 2, 12, 12);
		panel_6.add(label_71);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBounds(6, 57, 33, 31);
		panelEvalue.add(panel_7);
		
		JLabel label_72 = new JLabel();
		label_72.setBounds(18, 2, 12, 12);
		panel_7.add(label_72);
		
		JLabel label_73 = new JLabel();
		label_73.setBounds(3, 16, 12, 12);
		panel_7.add(label_73);
		
		JLabel label_74 = new JLabel();
		label_74.setBounds(18, 16, 12, 12);
		panel_7.add(label_74);
		
		JLabel label_75 = new JLabel();
		label_75.setBounds(3, 2, 12, 12);
		panel_7.add(label_75);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBounds(6, 6, 33, 31);
		panelEvalue.add(panel_8);
		
		JLabel label_76 = new JLabel();
		label_76.setBounds(18, 2, 12, 12);
		panel_8.add(label_76);
		
		JLabel label_77 = new JLabel();
		label_77.setBounds(3, 16, 12, 12);
		panel_8.add(label_77);
		
		JLabel label_78 = new JLabel();
		label_78.setBounds(18, 16, 12, 12);
		panel_8.add(label_78);
		
		JLabel label_79 = new JLabel();
		label_79.setBounds(3, 2, 12, 12);
		panel_8.add(label_79);

		JPanel panelChat = new JPanel();
		panelChat.setBackground(Color.WHITE);
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
					clientController.sendMessageToServer(textToSend.getText());
					textAreaChat.setSelectedTextColor(Color.GREEN);
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

	private void populeArray(JLabel label, int i, int j) {
		this.arrayLabels[i][j] = label;
	}

	public JTextArea getTextAreaChat() {
		return textAreaChat;
	}
}
