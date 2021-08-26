package com.smt.kata.object;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: MatchstickToSquare.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Match Stick to Square Kata
 * 
 * You are given an integer array matchsticks where matchsticks[i] is the length 
 * of the ith matchstick. You want to use all the matchsticks to make one square. 
 * You should not break any stick, but you can link them up, and each matchstick 
 * must be used exactly one time.
 * 
 * Return true if you can make this square and false otherwise.
 * 
 * Example 1:
 * https://assets.leetcode.com/uploads/2021/04/09/matchsticks1-grid.jpg
 * Input: matchsticks = [1,1,2,2,2]
 * Output: true
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * 
 * Example 2:
 * Input: matchsticks = [3,3,3,3,4]
 * Output: false
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
public class MatchstickToSquare {

	/**
	 * Determines if the match sticks can form a square
	 * @param matchsticks Match sticks to evaluate
	 * @return True if they form a square, false otherwise
	 */
	public boolean canFormSquare(int[] matchsticks) {
		// Validate the input
		if (matchsticks == null || matchsticks.length < 4) return false;
		
		// Create a collection of match sticks and used slots
		List<Integer> sticks = new ArrayList<>();
		List<Integer> used = new ArrayList<>();
		
		// Get the total of the values and add the array values into a list
		int total = 0;
		for (int stick : matchsticks) {
			total += stick;
			sticks.add(stick);
		}
		
		// Check for modulus 4 as we need to have a subset of 4 in the total
		if (total % 4 != 0) return false;
		
		// Get the value per side
		int side = total / 4;
		
		// Remove the values that match the side total
		sticks.removeIf(num -> (num == side ));

		// Look for matches
		for(int i=0; i < sticks.size(); i++) {
			// If all of the sticks are used, return true
			if (used.size() == sticks.size()) return true;
			else if (!findMatch(sticks, used, i, side)) return false;
		}
		
		return true;
	}
	
	/**
	 * Look for matches for each index location
	 * @param sticks Original list of sticks that don't exactly match the side value
	 * @param used Index locations that are already used on a side
	 * @param idx Index of the loop to evaluate
	 * @param side Length of each side
	 * @return True if there is a match and false otherwise
	 */
	private boolean findMatch(List<Integer> sticks, List<Integer> used, int idx, int side) {
		// Check to make sure the index has not been accounted for
		if (used.contains(idx)) return true;
		
		// Get the starting value
		int val = sticks.get(idx);
		
		// Create a temp holder to store indexes used in the calculation
		List<Integer> hldr = new ArrayList<>();
		hldr.add(idx);
		
		// Total value of match sticks is assigned to the current value
		int total = val;
		
		// Loop the values and total them looking for a match
		for (int i = 0; i < sticks.size(); i++) {
			// filter out the current index and any used indexes
			if (i == idx || used.contains(i)) continue;
			
			// Update the totals and the hldr value
			total += sticks.get(i);
			hldr.add(i);
			
			// If the total matches the side add the indexes to the used collection and return true
			if (total == side) {
				used.addAll(hldr);
				return true;
			// If the total exceeds the side, reset the values and keep looking
			} else if (total > side) {
				hldr = new ArrayList<>();
				hldr.add(idx);
				total = val;
			}
		}
		
		return false;
	}
}
