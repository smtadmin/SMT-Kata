package com.smt.kata.distance;

/****************************************************************************
 * <b>Title</b>: PixelSwap.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Pixel Swap Kata
 * 
 * Given a 2-D matrix representing an image, a location of a pixel in the screen 
 * and a color C, replace the color of the given pixel and all adjacent same 
 * colored pixels with C.
 * 
 * For example, given the following matrix, and location pixel of (2, 2), and 'G' for green:
 * 
 * B B W
 * W W W
 * W W W
 * B B B
 * 
 * Becomes
 * 
 * B B G
 * G G G
 * G G G
 * B B B
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 28, 2021
 * @updates:
 ****************************************************************************/
public class PixelSwap {

	private char newColor;
	private char origColor;
	
	/**
	 * Swaps the pixels at the given coords and contiguous coords with the same original color
	 * @param pixels Matrix of pixels
	 * @param coords Starting coords
	 * @param color New color in those 0ixels
	 * @return Updated pixel map
	 */
	public char[][] swap(char[][] pixels, int[] coords, char color) {
		if (pixels == null || pixels[0] == null || coords == null) return new char[0][0];
		if (coords[0] < 0 || coords[0] > pixels.length) return new char[0][0];
		if (coords[1] < 0 || coords[0] > pixels[0].length) return new char[0][0];
		
		// Assign the colors to members
		this.newColor = color;
		this.origColor = pixels[coords[0]][coords[1]];
		
		// Recurse and then return the updated pixels
		this.recurse(pixels, coords);
		return pixels;
	}
	
	/**
	 * Recursively updates the pixels
	 * @param pixels Original pixel map
	 * @param coords the coordinates to be updated
	 */
	private void recurse(char[][] pixels, int[] coords) {
		if (pixels[coords[0]][coords[1]] == origColor) pixels[coords[0]][coords[1]] = newColor;
		else return;
		
		// Check vertical to make sure it works
		if (coords[0] + 1 < pixels.length) recurse(pixels, new int[] {coords[0] + 1, coords[1]});
		if (coords[0] - 1 >= 0) recurse(pixels, new int[] {coords[0] - 1, coords[1]});
		
		// Check horizontal to make sure it works
		if (coords[1] + 1 < pixels[1].length) recurse(pixels, new int[] {coords[0], coords[1] + 1});
		if (coords[1] - 1 >= 0) recurse(pixels, new int[] {coords[0], coords[1] - 1 });
	}

}
