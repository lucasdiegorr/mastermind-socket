/**
 * 
 */
package com.ldrr.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Lucas-Diego
 *
 */
public class ClientGame implements Runnable{

	private Socket socket;
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private MessageGame message;
	private ClientController controller;

	//CONSTRUCTORS
	public ClientGame(ClientController controller) {
		connect("127.0.0.1", 5500);
		this.controller = controller;
	}

	public ClientGame(String address, int port, ClientController controller) {
		connect(address, port);
		this.controller = controller;
	}

	public ClientGame(String address, int port, String clientName, ClientController controller) {
		connect(address, port);
		this.controller = controller;
	}

	private void connect(String address, int port) {
		try {
			this.socket = new Socket(address, port);
			this.writer = new ObjectOutputStream(socket.getOutputStream());
			this.reader = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void run() {
		MessageGame messageFromServer;
		try {
			while (this.socket.isConnected() && ((messageFromServer = (MessageGame) reader.readObject()) != null)) {
				this.controller.sendSequenceToViewGame(messageFromServer.getColorResponse());
			}
		} catch (Exception e) {
			disconnect();
			e.printStackTrace();
		}
	}
	
	public void sendSequence(int[] sequence) {
		MessageGame message = new MessageGame();
		message.setColorSequence(sequence);
		try {
			this.writer.writeObject(message);
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
	
	/**
	 * @return the socket
	 */
	public Socket getSocket() {
		return socket;
	}

	/**
	 * @param socket the socket to set
	 */
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	/**
	 * @return the reader
	 */
	public ObjectInputStream getReader() {
		return reader;
	}

	/**
	 * @param reader the reader to set
	 */
	public void setReader(ObjectInputStream reader) {
		this.reader = reader;
	}

	/**
	 * @return the writer
	 */
	public ObjectOutputStream getWriter() {
		return writer;
	}

	/**
	 * @param writer the writer to set
	 */
	public void setWriter(ObjectOutputStream writer) {
		this.writer = writer;
	}

	/**
	 * @return the message
	 */
	public MessageGame getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(MessageGame message) {
		this.message = message;
	}



}
