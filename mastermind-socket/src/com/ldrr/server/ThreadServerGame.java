/**
 * 
 */
package com.ldrr.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author Lucas Diego
 * 
 */
public class ThreadServerGame implements Runnable {

	private Socket client;
	private DataInputStream reader;
	private ServerGame server;

	public ThreadServerGame(Socket client, ServerGame server) {
		this.client = client;
		this.server = server;
		try {
			this.reader = new DataInputStream(this.client.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Socket getClient() {
		return client;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String fromClient = null;
		try {
			while (!this.client.isClosed()
					&& ((fromClient = reader.readUTF()) != null)) {
				System.out.println(fromClient);
				this.server.sendMessage(fromClient, this);
			}
		} catch (Exception e) {
			this.server.disconnect(this.client);
			this.server.sendAlert();
			e.printStackTrace();
		}
	}
}
