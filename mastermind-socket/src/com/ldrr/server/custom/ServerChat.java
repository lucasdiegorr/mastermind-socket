package com.ldrr.server.custom;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.commons.codec.binary.Base64;

import com.ldrr.server.generic.MessageChat;
import com.ldrr.server.generic.Server;

/**
 * All source code and required libraries are found at the following link:
 * https://github.com/lucasdiegorr/mastermind-socket 
 * branch: beta
 */

/**
 * @author Lucas Diego
 * 
 */
public class ServerChat extends Server implements Runnable {

	public ServerChat() {
		super(5000);
	}

	public ServerChat(int port) {
		super(port);
	}

	/**
	 * Send a message to all registered except the server to the client that sent
	 * the message to server customers
	 * Envia uma mensagem a todos os clientes cadastrados no servidor exceto ao 
	 * cliente que enviou a mensagem ao servidor
	 * @param message - message to be sent - mensagem a ser enviada
	 * @param thread - Thread responsible for the clientChat that sent the message 
	 * - Thread responsavel pelo clienteChat que enviou a mensagem
	 */
	public void sendMessageChat(String message, ThreadServerChat thread) {
		sendMessage(message, thread.getClient());
	}


	@Override
	public void run() {
		while (true) {
			while (this.getListClient().size() < 2) {
				Socket client;
				try {
					client = this.getServer().accept();
					getListClient().add(client);
					new Thread(new ThreadServerChat(client, this)).start();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Send a message to disconnect a client from the server Chat
	 * Envia uma mensagem informando a desconexão de um client do servidor de Chat
	 * @param threadServerChat - Thread responsible for the clientChat
	 */
	public void sendAlertDisconnect(ThreadServerChat threadServerChat) {
		MessageChat message = new MessageChat(null, 8, "O outro usuário saiu do chat\n");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			new ObjectOutputStream(baos).writeObject(message);
			sendAlert(Base64.encodeBase64String(baos.toByteArray()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
