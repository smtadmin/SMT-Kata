package com.smt.kata.distance;

/****************************************************************************
 * <b>Title:</b> QueenAttack.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Queen Attack Kata
 * 
 * Given the position of two queens on a chess board, indicate whether or not 
 * they are positioned so that they can attack each other. In the game of chess, 
 * a queen can attack pieces which are on the same row, column, or diagonal.  A 
 * chess board can be represented by an 8 by 8 array.  You must initialize the board to 
 * have the '-' character to simulate the board as shown below.
 * 
 * So if you're told the white queen is at (2, 3) and the black queen at (5, 6), 
 * then you'd know you've got a set-up like so:
 * 
 * _ _ _ _ _ _ _ _
 * _ _ _ _ _ _ _ _
 * _ _ _ W _ _ _ _
 * _ _ _ _ _ _ _ _
 * _ _ _ _ _ _ _ _
 * _ _ _ _ _ _ B _
 * _ _ _ _ _ _ _ _
 * _ _ _ _ _ _ _ _
 * 
 * You'd also be able to answer whether the queens can attack each other. In 
 * this case, that answer would be yes, they can, because both pieces share a diagonal.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 22, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class QueenAttack {
	
	// Members
	protected char[][] chessboard;

	/**
	 * Initialize the chess board
	 * @param chessboard 2d array that expresses the chess board
	 */
	public QueenAttack(char[][] chessboard) {
		super();
		
		this.chessboard = chessboard;
		this.initializeBoard();
	}

	/**
	 * Determines if the black and white queen can attach each other in any direction
	 * @param white coordinate for the white queen
	 * @param black coordinate for the black queen
	 * @return true if they can attack in any direction.  False otherwise
	 */
	public boolean canAttack(int[] white, int[] black) {
		this.initializeBoard();
		if (isBadInput(white) || isBadInput(black)) return false;
		
		chessboard[white[0]][white[1]] = 'W';
		chessboard[black[0]][black[1]] = 'B';
		
		return (testVertical(white, black) || testHorizontal(white, black) || testDiagonal(white, black));
	}
	
	/**
	 * Validates the array values for a queen
	 * @param data coordinate for a queen
	 * @return true if valid.  False otherwise
	 */
	protected boolean isBadInput(int[] data) {
		return (! (data != null && data.length == 2 ));
	}
	
	/**
	 * Determines if the queens can attack vertically
	 * @param white coordinate for the white queen
	 * @param black coordinate for the black queen
	 * @return true if they can attack vertically.  False otherwise
	 */
	protected boolean testVertical(int[] white, int[] black) {
		return (white[1] == black[1]);
	}
	
	/**
	 * Determines if the queens can attack horizontally
	 * @param white coordinate for the white queen
	 * @param black coordinate for the black queen
	 * @return true if they can attack horizontally.  False otherwise
	 */
	protected boolean testHorizontal(int[] white, int[] black) {
		return (white[0] == black[0]);
	}
	
	/**
	 * Determines if the queens can attack diagonally
	 * @param white coordinate for the white queen
	 * @param black coordinate for the black queen
	 * @return true if they can attack diagonally.  False otherwise
	 */
	protected boolean testDiagonal(int[] white, int[] black) {
		// check upper right
		boolean upperRight = moveDiagonal(white, black, new int[] {1, -1});
		
		// check upper left
		boolean upperLeft = moveDiagonal(white, black, new int[] {-1, -1});
		
		// check lower right
		boolean lowerRight = moveDiagonal(white, black, new int[] {1, 1});
		
		// check lower left
		boolean lowerLeft = moveDiagonal(white, black, new int[] {-1, 1});
		
		return upperRight || upperLeft || lowerRight || lowerLeft;
	}
	
	/**
	 * Traverses the grid in the direction of the provided array data
	 * @param white location of the white queen
	 * @param black location of the black queen
	 * @param direction the x/y direction to move (1,-1) etc ...
	 * @return true if coordinates match a location of the black queen.  False otherwise
	 */
	protected boolean moveDiagonal(int[] white, int[] black, int[] direction) {
		int x = white[0];
		int y = white[1];
		
		// Loop until you overflow the array in any direction
		while(true) {
			
			x += direction[0];
			y += direction[1];
			
			if (x < 0 || y < 0 || y >= chessboard.length || x >= chessboard[0].length) break;
			else if (x == black[0] && y == black[1]) return true;
		}
		
		return false;
	}
	
	/**
	 * Resets the board to all '-'
	 */
	private void initializeBoard() {
		for (int i=0; i < chessboard.length; i++) {
			for (int j = 0; j < chessboard[0].length; j++) {
				chessboard[i][j] = '-';
			}
		}
	}
}
