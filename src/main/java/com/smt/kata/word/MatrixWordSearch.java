package com.smt.kata.word;

// JDK 11.x
import java.util.HashSet;
import java.util.Set;

// Kata Libs
import com.siliconmtn.data.text.StringUtil;
import com.smt.kata.distance.bean.CoordinateVO;

/****************************************************************************
 * <b>Title</b>: MatrixWordSearch.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Word Search
 * 
 * Given an m x n grid of characters board and a string word, return true if word 
 * exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells, 
 * where adjacent cells are horizontally or vertically neighboring. The same letter 
 * cell may not be used more than once.
 * 
 * Example 1:
 * https://assets.leetcode.com/uploads/2020/11/04/word2.jpg
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * 
 * Example 2:
 * https://assets.leetcode.com/uploads/2020/11/04/word-1.jpg
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * 
 * Example 3:
 * https://assets.leetcode.com/uploads/2020/10/15/word3.jpg
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 * 
 * Constraints:
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board and word consists of only lowercase and uppercase English letters.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 28, 2021
 * @updates:
 ****************************************************************************/
public class MatrixWordSearch {

	// Members
	private Set<CoordinateVO> visited;
	boolean success = false;
	
	/**
	 * Finds the word on the board with sequential boxes on the board
	 * @param board Word board to search
	 * @param word Word to find on the board
	 * @return True if found.  False otherwise
	 */
	public boolean find(String[][] board, String word) {
		if (board == null || StringUtil.isEmpty(word)) return false;
		
		visited = new HashSet<>();
		success = false;
		
		char first = word.charAt(0);
		for (int x = 0; x < board.length; x++) {
			for(int y = 0; y < board[0].length; y++) {
				if (board[x][y].charAt(0) == first) {
					char[] newWord = new char[word.length()];
					recurse(board, new CoordinateVO(x,y), word, 0, newWord);
					if(success) return true;
				}
			}
		}
		
		return success;
	}

	/**
	 * Searches for matches on all cells surrounding the given index
	 * @param board Board to search
	 * @param cell current coordinates
	 * @param word Word to find
	 * @param index Index of the letter in the word
	 * @param newWord Array of chars being built by the recursion
	 */
	private void recurse(String[][] board, CoordinateVO cell, String word, int index, char[] newWord) {
		if (success) return;
		
		// get the current letter and add it to the newWord array
		char letter = board[cell.getRow()][cell.getColumn()].charAt(0);
		newWord[index] = letter;
		
		// Get the partial word (using the index and the partial new word
		String newWordStr = new String(newWord, 0, index + 1);
		String partialWord = word.substring(0, index+1);
		
		// Look for matches or failures
		if (visited.contains(cell) || !partialWord.equals(newWordStr)) return;
		else if (word.equals(newWordStr)) {
			success = true;
			return;
		}
		
		// Add the cell to the visited set and increment the index
		visited.add(cell);
		index++;
		
		// If possible, recurse on each of the 4 characters around the current cell
		if((cell.getRow() + 1) < board.length)
			recurse(board, new CoordinateVO(cell.getRow() + 1, cell.getColumn()), word, index, newWord);
		
		if((cell.getRow() - 1) >= 0)
			recurse(board, new CoordinateVO(cell.getRow() - 1, cell.getColumn()), word, index, newWord);
		
		if((cell.getColumn() + 1) < board[0].length)
			recurse(board, new CoordinateVO(cell.getRow(), cell.getColumn() + 1), word, index, newWord);
		
		if((cell.getColumn() - 1) >= 0)
			recurse(board, new CoordinateVO(cell.getRow(), cell.getColumn() - 1), word, index, newWord);

	}
}
