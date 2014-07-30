/**
 * 
 */
package com.ldrr.client;

import java.io.Serializable;

/**
 * @author Lucas-DEAD
 *
 */
public class MessageGame implements Serializable {

	private int[] colorSequence = new int[4];
	private int[] colorResponse = new int[4];
	
	/**
	 * @return the colorSequence
	 */
	public int[] getColorSequence() {
		return colorSequence;
	}
	/**
	 * @param colorSequence the colorSequence to set
	 */
	public void setColorSequence(int[] colorSequence) {
		this.colorSequence = colorSequence;
	}
	/**
	 * @return the colorResponse
	 */
	public int[] getColorResponse() {
		return colorResponse;
	}
	/**
	 * @param colorResponse the colorResponse to set
	 */
	public void setColorResponse(int[] colorResponse) {
		this.colorResponse = colorResponse;
	}
	
	
	
}
