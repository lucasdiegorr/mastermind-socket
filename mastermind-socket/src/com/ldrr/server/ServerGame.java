/**
 * 
 */
package com.ldrr.server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.ldrr.client.MessageGame;

/**
 * @author Lucas Diego
 *
 */
public class ServerGame {

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
			System.out.println("Server de Game on.");
			while(true){
				Socket client = this.server.accept();
				listClient.add(client);
				System.out.println("Server on e com " + this.listClient.size() + " usuarios.");
				new Thread(new ThreadServerGame(client, this)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(MessageGame fromClient, ThreadServerGame thread) {
		ObjectOutputStream writer = null;
		for (Socket othreClient : listClient) {
			try {
				if (!othreClient.equals(thread.getClient())) {
					writer = new ObjectOutputStream(othreClient.getOutputStream());
					writer.writeObject(fromClient);
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ServerGame();
	}
}
