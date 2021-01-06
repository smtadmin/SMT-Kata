package siliconmtn.kata.simple;

/****************************************************************************
 * <b>Title</b>: TripleUp.java 
 * <b>Project</b>: _Sandbox 
 * <b>Description: </b> Return true if the array contains, somewhere, three 
 * increasing adjacent numbers like .... 4, 5, 6, ... or 23, 24, 25.
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class TripleUp {

	public static void main(String[] args) {
		System.out.println("Valid: " + tripleUp(new int[] { 1, 4, 5, 6, 2 })); // → true
		System.out.println("Valid: " + tripleUp(new int[] { 1, 2, 3 })); // → true
		System.out.println("Valid: " + tripleUp(new int[] { 1, 2, 4 })); // → false
		System.out.println("Valid: " + tripleUp(new int[] { -1, -2, -3, 7, 6, 8 })); // → false
		System.out.println("Valid: " + tripleUp(new int[] { -3, -2, -1, 3, 4, 8 })); // → true
	}

	/**
	 * Loops through the array and counts how many are in sequence in a row
	 * @param nums
	 * @return
	 */
	public static boolean tripleUp(int[] nums) {
		if (nums.length < 3) return false;

		int prev = 0;
		int numSeq = 0;

		for (int i = 0; i < nums.length; i++) {
			if (i > 0 && (nums[i] - prev) == 1) {
				numSeq++;
				if (numSeq == 2) return true;
			} else numSeq = 0;

			prev = nums[i];
		}

		return false;
	}

}
