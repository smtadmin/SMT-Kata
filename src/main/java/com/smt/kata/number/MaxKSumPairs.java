package com.smt.kata.number;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/****************************************************************************
 * <b>Title</b>: MaxKSumPairs.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Max Number of K-Sum Pairs
 * 
 * You are given an integer array nums and an integer k.
 * 
 * In one operation, you can any combination numbers from the array whose sum equals k 
 * and remove them from the array.
 * 
 * Return the maximum number of operations you can perform on the array.
 * 
 * Example 1:
 * Input: nums = [1,2,3,4], k = 5
 * Output: 2
 * Explanation: Starting with nums = [1,2,3,4]:
 * - Remove numbers 1 and 4, then nums = [2,3]
 * - Remove numbers 2 and 3, then nums = []
 * There are no more pairs that sum up to 5, hence a total of 2 operations.
 * 
 * Example 2:
 * Input: nums = [3,1,3,4,3], k = 6
 * Output: 1
 * Explanation: Starting with nums = [3,1,3,4,3]:
 * - Remove the first two 3's, then nums = [1,4,3]
 * There are no more pairs that sum up to 6, hence a total of 1 operation.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 24, 2021
 * @updates:
 ****************************************************************************/
public class MaxKSumPairs {
	
	/**
	 * In one operation, you can pick two numbers from the array whose sum equals k 
 	 * and remove them from the array.
	 * @param source Source array of numbers
	 * @param target Target number to calculate against
	 * @return Number of operations
	 */
	public int calculate(int[] source, int target) {
		// Validate the data
		if (source == null || source.length < 1) return 0;
		
		// Convert the array to a list.  Since we'll be removing items, use as 
		// Constructor of an array list
		List<Integer> items = new ArrayList<>(Arrays.stream(source).mapToObj(i -> i).collect(Collectors.toList()));
		List<List<Integer>> res = new ArrayList<>();
		
		// Loop the array and find every possible combo from one digit through source length
		for (int i=1; i <= source.length; i++) {
			findCombos(source, new int[source.length], 0, source.length-1, 0, i, res);
		}

		// Return the number of unique matches
		return calculateMatches(res, items, target);
	}
	
	/**
	 * Loop the combos looking for matches to the target.  When they match, 
	 * increment the counter and remove from the source list
	 * @param res All possible combinations of the original array
	 * @param items Original list of elements in the source array
	 * @param target Target number to match
	 * @return Total number of matches
	 */
	protected int calculateMatches(List<List<Integer>> res, List<Integer> items, int target) {
		int count = 0;
		for (List<Integer> combos : res) {
			int total = combos.stream().mapToInt(i -> i).sum();
			if (total == target && containsAll(items, combos)) {
				for (Integer combo : combos) {
					items.remove(combo);
				}

				count++;
			}
		}
		
		// Return the number of unique matches
		return count;
	}
	
	/**
	 * Checks to verify if the combos are ALL present in the source. List contains 
	 * all with duplicates doesn't work as I need
	 * @param source List of items to validate against
	 * @param combos Combos for a given iteration
	 * @return true if items are present.  False otherwise
	 */
	private boolean containsAll(List<Integer> source, List<Integer> combos) {
		for(Integer combo : combos) {
			if (Collections.frequency(source, combo) < Collections.frequency(combos, combo)) return false;
		}

		return true;
	}
	
	/**
	 * Recursive method to calculate all combinations in the array of the given size
	 * @param arr Source Array
	 * @param data Elements in the array to be matched
	 * @param start Start index
	 * @param end End Index
	 * @param index Index of the element being retrieved fromt he source
	 * @param r Size of the returned elements
	 * @param res All matching elements
	 */
	protected void findCombos(int arr[], int data[], int start, int end, int index, int r, List<List<Integer>> res) {
		// Current combination is ready to be printed, print it
		if (index == r) {
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < r; j++) {
				temp.add(data[j]);
			}
			res.add(temp);
			return;
		}

		// replace index with all possible elements. The condition
		// "end-i+1 >= r-index" makes sure that including one element
		// at index will make a combination with remaining elements
		// at remaining positions
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			findCombos(arr, data, i + 1, end, index + 1, r, res);
		}
	}
}
