package com.ldrr.chat.client;
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
	
	public void sendMessage(String message) {
		this.clientChat.sendMessage(message);
	}

	public void receivedMessage(String message) {
		this.chatFrame.getTextAreaChat().append(message + "\n");
	}
}
