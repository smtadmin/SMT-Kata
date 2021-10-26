package com.smt.kata.number;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/****************************************************************************
 * <b>Title</b>: ValidSudoku.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Valid Sudoku
 * 
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * 
 * - Each row must contain the digits 1-9 without repetition.
 * - Each column must contain the digits 1-9 without repetition.
 * - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * 
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * 
 * Example 1
 * https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png
 * Input: board = 
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * 
 * Example 2:
 * Input: board = 
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being 
 * modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * 
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 24, 2021
 * @updates:
 ****************************************************************************/
public class ValidSudoku {
	/**
	 * Array of starting coordinates for each of the 9 sub-boards
	 */
	private int[][] coords = new int[][] {
		{0,0},{0,3},{0,6},
		{3,0},{3,3},{3,6},
		{6,0},{6,3},{6,6}
	};
	
	/**
	 * Determines if the values in the Sudoku board are valid
	 * @param board Sudoku board to evaluate
	 * @return True if the values are valid.  False otherwise
	 */
	public boolean isValid(String[][] board) {
		// Validate the board data
		if (board == null || board.length != 9 || board[0].length != 9) return false;
		
		// Run all the checks and return
		return validateColumns(board) && validateRows(board) && validateSubBoards(board);
	}
	
	/**
	 * Checks the numbers in the list and validates that they are unique
	 * @param data List of numbers to check
	 * @return True if they are unique, false otherwise
	 */
	private boolean evaluateNumbers(List<Integer> data) {
		
		// Get the total list count and the distinct list count
		long distinctCount = data.stream().distinct().count();
		long allCount = data.stream().filter(item -> item > 0).count();
		return (distinctCount == allCount);
	}
	
	/**
	 * Loops through all of the columns on board and makes sure they are all unique
	 * @param board Sudoku board
	 * @return true if the values in each column are unique
	 */
	protected boolean validateColumns(String[][] board) {
		
		for (int i = 0; i < board[0].length; i++) {
			final int loc = i;
			List<Integer> columns = Arrays.stream(board).map(x -> x[loc]).map(j -> {
				if (".".equals(j)) return 0;
				return Integer.valueOf(j);
			}).filter(j -> j > 0).collect(Collectors.toList());
			
			// Check the numbers
			if (!evaluateNumbers(columns)) return false;
		}
		
		return true;
	}
	
	/**
	 * Loops through all of the rows on board and makes sure they are all unique
	 * @param board Sudoku board
	 * @return true if the values in each row are unique
	 */
	protected boolean validateRows(String[][] board) {
		for (String[] row : board) {
			// Convert the string[] to a collection of ints.  Ignore "."
			List<Integer> intRow = Arrays.stream(row).map(i -> {
				if (".".equals(i)) return 0;
				return Integer.valueOf(i);
			}).filter(i -> i > 0).collect(Collectors.toList());
			
			// Check the numbers
			if (!evaluateNumbers(intRow)) return false;
		}
		
		// All rows passed, return true
		return true;
	}
	
	/**
	 * Validates the entries in each sub-board
	 * @param board Full Sudoku board
	 * @return True if all subBoards are valid
	 */
	protected boolean validateSubBoards(String[][] board) {
		// Loops the coordinates for each sub-board
		for (int[] coord : coords) {
			// Get a collection of items in the sub-board and check the numbers
			if (!evaluateNumbers(splitBoard(board, coord[0], coord[1]))) return false;
		}
		
		return true;
	}
	
	/**
	 * Splits the board into a 3x3 sub board using the given coordinates and converts the 
	 * values in the sub-board as a list
	 * @param board Fill Sudoku board
	 * @param row Starting row
	 * @param col Starting column
	 * @return Values in the sub-board with empty locations removed
	 */
	protected List<Integer> splitBoard(String[][] board, int row, int col) {
		// Create a sub-board to hold the values
		List<Integer> subBoards = new ArrayList<>();
		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col+3; j++) {
				if (! ".".equals( board[i][j])) subBoards.add(Integer.valueOf( board[i][j]));
			}

		}

		return subBoards;
	}
}
