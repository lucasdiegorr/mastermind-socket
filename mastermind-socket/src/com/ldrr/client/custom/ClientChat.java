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
}
