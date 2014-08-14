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

import com.ldrr.server.generic.Commands;

/**
 * 
 */

/**
 * @author Lucas Diego
 * 
 */
public class ClientGame implements Runnable {

	private Socket socket;
	private DataOutputStream writer;
	private DataInputStream reader;
	private ClientController controller;

	// CONSTRUCTORS
	public ClientGame(ClientController controller) {
		connect("127.0.0.1", 6000);
		this.setController(controller);
	}

	public ClientGame(String address, int port, ClientController controller) {
		connect(address, port);
		this.setController(controller);
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
				if (isAlert(messageFromServer)) {
				} else {
					int[] sequence = convertToIntArray(messageFromServer);
					this.getController().receivedSequenceGame(sequence);
				}
			}
		} catch (IOException e) {
			disconnect();
			this.getController().Alert(Commands.DISCONNECT);
			e.printStackTrace();
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

	private boolean isAlert(String messageFromServer) {

		if (Commands.DISCONNECT.toString().equals(messageFromServer)) {
			this.getController().Alert(Commands.DISCONNECT);
			return true;
		} else if (Commands.RESET_GAME.toString().equals(messageFromServer)) {
			this.getController().Alert(Commands.RESET_GAME);
			return true;
		}else if (Commands.INIT_GAME.toString().equals(messageFromServer)) {
			this.getController().Alert(Commands.INIT_GAME);
			return true;
		}

		return false;
	}

	public void sendSequence(int[] sequence) {
		String stringSequence = convertToString(sequence);
		sendMessage(stringSequence);
	}

	public void sendMessage(String string) {
		try {
			this.getWriter().writeUTF(string);
			this.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String convertToString(int[] sequence) {
		ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
		try {
			new ObjectOutputStream(byteArrayOutput).writeObject(sequence);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Base64.encodeBase64String(byteArrayOutput.toByteArray());
	}

	private int[] convertToIntArray(String messageFromServer) {
		ByteArrayInputStream byteArrayInput = new ByteArrayInputStream(Base64.decodeBase64(messageFromServer));
		int[] sequence = null;
		try {
			sequence = (int[]) new ObjectInputStream(byteArrayInput).readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return sequence;
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
