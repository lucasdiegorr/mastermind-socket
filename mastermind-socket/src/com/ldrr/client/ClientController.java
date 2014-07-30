package com.ldrr.client;
import java.io.IOException;

import com.ldrr.graphic.GameFrame;
import com.ldrr.graphic.Sprite;

/**
 * 
 */

/**
 * @author Lucas Diego
 *
 */
public class ClientController {

	private ClientChat clientChat;
	private ClientGame clientGame;
	private GameFrame gameFrame;
	
	public ClientController(GameFrame chatFrame) {
		this.gameFrame = chatFrame;
	}
	
	public void initChat() {
		this.clientChat = new ClientChat(this);
		new Thread(clientChat).start();
	}
	
	public void initGame() {
		this.clientGame = new ClientGame(this);
		new Thread(clientGame).start();
	}
	
	public void sendMessageToServerChat(String message) {
		this.clientChat.sendMessage(message);
	}

	public void sendMessageToViewChat(String message) {
		this.gameFrame.getTextAreaChat().append(message + "\n");
	}
	
	public void setNickName(String nickName) {
		this.clientChat.setClientName(nickName);
	}

	public void disconnectFromChat() {
		try {
			this.clientChat.getReader().close();
			this.clientChat.getWriter().close();
			this.clientChat.getSocket().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnectFromGame() {
		try {
			this.clientGame.getReader().close();
			this.clientGame.getWriter().close();
			this.clientGame.getSocket().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendSequenceToViewGame(int[] colorResponse) {
		for (int i = 0; i < colorResponse.length; i++) {
			this.gameFrame.getArrayLabels()[this.gameFrame.getIndex_row()][i].setIcon(Sprite.getColor(colorResponse[i]));
		}
	}
}
