package com.smt.kata.math;

/****************************************************************************
 * <b>Title</b>: CostClimbingStairs.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Minimum Cost Climbing Stairs Kata
 * 
 * You are given an integer array cost where cost[i] is the cost of ith step on 
 * a staircase. Once you pay the cost, you can either climb one or two steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 * 
 * Use only the base JDK.  NO imports for this Kata
 * 
 * Example 1:
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: Cheapest is: start on cost[1], pay that cost, and go to the top.
 * 
 * Example 2:
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: Cheapest is: start on cost[0], and only step on 1s, skipping cost[3].
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
public class CostClimbingStairs {

	/**
	 * Calculates the smallest cost to climb the stairs
	 * @param costs Array of costs for each step on the stairs
	 * @return Smallest cost to climb
	 */
	public int calculate(int[] costs) {
		// Validate the data input
		if (costs == null || costs.length == 0) return 0;
		else if (costs.length == 1) return costs[0];
		
		// Calculate the cheapest path starting at the 0 index
		int zeroStart = calculateNumberSteps(0, costs, 0);
		
		// Calculate the cheapest path starting at the 1 index
		int oneStart = calculateNumberSteps(1, costs, 0);
		
		// return the smaller of the 0 or 1 starting index
		return zeroStart < oneStart ? zeroStart : oneStart;
	}
	
	/**
	 * Recursive method to calculate the most cost efficient path
	 * @param idx Starting index on the stairs
	 * @param costs Array of costs for each step
	 * @param total Total costs for reach iteration
	 * @return most cost efficient approach
	 */
	private int calculateNumberSteps(int idx, int[] costs, int total) {
		// If the index passed is greater than the # of stairs, return the total
		if (idx >= costs.length) return total;
		
		// Update the total from the value of the step
		total += costs[idx];
		
		// Recurse using one step or two
		int jump1 = calculateNumberSteps(idx + 1, costs, total);
		int jump2 = calculateNumberSteps(idx + 2, costs, total);
		
		// Return the smaller of the two values
		return jump1 > jump2 ? jump2 : jump1;
	}
}
