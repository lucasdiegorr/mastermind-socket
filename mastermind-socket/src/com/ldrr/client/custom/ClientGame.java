package com.ldrr.client.custom;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.codec.binary.Base64;

import com.ldrr.client.ClientController;
import com.ldrr.client.generic.Client;
import com.ldrr.server.generic.Commands;

/**
 * 
 */

/**
 * @author Lucas Diego
 * 
 */
public class ClientGame extends Client implements Runnable {

	// CONSTRUCTORS
	public ClientGame(ClientController controller) {
		super("127.0.0.1", 6000, controller);
	}

	public ClientGame(String address, int port, ClientController controller) {
		super(address, port, controller);
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
					this.getController().receivedSequenceGame(convertToIntArray(messageFromServer));
				}
			}
		} catch (IOException e) {
			disconnect();
			this.getController().Alert(Commands.DISCONNECT);
			e.printStackTrace();
		}
	}


	public void sendSequence(int[] sequence) {
		String stringSequence = convertToString(sequence);
		sendMessage(stringSequence);
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

}
