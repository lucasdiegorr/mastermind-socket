package com.ldrr.server.custom;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

import com.ldrr.client.MessageChat;

/**
 * 
 */

/**
 * @author Lucas Diego
 * 
 */
public class ServerChat implements Runnable {

	private ServerSocket server;
	private List<Socket> listClient = new ArrayList<Socket>();

	public ServerChat() {
		requestConnect(5000);
	}

	public ServerChat(int port) {
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

	public void sendMessage(String fromClient, ThreadServerChat thread) {
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
					System.out.println("Server on e com " + this.listClient.size()
							+ " usuarios.");
					new Thread(new ThreadServerChat(client, this)).start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void sendAlertDisconnect(ThreadServerChat threadServerChat) {
		MessageChat message = new MessageChat(null, 8, "O outro usuário saiu do chat\n");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream writer = null;
		for (Socket othreClient : listClient) {
			try {
				if (!othreClient.equals(threadServerChat.getClient())) {
					writer = new DataOutputStream(othreClient.getOutputStream());
					new ObjectOutputStream(baos).writeObject(message);
					writer.writeUTF(Base64.encodeBase64String(baos.toByteArray()));
					writer.flush();
				}
			} catch (IOException e) {
				System.out.println("Erro ao enviar mensagem.");
				e.printStackTrace();
			}
		}
	}

}
