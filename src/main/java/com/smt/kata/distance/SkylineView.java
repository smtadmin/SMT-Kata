package com.smt.kata.distance;

/****************************************************************************
 * <b>Title</b>: SkylineView.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Skyline View Kata
 * 
 * You are given an array representing the heights of neighboring buildings on 
 * a city street, from east to west. The city assessor would like you to write 
 * an algorithm that returns how many of these buildings have a view of the 
 * setting sun, in order to properly value the street.
 * 
 * For example, given the array [3, 7, 8, 3, 6, 1], you should return 3, since 
 * the top floors of the buildings with heights 8, 6, and 1 all have an unobstructed 
 * view to the west.
 * 
 * -----------------------------------------------------------------------------
 * Can you do this using just one backwards pass through the array?
 * Can you do this using just one forward pass through the array?
 * -----------------------------------------------------------------------------
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 21, 2021
 * @updates:
 ****************************************************************************/
public class SkylineView {

	/**
	 * Gets the number of views working from the back of the array to forward
	 * @param buildings Array of building heights
	 * @return Number of buildings with a view
	 */
	public int getNumViewsBackwards(int[] buildings) {
		if (buildings == null || buildings.length == 0) return 0;
		else if (buildings.length == 1) return 1;
		
		int highestPoint = 0;
		int numViews = 0;
		for (int i = buildings.length - 1; i >= 0; i--) {
			int height = buildings[i];
			if (height > highestPoint) {
				numViews++;
				highestPoint = height;
			}
		}
		
		return numViews;
	}
	
	/**
	 * Gets the number of views working from the front of the array to the back
	 * @param buildings Array of building heights
	 * @return Number of buildings with a view
	 */
	public int getNumViewsForward(int[] buildings) {
		if (buildings == null || buildings.length == 0) return 0;
		else if (buildings.length == 1) return 1;
		
		int highestPoint = 0;
		int prev = 0;
		int numViews = 1;
		for (int height : buildings) {
			if (height >= highestPoint) {
				numViews = 1;
				highestPoint = height;
			} else if (height < prev) {
				numViews++;
			}
			
			prev = height;
		}
		
		return numViews;
	}

}
