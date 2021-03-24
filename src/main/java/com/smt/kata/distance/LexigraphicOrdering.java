package com.smt.kata.distance;

// JDK 11.x
import java.util.HashSet;
import java.util.Set;

/****************************************************************************
 * <b>Title:</b> LexigraphicOrdering.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Lexigraphic Ordering
 * 
 * You are given an N by M 2D matrix of lowercase letters. Determine the minimum 
 * number of columns that can be removed to ensure that each row is ordered from 
 * top to bottom lexicographically. That is, the letter at each column is 
 * lexicographically later as you go down each row. It does not matter whether 
 * each row itself is ordered lexicographically.
 * 
 * For example, given the following table:
 * 
 * cba
 * daf
 * ghi
 * 
 * This is not ordered because of the a in the center. We can remove the second 
 * column to make it ordered:
 * 
 * ca
 * df
 * gi
 * 
 * So your function should return 1, since we only needed to remove 1 column.
 * As another example, given the following table:
 * 
 * abcdef
 * 
 * Your function should return 0, since the rows are already ordered (there's only one row).
 * As another example, given the following table:
 * 
 * zyx
 * wvu
 * tsr
 * 
 * Your function should return 3, since we would need to remove all the columns to order it.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class LexigraphicOrdering {

	/**
	 * Reorders the columns based upon lexigraphic order
	 * @param data matrix data to process
	 * @return matrix of data that is properly ordered
	 */
	public char[][] orderData(char[][] data) {
		if (data == null || data.length == 0) return new char[0][];
		
		Set<Integer> removeColumns = new HashSet<>();
		
		for (int i = 0; i < data.length; i++) {
			char prev = '0';
			for (int x = 0; x < data.length; x++) {
				if (x > 0 && data[x][i] < prev) {
					removeColumns.add(i);
				}
				
				prev = data[x][i];
			}
		}
		
		return removeColumns(data, removeColumns);
	}
	
	/**
	 * Remove the columns from the original data source
	 * @param data Original data to process
	 * @param removeColumns columns to remove from the original matrix
	 * @return Lexigraphically ordered matrix
	 */
	private char[][] removeColumns(char[][] data, Set<Integer> removeColumns) {
		if (removeColumns.isEmpty()) return data;
		else if (removeColumns.size() == data[0].length) return new char[0][];
		
		char[][] cols = new char[data.length][];
		for (int i = 0; i < data.length; i++) {
			StringBuilder row = new StringBuilder();
			for (int x = 0; x < data.length; x++) {
				if (! removeColumns.contains(x))
					row.append(data[i][x]);
			}
			
			cols[i] = row.toString().toCharArray();
		}
		
		return cols;
	}

}
