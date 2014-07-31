/**
 * 
 */
package com.ldrr.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import com.ldrr.client.MessageGame;

/**
 * @author Lucas
 *
 */
public class ThreadServerGame implements Runnable {

	private Socket client;
	private ObjectInputStream reader;
	private ServerGame server;

	public ThreadServerGame(Socket client, ServerGame server) {
		this.client = client;
		this.server = server;
		try {
			this.reader = new ObjectInputStream(this.client.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Socket getClient() {
		return client;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		MessageGame fromClient = null;
		try {
			while (!this.client.isClosed() && ((fromClient = (MessageGame) reader.readObject()) != null)) {
				this.server.sendMessage(fromClient, this);
			}
		} catch (Exception e) {
			this.server.disconnect(this.client);
			e.printStackTrace();
		}
	}
}
