/**
 * 
 */
package com.ldrr.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Diego
 * 
 */
public class ServerGame implements Runnable {

	private ServerSocket server;
	private List<Socket> listClient = new ArrayList<Socket>();

	public ServerGame() {
		requestConnect(6000);
	}

	public ServerGame(int port) {
		requestConnect(port);
	}

	private void requestConnect(int port) {
		try {
			this.server = new ServerSocket(port);
		} catch (IOException e) {
			requestConnect(port++);
			e.printStackTrace();
		}
	}

	public void sendMessage(String fromClient, ThreadServerGame thread) {
		DataOutputStream writer = null;
		for (Socket othreClient : listClient) {
			try {
				if (!othreClient.equals(thread.getClient())) {
					writer = new DataOutputStream(othreClient.getOutputStream());
					writer.writeUTF(fromClient);
					writer.flush();
				}
			} catch (IOException e) {
				System.out.println("Erro ao enviar mensagem.");
				e.printStackTrace();
			}
		}
	}

	public void disconnect(Socket client) {

		listClient.remove(client);
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			while (this.listClient.size() < 2) {
				Socket client;
				try {
					client = this.server.accept();
					listClient.add(client);
					new Thread(new ThreadServerGame(client, this)).start();
					if (this.listClient.size() == 2) {
						sendAlert(Commands.INIT_GAME.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void sendAlert(String ALERT) {
		DataOutputStream writer = null;
		for (Socket clients : listClient) {
			try {
				writer = new DataOutputStream(clients.getOutputStream());
				writer.writeUTF(ALERT);
				writer.flush();
			} catch (IOException e) {
				System.out.println("Erro ao enviar mensagem.");
				e.printStackTrace();
			}
		}
	}

}
