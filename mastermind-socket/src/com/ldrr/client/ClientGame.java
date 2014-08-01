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
public class ClientGame implements Runnable {

	private Socket socket;
	private DataOutputStream writer;
	private DataInputStream reader;
	private ClientController controller;

	//CONSTRUCTORS
	public ClientGame(ClientController controller) {
		connect("127.0.0.1", 6000);
		this.controller = controller;
	}

	public ClientGame(String address, int port, ClientController controller) {
		connect(address, port);
		this.controller = controller;
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

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String messageFromServer;
		try {
			while (this.socket.isConnected() && ((messageFromServer = reader.readUTF()) != null)) {
				if (isAlert(messageFromServer)) {
				}else{
					int[] sequence = convertToIntArray(messageFromServer);
					this.controller.receivedSequenceGame(sequence);
				}
			}
		} catch (IOException e) {
			disconnect();
			this.controller.Alert(true);
			e.printStackTrace();
		}
	}

	private boolean isAlert(String messageFromServer) {
		if (messageFromServer.equals("DISCONNECTED")) {
			this.controller.Alert(true);
			return true;
		}else if (messageFromServer.equals("RESETGAME")) {
			this.controller.Alert(false);
			return true;
		}
		return false;
	}

	public void sendSequence(int[] sequence) {
		String sequensceString = convertToString(sequence);
		sendMessage(sequensceString);
	}

	public void sendMessage(String string) {
		try {
			this.writer.writeUTF(string);
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

	private String convertToString(int[] sequence) {
		String toConvert = "";
		for (int i = 0; i < sequence.length; i++) {
			toConvert += sequence[i];
		}
		return toConvert;
	}

	private int[] convertToIntArray(String messageFromServer) {

		char[] arrayCh = messageFromServer.toCharArray();
		int[] arrayInt = new int[arrayCh.length];

		for (int i = 0; i < arrayCh.length; i++) {
			arrayInt[i] = Integer.parseInt(String.valueOf(arrayCh[i]));
		}

		return arrayInt;
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

}
