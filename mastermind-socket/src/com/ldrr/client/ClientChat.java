package com.ldrr.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.codec.binary.Base64;

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
		this.setController(controller);
		this.setEmoticon(0);
	}

	public ClientChat(String address, int port, ClientController controller) {
		connect(address, port);
		this.setController(controller);
		this.setEmoticon(0);
	}

	public ClientChat(String address, int port, String clientName,
			ClientController controller) {
		connect(address, port);
		this.setController(controller);
		this.setClientName(clientName);
		this.setEmoticon(0);
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
			while (((messageFromServer = getReader().readUTF()) != null)) {
				receivedMessageChat(messageFromServer);
			}
		} catch (IOException e) {
			disconnect();
		}
	}

	private void connect(String address, int port) {
		try {
			this.setSocket(new Socket(address, port));
			this.setWriter(new DataOutputStream(getSocket().getOutputStream()));
			this.setReader(new DataInputStream(getSocket().getInputStream()));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void disconnect() {
		try {
			this.getReader().close();
			this.getWriter().close();
			this.getSocket().close();
		} catch (IOException e) {
			System.out.println("Socket desconectado.");
			e.printStackTrace();
		}
	}

	private void receivedMessageChat(String messageFromServer) {
		ByteArrayInputStream byteArrayInput = new ByteArrayInputStream(Base64.decodeBase64(messageFromServer));
		MessageChat message = null; 

		try {
			message = (MessageChat) new ObjectInputStream(byteArrayInput).readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		if (message.getNickName() == null) {
			this.getController().setEnemyNick("Anônimo");
			this.getController().receivedMessageChat(message.getMessage());
		}else {
			this.getController().setEnemyNick(message.getNickName());				
			this.getController().receivedMessageChat(message.getNickName() + ": " + message.getMessage());
		}

		this.getController().setEnemyEmoticon(message.getEmoticon());
	}

	public void sendMessage(String string) {
		MessageChat message = new MessageChat(this.getClientName(), this.getEmoticon(), string);
		ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
		try {
			new ObjectOutputStream(byteArrayOutput).writeObject(message);
			this.getWriter().writeUTF(Base64.encodeBase64String(byteArrayOutput.toByteArray()));
			this.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//GETTERS AND SETTERS
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

	/**
	 * @return the emoticon
	 */
	public int getEmoticon() {
		return emoticon;
	}

	/**
	 * @return the controller
	 */
	public ClientController getController() {
		return controller;
	}

	/**
	 * @param controller the controller to set
	 */
	public void setController(ClientController controller) {
		this.controller = controller;
	}

	/**
	 * @param socket the socket to set
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * @param writer the writer to set
	 */
	public void setWriter(DataOutputStream writer) {
		this.writer = writer;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(DataInputStream reader) {
		this.reader = reader;
	}

	public String getAddress() {
		String address = null;
		try {
			address = ""+ InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return address;
	}

	public int getPort() {
		return this.getSocket().getPort();
	}
}
