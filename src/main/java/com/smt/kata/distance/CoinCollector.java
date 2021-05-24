package com.smt.kata.distance;

/****************************************************************************
 * <b>Title</b>: CoinCollector.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Coin Collector
 * 
 * You are given a 2-d matrix where each cell represents number of coins in that 
 * cell. Assuming we start at matrix[0][0], and can only move right or down, 
 * find the maximum number of coins you can collect by the bottom right corner.
 * 
 * For Example, in this matrix:
 * 0 3 1 1
 * 2 0 0 4
 * 1 5 3 1
 * 
 * The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 20, 2021
 * @updates:
 ****************************************************************************/
public class CoinCollector {

	/**
	 * Following various paths,calculate the most coins that can be retrieved
	 * @param matrix Matrix of coins
	 * @return Total number of coins collected
	 */
	public int collect(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		else return explore(0, 0, 0, matrix);
	}
	
	/**
	 * Recursive method to calculate all of the possible pathways
	 * @param x X Coordinate of the matrix
	 * @param y Y coordinate of the matrix
	 * @param collected Values for the pathway
	 * @param matrix Matrix to process against
	 * @return Greatest number of coins in the path
	 */
	private int explore(int x, int y, int collected, int[][] matrix) {
        
		// Check the boundaries
        if (x >= matrix.length || y >= matrix[x].length) return collected;
        
        // Increment the collected amount
        collected += matrix[x][y];
        
        // Recursively go down and right
        int checkDown= explore(x+1, y, collected, matrix);
        int checkRight= explore(x, y+1, collected, matrix);
        
        // Return whichever is greater
        return checkDown >= checkRight ?  checkDown :  checkRight;
    }
}
