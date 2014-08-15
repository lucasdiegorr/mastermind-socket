package com.ldrr.client.custom;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.codec.binary.Base64;

import com.ldrr.client.ClientController;
import com.ldrr.client.generic.Client;
import com.ldrr.server.generic.MessageChat;

/**
 * 
 */

/**
 * @author Lucas Diego
 * 
 */
public class ClientChat extends Client implements Runnable {

	private String clientName;
	private int emoticon;

	// CONSTRUCTORS
	public ClientChat(ClientController controller) {
		super("127.0.0.1", 5000, controller);
		this.setEmoticon(0);
	}

	public ClientChat(String address, int port, ClientController controller) {
		super(address, port, controller);
		this.setEmoticon(0);
	}

	public ClientChat(String address, int port, ClientController controller,String clientName) {
		super(address, port, controller);
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

	/**
	 * Treatment makes the messages received by the server
	 * Faz o tratamento as mensagens recebidas pelo servidor
	 * @param messageFromServer - message received by the server 
	 * - mensagem recebida pelo servidor
	 */
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

	/**
	 * Send a message to the server
	 * Envia uma mensagem ao servidor
	 * @param stringMessage - message to be sent - mensagem a ser enviada
	 */
	public void sendMessageChat(String stringMessage) {
		MessageChat message = new MessageChat(this.getClientName(), this.getEmoticon(), stringMessage);
		ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
		
		try {
			new ObjectOutputStream(byteArrayOutput).writeObject(message);
			sendMessage(Base64.encodeBase64String(byteArrayOutput.toByteArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param emoticon the emoticon to set
	 */
	public void setEmoticon(int emoticon) {
		this.emoticon = emoticon;
	}

	/**
	 * @return the emoticon
	 */
	public int getEmoticon() {
		return emoticon;
	}
}
