/**
 * 
 */
package com.ldrr.server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Diego
 *
 */
public class ServerGame implements Runnable{

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
		while(true){
			Socket client;
			try {
				client = this.server.accept();
				listClient.add(client);
				new Thread(new ThreadServerGame(client, this)).start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void sendAlert() {
		DataOutputStream writer = null;
		for (Socket clients : listClient) {
			try {
				writer = new DataOutputStream(clients.getOutputStream());
				writer.writeUTF("DISCONNECTED");
				writer.flush();
			} catch (IOException e) {
				System.out.println("Erro ao enviar mensagem.");
				e.printStackTrace();
			}
		}
	}

	public String getAddress() {
		String address = null;
		try {
			address =  ""+Inet4Address.getLocalHost().getHostAddress() + " : " + this.server.getLocalPort();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return address;
	}
}
