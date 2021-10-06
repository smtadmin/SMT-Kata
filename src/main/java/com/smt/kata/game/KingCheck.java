package com.smt.kata.game;

// Kata libs
import com.smt.kata.distance.bean.CoordinateVO;

/****************************************************************************
 * <b>Title</b>: KingCheck.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> King Check
 * 
 * You are presented with an 8 by 8 matrix representing the positions of pieces 
 * on a chess board. The only pieces on the board are the black king and various 
 * white pieces. Given this matrix, determine whether the king is in check.
 * 
 * For details on how each piece moves, see here.
 * 
 * For example, given the following matrix:
 * 
 * { 'O','O','O','K','O','O','O','O' },
 * { 'O','O','O','O','O','O','O','O' },
 * { 'O','B','O','O','O','O','O','O' },
 * { 'O','O','O','O','O','O','P','O' },
 * { 'O','O','O','O','O','O','O','R' },
 * { 'O','O','N','O','O','O','O','O' },
 * { 'O','O','O','O','O','O','O','O' },
 * { 'O','O','O','O','O','Q','O','O' }
 * 
 * You should return True, since the bishop is attacking the king diagonally.
 * 
 * 'K' = King
 * 'Q' = Queen
 * 'P' = Pawn
 * 'B' = Bishop
 * 'R' = Rook
 * 'N' = Knight
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 6, 2021
 * @updates:
 ****************************************************************************/
public class KingCheck {
	char[][] board;
	
	/**
	 * Assigns the chess board to the class
	 * @param board Chess board
	 */
	public KingCheck(char[][] board) {
		this.board = board;
	}

	/**
	 * 
	 * @param board
	 * @return
	 */
	public boolean isKingCheck() {
		// Make sure the board is properly defined
		if (board == null || board.length != 8 || board[0] == null || board[0].length != 8) return false;
		
		// Get the kings location
		CoordinateVO king = locateKing();
		
		// Check all of the pieces for check
		return king != null && (
			checkPawns(king) ||
			checkBishops() || 
			checkRooks() || 
			checkKnights() || 
			checkQueen()
		);
	}
	
	/**
	 * Gets the coordinates for the kings location
	 * @return Coordinate of the king.  Null if not found
	 */
	protected CoordinateVO locateKing() {
		
		for (int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				if (board[row][col] == 'K') return new CoordinateVO(row, col);
			}
		}
		
		return null;
	}

	/**
	 * Finds each pawn on the board and determines if the pawn has the king in check
	 * @param king Location of the king
	 * @return true if a pawn has the king in check
	 */
	protected boolean checkPawns(CoordinateVO king) {
		
		for (int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				if(board[row][col] == 'P' &&
					(row >= king.getRow() - 1) && 
					(row <= king.getRow() + 1) &&
					(col >= king.getColumn() - 1) &&
					(col <= king.getColumn() + 1)
				) return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Determines if a bishop has the king in check
	 * @return True if king is in check form the bishop.  False otherwise
	 */
	protected boolean checkBishops() {
		
		for (int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				if (board[row][col] == 'B' && checkDiagonal(new CoordinateVO(row, col)))
					return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Wrapper to check all 4 directions from the given point
	 * @param piece Chess piece to navigate diagonally
	 * @return True of in check diagonally.  False otherwise
	 */
	public boolean checkDiagonal(CoordinateVO piece) {
		return checkDiagonal(piece, 1, -1) ||
			   checkDiagonal(piece, -1, -1) ||
			   checkDiagonal(piece, 1, 1) ||
			   checkDiagonal(piece, -1, 1);
	}
	
	/**
	 * Moves diagonally across the board in the provided direction
	 * @param piece Location of the bishop
	 * @param row Amount to increment/decrement the row (value is 1 or -1)
	 * @param col Amount to increment/decrement the col (value is 1 or -1)
	 * @return True if it can put the king in check
	 */
	private boolean checkDiagonal(CoordinateVO piece, int row, int col) {
		int curRow = piece.getRow() + row;
		int curCol = piece.getColumn() + col;
		
		while(curRow >= 0 && curRow < board.length - 1 && curCol >= 0 && curCol < board[0].length - 1) {
			if (board[curRow][curCol] == 'K') return true;
			else if (board[curRow][curCol] != 'O') return false;
			
			curRow += row;
			curCol += col;
		}
		
		return false;
	}
	
	/**
	 * Determines if the rook can put the king in check
	 * @param king Location of the king
	 * @return
	 */
	protected boolean checkRooks() {
		
		for (int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				if (board[row][col] == 'R' && (
					checkHorizontal(new CoordinateVO(row, col)) ||
					checkVertical(new CoordinateVO(row, col)))
				) return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Checks if a vertical movement results in a check condition
	 * @param piece Location of the piece
	 * @return True if in check.  False otherwise
	 */
	public boolean checkVertical(CoordinateVO piece) {
		boolean blocked = false;
		// Check to the top
		for (int row = piece.getRow(); row < board.length; row++) {
			char val = board[row][piece.getColumn()];
			if (! blocked && val == 'K') return true;
			else if (blocked && val == 'K') return false;
			else if (val != 'O') blocked = true;
		}
		
		// Check to the bottom
		for(int row = piece.getRow() - 1; row >= 0; row--) {
			char val = board[row][piece.getColumn()];
			if (val == 'K') return true;
			else if (val != 'O') return false;
		}
		
		return false;
	}
	
	/**
	 * Checks if a horizontal movement results in a check condition
	 * @param piece Location of the piece
	 * @return True if in check.  False otherwise
	 */
	public boolean checkHorizontal(CoordinateVO piece) {
		boolean blocked = false;
		// Check to the right
		for (int col = piece.getColumn(); col < board[0].length; col++) {
			char val = board[piece.getRow()][col];
			if (! blocked && val == 'K') return true;
			else if (blocked && val == 'K') return false;
			else if (val != 'O') blocked = true;
		}
		
		// Check to the left
		for(int col = piece.getColumn() - 1; col >= 0; col--) {
			char val = board[piece.getRow()][col];
			if (val == 'K') return true;
			else if (val != 'O') return false;
		}
		
		return false;
	}
	
	/**
	 * Knights can move into 8 positions (if on the board).  This method checks all 8
	 * @param board Chess board
	 * @param knight Location of the knight on the board
	 * @return True of king is in check by a knight.  False otherwise
	 */
	protected boolean checkKnights() {
		for (int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				CoordinateVO knight = new CoordinateVO(row, col);
				if (board[row][col] == 'N' && (
					onBoard(knight.getRow() -2, knight.getColumn() + 1) ||
					onBoard(knight.getRow() -1, knight.getColumn() + 2) ||
					onBoard(knight.getRow() +1, knight.getColumn() + 2) ||
					onBoard(knight.getRow() +2, knight.getColumn() + 1) ||
					onBoard(knight.getRow() +2, knight.getColumn() - 1) ||
					onBoard(knight.getRow() +1, knight.getColumn() - 2) ||
					onBoard(knight.getRow() -1, knight.getColumn() - 2) ||
					onBoard(knight.getRow() -2, knight.getColumn() - 1))
				) return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Determines if the coordinates are on the board
	 * @param board Chess board
	 * @param row Row for the location
	 * @param col Column for the location
	 * @return True if the coordinates are on the board.  False otherwise
	 */
	private boolean onBoard(int row, int col) {
		return (row >=0 && row < board.length && col >= 0 && col < board[0].length) &&
				board[row][col] == 'K';
	}
	
	/**
	 * 
	 * @param board
	 * @param king
	 * @return
	 */
	protected boolean checkQueen() {
		for (int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				if (board[row][col] == 'Q' && (
					checkHorizontal(new CoordinateVO(row, col)) ||
					checkVertical(new CoordinateVO(row, col)) ||
					checkDiagonal(new CoordinateVO(row, col)))
				) return true;
			}
		}
		
		return false;
	}
}
