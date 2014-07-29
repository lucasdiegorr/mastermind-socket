package com.ldrr.chat.client;
import java.awt.Color;
import java.io.IOException;

import com.ldrr.graphic.GameFrame;

/**
 * 
 */

/**
 * @author Lucas Diego
 *
 */
public class ClientController {

	private ClientChat clientChat;
	private GameFrame chatFrame;
	
	public ClientController(GameFrame chatFrame) {
		this.clientChat = new ClientChat(this);
		new Thread(clientChat).start();
		this.chatFrame = chatFrame;
	}
	
	public void sendMessageToServer(String message) {
		this.clientChat.sendMessage(message);
	}

	public void sendMessageToView(String message) {
		this.chatFrame.getTextAreaChat().setSelectedTextColor(Color.RED);
		this.chatFrame.getTextAreaChat().append(message + "\n");
	}
	
	public void setNickName(String nickName) {
		this.clientChat.setClientName(nickName);
	}

	public void disconnect() {
		try {
			this.clientChat.getReader().close();
			this.clientChat.getWriter().close();
			this.clientChat.getSocket().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
