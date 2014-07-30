/**
 * 
 */
package com.ldrr.graphic;

import javax.swing.ImageIcon;

/**
 * @author Lucas Diego
 *
 */
public class Sprite {

	private final static String[] colors = {"sprites/red.png", "sprites/green.png", 
											"sprites/orange.png", "sprites/yellow.png", 
											"sprites/blue.png", "sprites/dark_blue.png", "sprites/blanck_ball.png", "sprites/secret_ball.png"};
	private final static String[] buttons = {"images/Accept-icon.png"};
	private final static String[] evalueColors = {"sprites/Eval_Black.png", "sprites/Eval_White.png"};
	
	public static ImageIcon getColor(int index) {
		return new ImageIcon(colors[index]);
	}
	
	public static ImageIcon getIconButton(int index) {
		return new ImageIcon(buttons[index]);
	}
	
	public static ImageIcon getEvalueColors(int index) {
		return new ImageIcon(evalueColors[index]);
	}
}
