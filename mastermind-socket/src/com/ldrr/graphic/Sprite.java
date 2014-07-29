/**
 * 
 */
package com.ldrr.graphic;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * @author Lucas Diego
 *
 */
public class Sprite {

	private final static String[] colors = {"sprites/red.png", "sprites/green.png", 
											"sprites/orange.png", "sprites/yellow.png", 
											"sprites/blue.png", "sprites/dark_blue.png"};
	private final static String[] buttons = {"images/Accept-icon.png"};
	public static ImageIcon getColor(int index) {
		return new ImageIcon(colors[index]);
	}
	
	public static ImageIcon getIconButton(int index) {
		return new ImageIcon(buttons[index]);
	}
}
