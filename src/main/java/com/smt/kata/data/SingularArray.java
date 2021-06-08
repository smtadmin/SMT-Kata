package com.smt.kata.data;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: SingularArray.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Singular Array
 * Given an array of integers in which two elements appear exactly once and all 
 * other elements appear exactly twice, find the two elements that appear only once.
 * For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 27, 2021
 * @updates:
 ****************************************************************************/
public class SingularArray {

	/**
	 * Finds all of the unmatched elements in the array
	 * @param values Array of numbers ot evaluate
	 * @return Array of non-matched elements
	 */
	public Integer[] findUnmatched(Integer[] values) {
		if (values == null || values.length == 0) return new Integer[0];

		List<Integer> singles = new ArrayList<>();
		for (Integer value : values) {
			if (countElement(value, values) == 1) singles.add(value);
		}
		
		return singles.stream().toArray(Integer[] :: new);
	}
	
	/**
	 * Counts the number of elements in the array
	 * @param value Value to search for
	 * @param values collection of values to search
	 * @return
	 */
	protected int countElement(Integer value, Integer[] values) {
		int count = 0;
		for (Integer val : values) {
			if ((val == null && value == null) || (val != null && val.equals(value))) count++;
		}
		
		return count;
	}

}
