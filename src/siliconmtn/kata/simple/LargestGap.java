package siliconmtn.kata.simple;

/****************************************************************************
 * <b>Title</b>: LargestGap.java
 * <b>Project</b>: _Sandbox
 * <b>Description: </b> Given an array of integers, return the largest gap between 
 * the sorted elements of the array.  For example, consider the array: 
 * [9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5] 
 * After sorting, the array becomes: [0, 0, 4, 5, 5, 6, 9, 20, 25, 26, 26] 
 * We now see that the largest gap in the array is between 9 and 20 which is 11.  
 * You must sort the arrays manually!  
 * You may not use Arrays.sort!
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class LargestGap {

	public static void main(String[] args) {
		System.out.println(largestGap(new int[] { 78, 34, 1, 3, 90, 34, -1, -4, 6, 55, 20, -65 })); // Output 61
		System.out.println(largestGap(new int[] { 9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5})); //Output 11
		System.out.println(largestGap(new int[] { 14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7 })); //Output 4
		System.out.println(largestGap(new int[] { 13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9 })); //Output 2
	}

	/**
	 * Sorts the array in sequential order
	 * @param arr
	 */
	public static void sort(int[] arr) {
		// sorting logic
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tmp = 0;
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	/**
	 * Calls out to get the array sorted and then finds the largest gap
	 * @param arr
	 * @return
	 */
	private static int largestGap(int[] arr) {
		sort(arr);
		int largestGap = 0;
		for (int i=1; i < arr.length; i++) {
			if (i > 0) {
				int gap = arr[i] - arr[i-1];
				if (gap > largestGap) largestGap = gap;
			}
		}
			
		return largestGap;
	}

}
