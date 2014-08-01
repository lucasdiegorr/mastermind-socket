package com.ldrr.client;
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
	
	public void initGame(String address, int port) {
		this.clientGame = new ClientGame(address,port,this);
		new Thread(clientGame).start();
	}

	public void sendMessageChat(String message) {
		this.clientChat.sendMessage(message);
	}

	public void sendSequenceColors(int[] sequence) {
		this.clientGame.sendSequence(sequence);
	}
	
	public void receivedMessageChat(String message) {
		this.gameFrame.setMessageToTextAreaChat(message);
	}

	public void receivedSequenceGame(int[] colorResponse) {
		this.gameFrame.setSequenceToGameView(colorResponse);
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

	public void Alert(boolean b) {
		this.gameFrame.Alert(b);
	}

	public void sendAlert(boolean b) {
		if (b) {
			this.clientGame.sendMessage("DISCONNECTED");
		}else {
			this.clientGame.sendMessage("RESETGAME");
		}
	}


}
