package com.ldrr.graphic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.ldrr.server.ServerChat;
import com.ldrr.server.ServerGame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Inicial {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager
					.getLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial window = new Inicial();
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
	public Inicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 255);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblBemVindoAo = new JLabel("Bem vindo ao Jogo MasterMind");
		lblBemVindoAo.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC,
				22));
		lblBemVindoAo.setBounds(8, 17, 422, 66);
		frame.getContentPane().add(lblBemVindoAo);

		JButton btnDesafiante = new JButton("Desafiante");
		btnDesafiante.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC,
				13));
		btnDesafiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new GameFrame(true);
							frame.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnDesafiante.setBounds(161, 131, 116, 29);
		frame.getContentPane().add(btnDesafiante);

		JButton btnDesafiado = new JButton("Desafiado");
		btnDesafiado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ServerChat chat = new ServerChat();
							ServerGame game = new ServerGame();
							new Thread(chat).start();
							new Thread(game).start();
							new GameFrame(false);
							frame.setVisible(false);
							JOptionPane.showMessageDialog(
									null,
									"Jogue com seu amigo informando onde está através dos endereços:\n"
											+ "Game Server: "
											+ game.getAddress() + " - Sala: "+ game.getPort() +"\n"
											+ "Chat: "
											+ chat.getAddress() + " - Sala: " + chat.getPort());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnDesafiado.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC,
				13));
		btnDesafiado.setBounds(161, 172, 116, 29);
		frame.getContentPane().add(btnDesafiado);

		JLabel lblQuemGostariaDe = new JLabel("Quem gostaria de ser?");
		lblQuemGostariaDe.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblQuemGostariaDe.setBounds(135, 81, 169, 24);
		frame.getContentPane().add(lblQuemGostariaDe);
	}
}
