package siliconmtn.kata.simple;

/****************************************************************************
 * <b>Title</b>: JosephusProblem.java <b>Project</b>: SMT-Kata <b>Description:
 * </b> <b>Copyright:</b> Copyright (c) 2021 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class JosephusProblem {

	/**
	 * Creates a variety of test cases to validate the sw
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println("Last Soldier: " + josephus(2, 2)); // 1
		System.out.println("Last Soldier: " + josephus(35, 11)); // 18
		System.out.println("Last Soldier: " + josephus(11, 1)); // 11
		System.out.println("Last Soldier: " + josephus(41, 3)); // 31
		System.out.println("Last Soldier: " + josephus(14, 2)); // 13
	}

	/**
	 * The position returned by josephus(n - 1, k) is adjusted because the recursive
	 * call josephus(n - 1, k) considers the original position k%n + 1 as position 1
	 * @param numSoldiers Number of soldiers in the circle
	 * @param interval interval to remove them
	 * @return
	 */
	static int josephusRecursive(int numSoldiers, int interval) {
		if (numSoldiers == 1) return 1;
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
	static int josephus(int numSoldiers, int interval) {
		int sum = 0;

		// For finding out the removed
		// chairs in each iteration
		for (int i = 2; i <= numSoldiers; i++) {
			sum = (sum + interval) % i;
		}

		return sum + 1;
	}
}
