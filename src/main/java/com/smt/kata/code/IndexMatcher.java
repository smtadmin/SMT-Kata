package com.smt.kata.code;

// JDK 11.x
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/****************************************************************************
 * <b>Title</b>: IndexMatcher.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> IndexValue
 * 
 * A fixed point in an array is an element whose value is equal to its index. 
 * Given a sorted array of distinct elements, return a fixed point, if one exists. 
 * Otherwise, return False.
 * 
 * For example, given [-6, 0, 2, 40], you should return true (2 is the same as the index). 
 * 
 * Given [1, 5, 7, 8], you should return False
 * 
 * Note: You must perform this kata as a single line set of code
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 19, 2021
 * @updates:
 ****************************************************************************/
public class IndexMatcher {

	/**
	 * Determines if the int array has values that match the index
	 * @param values The array to evaluate
	 * @return True if there is a match.  False otherwise
	 */
	public boolean hasMatch(int[] values) {
		return ! (values == null || IntStream
				.range(0, values.length)
				.filter(i -> {return i == values[i]; })
				.mapToObj(i -> values[i])
				.collect(Collectors.toList())
				.isEmpty());
	}

}
