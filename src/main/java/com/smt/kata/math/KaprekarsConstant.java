package com.smt.kata.math;

// JDK 11.x
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/****************************************************************************
 * <b>Title</b>: KaprekarsConstant.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Kaprekar's Constant Kata
 * 
 * The number 6174 is known as Kaprekar's constant, after the mathematician who 
 * discovered an associated property: for all four-digit numbers with at least 
 * two distinct digits, repeatedly applying a simple procedure eventually results 
 * in this value. The procedure is as follows:
 * 
 * For a given input x, create two new numbers that consist of the digits in x in 
 * ascending and descending order.
 * 
 * Subtract the smaller number from the larger number.
 * For example, this algorithm terminates in three steps when starting from 1234:
 * 
 * 4321 - 1234 = 3087
 * 8730 - 0378 = 8352
 * 8532 - 2358 = 6174
 * 
 * Write a function that returns how many steps this will take for a given input N.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 25, 2021
 * @updates:
 ****************************************************************************/
public class KaprekarsConstant {

	/**
	 * Calculates the number of steps until Kaprekar's Constant is achieved
	 * @param num Number to evaluate
	 * @return the number of steps to acheive the number
	 */
	public int calculateSteps(int num) {
		// validate the data 
		if (!validateInput(num)) return 0;
		
		// Counter for each transaction
		int count = 0;
		
		// Loops until the number 6174 is reached
		while(num != 6174) {
			// Increment the counter
			count++;
			num = Math.abs(sort(num, true) - sort(num, false));
		}
		
		// Return the count
		return count;
	}
	
	/**
	 * Validates the input
	 * @param num Number to evaluate
	 * @return True of the data is 4 digits and has at least 2 unique characters
	 */
	private boolean validateInput(int num) {
		return ! ((num < 1000 || num > 9999) || IntStream.range(0, String.valueOf(num).length())
				 .mapToObj(i -> String.valueOf(num).charAt(i))
				 .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				 .size() < 2);
	}

	/**
	 * Sorts the integer into an ascending or descending string
	 * @param num Integer to convert to an ordered string
	 * @param desc Determines whether the sort should be descending
	 * @return Sorted (either ascending or descending) integer
	 */
	private Integer sort(int num, boolean desc) {
		char[] arr = String.valueOf(num).toCharArray();
		Arrays.sort(arr);
		StringBuilder ele = new StringBuilder(new String(arr));
		
		return desc ? Integer.valueOf(ele.reverse().toString()) : Integer.valueOf(ele.toString());
	}
}
