package com.smt.kata.distance;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: WordMatrix.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Word Matrix
 * Given a 2D matrix of characters and a target word, write a function that returns 
 * whether the word can be found in the matrix by going left-to-right, right to Left, 
 * up-to-down or down to up.
 * 
 * For example, given the following matrix:

 * [['F', 'A', 'C', 'I'],
 * ['O', 'B', 'Q', 'P'],
 * ['A', 'N', 'O', 'B'],
 * ['M', 'A', 'S', 'S']]
 * 
 * and the target word 'FOAM', you should return true, since it's the leftmost 
 * column. Similarly, given the target word 'MASS', you should return true, 
 * since it's the last row.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 10, 2021
 * @updates:
 ****************************************************************************/
public class WordMatrix {
	
	// Members
	private List<String> words = new ArrayList<>();
	private char[][] matrix = new char[][] {
		{ 'F', 'A', 'C', 'I' },
		{ 'O', 'B', 'Q', 'P' },
		{ 'A', 'N', 'O', 'B' },
		{ 'M', 'A', 'S', 'S' }
	};

	/**
	 * 
	 */
	public WordMatrix() {
		super();
		assignVerticalWords();
		assignHorizontalWords();
	}

	/**
	 * Determines if the provided phrase is in the matrix
	 * either horizontally or vertically
	 * @return
	 */
	public boolean contains(String phrase) {
		if (StringUtil.isEmpty(phrase)) return false;
		
		for (String word : words) {
			String reverse = new StringBuilder(word).reverse().toString();
			
			if (word.contains(phrase.toUpperCase())) return true;
			if (reverse.contains(phrase.toUpperCase())) return true;
		}
		
		return false;
	}
	
	/**
	 * Grabs the vertical words form the system
	 */
	private void assignVerticalWords() {
		StringBuilder word = null;
		
		for (int i=0; i < matrix.length; i++) {
			word = new StringBuilder();
			for (int j = 0; j < matrix.length; j++) {
				word.append(matrix[j][i]);
			}
			
			words.add(word.toString());
		}
	}
	
	/**
	 * Adds the horizontal words to the list
	 */
	private void assignHorizontalWords() {
		for (int i=0; i < matrix.length; i++) {
			words.add(new String(matrix[i]));
		}
	}
	
}
