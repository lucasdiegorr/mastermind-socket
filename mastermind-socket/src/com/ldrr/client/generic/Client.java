/**
 * 
 */
package com.ldrr.client.generic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.ldrr.client.ClientController;

/**
 * @author Lucas Diego
 *
 */
public class Client {
	
	private Socket socket;
	private DataOutputStream writer;
	private DataInputStream reader;
	private ClientController controller;
	
	public Client(String address, int port, ClientController controller) {
		connect(address, port);
		this.setController(controller);
	}
	
	/**
	 * Create a socket with the specifications and port address passed as a parameter
	 * Cria um socket com as as especifica��es de porta e endere�o passados como par�metro
	 * 
	 * @param address - ip address to make the connection - endere�o de ip para realizar a conex�o
	 * @param port - port for the connection - porta para a conex�o
	 */
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
	
	/**
	 * Closes all connections
	 * Fecha todas as conex�es
	 */
	public void disconnect() {
		try {
			this.getReader().close();
			this.getWriter().close();
			this.getSocket().close();
		} catch (IOException e) {
			System.out.println("Socket desconectado.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Send a message to the server
	 * Envia uma mensagem ao servidor
	 * @param message - message to be sent - mensagem a ser enviada
	 */
	public void sendMessage(String message) {
		try {
			this.getWriter().writeUTF(message);
			this.getWriter().flush();
		} catch (IOException e) {
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
	 * @return the writer
	 */
	public DataOutputStream getWriter() {
		return writer;
	}
	/**
	 * @param writer the writer to set
	 */
	public void setWriter(DataOutputStream writer) {
		this.writer = writer;
	}
	/**
	 * @return the reader
	 */
	public DataInputStream getReader() {
		return reader;
	}
	/**
	 * @param reader the reader to set
	 */
	public void setReader(DataInputStream reader) {
		this.reader = reader;
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
	 * @return
	 */
	public String getAddress() {
		String address = null;
		try {
			address = ""+ InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return address;
	}

	/**
	 * @return
	 */
	public int getPort() {
		return this.getSocket().getPort();
	}
}
