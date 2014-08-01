/**
 * 
 */
package com.ldrr.graphic;


/**
 * @author Lucas Diego
 * 
 */
public class Sprite {

	private final static String[] colors = { "/red.png", "/green.png", "/orange.png", "/yellow.png","/blue.png", "/dark_blue.png", "/init_ball.png", "/secret_ball.png"};
	private final static String[] buttons = { "/Accept-icon.png" };
	private final static String[] evalueColors = { "/black.png","/white.png", "/blanck_ball.png" };
	private final static String[] responseColors = {"/Eval_Black.png", "/Eval_White.png", "/Eval_Blank.png"};

	public static String getColor(int index) {
		return colors[index];
	}

	public static String getIconButton(int index) {
		return buttons[index];
	}

	public static String getEvalueColors(int index) {
		return evalueColors[index];
	}
	
	public static String getResponseColors(int index) {
		return responseColors[index];
	}
}
