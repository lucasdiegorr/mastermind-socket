package com.ldrr.chat.client;
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
	
	//CONSTRUCTORS
	
	public ClientChat(ClientController controller) {
		connect("127.0.0.1", 5000);
		this.controller = controller;
		this.clientName = "Anônimo";
	}
	
	public ClientChat(String address, int port, ClientController controller) {
		connect(address, port);
		this.controller = controller;
		this.clientName = "Anônimo";
	}
	
	public ClientChat(String address, int port, String clientName, ClientController controller) {
		connect(address, port);
		this.controller = controller;
		this.clientName = clientName;
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
				System.out.println("Esperando mensagem do servidor...");
				this.controller.receivedMessage(messageFromServer);
			}
		} catch (IOException e) {
			disconnect();
			System.out.println("Adeus mundo cruel.");
			e.printStackTrace();
		}
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

}
