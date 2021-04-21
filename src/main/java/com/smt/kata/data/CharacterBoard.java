package com.smt.kata.data;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title:</b> CharacterBoard.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Character Board
 * 
 * Given a 2D board of characters and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may be used more than once.
 * For example, given the following board:
 * 
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 
 * exists(board, "ABCCED") returns true, 
 * exists(board, "SEE") returns true, 
 * exists(board, "ABCB") returns true.
 * exists(board, "ACE") returns false.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 15, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class CharacterBoard {
	
	private char[][] board;
	
	/**
	 * Initializes the class with a 2d matrix
	 * @param board matrix of characters
	 */
	public CharacterBoard(char[][] board) {
		this.board = board;
	}

	/**
	 * Runs through the character board and finds the provided word
	 * @param word Word to search the board
	 * @return True if word is in the board, false otherwise
	 */
	public boolean exists(String word) {
		// If the word is empty, return false
		if (StringUtil.isEmpty(word)) return false;
		word = word.toUpperCase();
		
		// Get the locations of the first letter.  Return false if no matches
		List<int[]> coords = findStartCoords(word.charAt(0));
		if (coords.isEmpty()) return false;
		
		// Loop each coordinate and look for a match
		for(int[] coord : coords) {
			List<int[]> allCoords = Arrays.asList(coord);
			
			// Loop letter in the word in order for a match.  Break if no match
			for (int i=1; i < word.length(); i++) {
				List<int[]> matchingCoords = new ArrayList<>();
				
				for (int[] allCoord : allCoords) {
					matchingCoords.addAll(getCoordMatches(word.charAt(i), allCoord[0], allCoord[1]));
				}

				if (matchingCoords.isEmpty()) break;
				else allCoords = matchingCoords;
				
				// If all of the characters are checked and matched, return true
				if (i + 1 == word.length()) return true;
			}
		}

		return false;
	}
	
	/**
	 * Finds all of the coordinates of the first letter (starting locations)
	 * @param c First character in the word
	 * @return Key (row) and Value(col) for each character location
	 */
	private List<int[]> findStartCoords(char c) {
		List<int[]> coords = new ArrayList<>();
		
		for (int i=0; i < board.length; i++) {
			char[] row = board[i];
			
			for (int j=0; j < row.length; j++) {
				if (c == row[j]) {
					coords.add(new int[] {i, j} );
				}
			}
		}

		return coords;
	}
	
	/**
	 * Gets a list of coordinates that match the desired letter to be found
	 * @param c Character to match
	 * @param row Index of the row location
	 * @param col Index of the column location
	 * @return Collection of coordinates.  Empty if none found
	 */
	private List<int[]> getCoordMatches(char c, int row, int col) {
		List<int[]> matchingCoords = new ArrayList<>();
		int startRow = row-1 < 0 ? 0 : row-1;
		int endRow = row+1 >= board.length ? board.length - 1 : row+1;
		int startCol = col-1 < 0 ? 0 : col-1;
		int endCol = col+1 >= board[0].length ? board[0].length - 1 : col+1;

		// Loop the rows
		for (int i = startRow; i <= endRow; i++) {
			
			// Loop the columns
			for (int j = startCol; j <= endCol; j++) {
				
				// Compare to char we're looking for.  Exclude the center point
				if (board[i][j] == c && !(i == row && j == col)) 
					matchingCoords.add(new int[] {i,j});
			}
		}
		
		return matchingCoords;
	}
}
