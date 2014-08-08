package com.ldrr.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 */

/**
 * @author Lucas Diego
 * 
 */
public class ClientChat implements Runnable {

	private Socket socket;
	private DataOutputStream writer;
	private DataInputStream reader;
	private String clientName;
	private ClientController controller;
	private int emoticon;

	// CONSTRUCTORS
	public ClientChat(ClientController controller) {
		connect("127.0.0.1", 5000);
		this.controller = controller;
		this.clientName = "An�nimo";
		this.emoticon = 0;
	}

	public ClientChat(String address, int port, ClientController controller) {
		connect(address, port);
		this.controller = controller;
		this.clientName = "An�nimo";
		this.emoticon = 0;
	}

	public ClientChat(String address, int port, String clientName,
			ClientController controller) {
		connect(address, port);
		this.controller = controller;
		this.clientName = clientName;
		this.emoticon = 0;
	}

	private void connect(String address, int port) {
		try {
			this.socket = new Socket(address, port);
			this.writer = new DataOutputStream(socket.getOutputStream());
			this.reader = new DataInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String messageFromServer;
		try {
			while (this.socket.isConnected()
					&& ((messageFromServer = reader.readUTF()) != null)) {
				receivedMessageChat(messageFromServer);
			}
		} catch (IOException e) {
			disconnect();
		}
	}

	private void receivedMessageChat(String messageFromServer) {
		String serverPacket[] = messageFromServer.split("&");
		this.controller.setEnemyNick(serverPacket[0]);
		this.controller.setEnemyEmoticon(Integer.parseInt(serverPacket[1]));
		this.controller.receivedMessageChat(serverPacket[0] + ": " + serverPacket[2]);
	}

	public void sendMessage(String string) {
		try {
			this.writer.writeUTF(clientName+ "&" + emoticon + "&" + string);
			this.writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void disconnect() {
		try {
			this.reader.close();
			this.writer.close();
			this.socket.close();
		} catch (IOException e) {
			System.out.println("Socket desconectado.");
			e.printStackTrace();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public DataInputStream getReader() {
		return reader;
	}

	public DataOutputStream getWriter() {
		return writer;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public String getClientName() {
		return clientName;
	}

	public void setEmoticon(int emoticon) {
		this.emoticon = emoticon;
	}
}
