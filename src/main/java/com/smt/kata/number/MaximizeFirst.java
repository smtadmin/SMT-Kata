package com.smt.kata.number;

// JDK 11.x
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/****************************************************************************
 * <b>Title:</b> MaximizeFirst.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Maximize the First Number
 * 
 * Write a function that makes the first number as large as possible by 
 * swapping out its digits for digits in the second number.
 * 
 * To illustrate:
 * 
 * maxPossible(9328, 456) ➞ 9658
 * // 9658 is the largest possible number built from swaps from 456.
 * // 3 replaced with 6 and 2 replaced with 5.
 * 
 * Examples
 * maxPossible(523, 76) ➞ 763
 * maxPossible(9132, 5564) ➞ 9655
 * maxPossible(8732, 91255) ➞ 9755
 * 
 * Notes
 * Each digit in the second number can only be used once.
 * Zero to all digits in the second number may be used.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class MaximizeFirst {

	/**
	 * Creates the max number possible by swapping digits in the first with the second
	 * @param first First number, or number to be compared
	 * @param second Number to use it's digits to improve the first
	 * @return Largest swapped number possible
	 */
	public int maxPossible(int first, int second) {
		
		// Convert the second string into a list of numbers.  Sort and reverse 
		// so the biggest #s are first
		List<Integer> sec = String.valueOf(second).chars().mapToObj(c -> c-'0').collect(Collectors.toList());
		Collections.sort(sec);
		Collections.reverse(sec);
		
		// Loop the first and see if each number can be replaced by a digit from the 
		// Second number
		StringBuilder sb = new StringBuilder();
		for (char c : String.valueOf(first).toCharArray()) {
			int val = c - '0';
			
			if (!sec.isEmpty() && sec.get(0) > val) {
				sb.append(sec.get(0));
				sec.remove(0);
			} else sb.append(val);
		}
		
		// Convert back to a number and return
		return Integer.valueOf(sb.toString());
	}

}
