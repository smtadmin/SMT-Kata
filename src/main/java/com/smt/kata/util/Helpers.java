package com.smt.kata.util;

import java.util.List;

/****************************************************************************
 * <b>Title</b>: Helpers.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Class of common functions so I don't need to rewrite them
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 24, 2021
 * @updates:
 ****************************************************************************/
public class Helpers {

	/**
	 * Sorts the array in sequential order
	 * @param arr Array to be sorted
	 */
	protected void sort(int[] arr) {
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
	 * Uses recursion to find each of the permutations
	 * @param perm
	 * @param word
	 */
	protected void findPermutations(String perm, String word, List<String> items) {
        if (word.isEmpty()) {
            items.add(perm + word);
        } else {
            for (int i = 0; i < word.length(); i++) {
            	String temp = word.substring(0, i) + word.substring(i + 1, word.length());
            	findPermutations(perm + word.charAt(i), temp, items);
            }
        }

    }
}
