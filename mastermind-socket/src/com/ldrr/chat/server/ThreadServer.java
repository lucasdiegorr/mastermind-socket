package com.ldrr.chat.server;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 
 */

/**
 * @author Lucas Diego
 *
 */
public class ThreadServer implements Runnable {

	private Socket client;
	private DataInputStream reader;
	private ServerChat server;

	public ThreadServer(Socket client, ServerChat server) {
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

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		String fromClient = null;
		try {
			while (!this.client.isClosed() && ((fromClient = reader.readUTF()) != null)) {
				this.server.sendMessage(fromClient, this);
			}
		} catch (IOException e) {
			this.server.disconnect(this.client);
			this.server.sendMessage("O cliente desconectou do chat.", this);
			e.printStackTrace();
		}
	}

}
