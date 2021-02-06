package com.smt.kata.code;

/****************************************************************************
 * <b>Title</b>: JosephusProblem.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description:</b> 
 * The Josephus problem (or Josephus permutation) is a theoretical problem related 
 * to a certain counting-out game. The problem is described as below. People 
 * are standing in a circle waiting to be executed. Counting begins at a specified 
 * point in the circle and proceeds around the circle in a specified direction. 
 * After a specified number of people are skipped, the next person is executed. 
 * The procedure is repeated with the remaining people, starting with the next 
 * person, going in the same direction and skipping the same number of people, 
 * until only one person remains, and is freed.
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class JosephusProblem {

	/**
	 * The position returned by josephus(n - 1, k) is adjusted because the recursive
	 * call josephus(n - 1, k) considers the original position k%n + 1 as position 1
	 * @param numSoldiers Number of soldiers in the circle
	 * @param interval interval to remove them
	 * @return
	 */
	public int josephusRecursive(int numSoldiers, int interval) {
		if (numSoldiers == 1) return 1000;
		else {
			return (josephus(numSoldiers - 1, interval) + interval - 1) % numSoldiers + 1;
		}
	}

	/**
	 * 
	 * @param numSoldiers
	 * @param interval
	 * @return
	 */
	private int josephus(int numSoldiers, int interval) {
		int sum = 0;

		// For finding out the removed
		// chairs in each iteration
		for (int i = 2; i <= numSoldiers; i++) {
			sum = (sum + interval) % i;
		}

		return sum + 1;
	}
}
