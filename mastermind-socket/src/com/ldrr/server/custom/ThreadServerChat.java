package com.ldrr.server.custom;

import java.io.IOException;
import java.net.Socket;

import com.ldrr.server.generic.ThreadServer;

/**
 * All source code and required libraries are found at the following link:
 * https://github.com/lucasdiegorr/mastermind-socket 
 * branch: beta
 */

/**
 * @author Lucas Diego
 * 
 */
public class ThreadServerChat extends ThreadServer implements Runnable {

	private ServerChat server;

	public ThreadServerChat(Socket client, ServerChat server) {
		super(client);
		this.setServer(server);
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
			while (!this.getClient().isClosed()
					&& ((fromClient = getReader().readUTF()) != null)) {
				this.getServer().sendMessageChat(fromClient, this);
			}
		} catch (IOException e) {
			this.getServer().disconnect(this.getClient());
			this.getServer().sendAlertDisconnect(this);
		}
	}

	/**
	 * @return the server
	 */
	private ServerChat getServer() {
		return server;
	}

	/**
	 * @param server the server to set
	 */
	private void setServer(ServerChat server) {
		this.server = server;
	}

}
