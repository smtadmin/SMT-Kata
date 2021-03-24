package com.smt.kata.number;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title:</b> NumberSubsets.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class NumberSubsets {
	
	
	public boolean findMataches(int[] elements) {
		List<List<Integer>> combinations = combos(elements);
		System.out.println(combinations);
		return findMatches(combinations, elements);
	}
	
	
	private boolean findMatches(List<List<Integer>> combinations, int[] elements) {
		
		for (List<Integer> combos : combinations) {
			// If the zie matches the size of the elements, skip
			if (combos.size() == elements.length) continue;
			
			int combo = 0;
			int missing = 0;
			
			// Add up the values in the combo
			for (int value : combos) combo += elements[value];
			
			// Add up the elements missing from the combo
			for (int i=0; i < elements.length; i++) {
				if (combos.contains(i)) continue;
				missing += elements[i];
			}
			
			System.out.println(combo + "|" + missing);
			if (missing == combo) return true;
		}
		
		return false;
		
	}

	/**
	 * Gets all of the possible combinations from the array of elements
	 * @param elements Array of ints to process
	 * @return Collection of combinations
	 */
	public static List<List<Integer>> combos(int[] elements) {
		List<List<Integer>> allCombinations = new ArrayList<>();
		List<Integer> sub = new ArrayList<>();
		for (int i = 0; i < elements.length; i++) {
			
			for (int j = 1; j <= elements.length - i; j++) {
				for (int x = i; x < i+j; x++) sub.add(x);
				allCombinations.add(sub);
				sub = new ArrayList<>();
			}
		}
		
		return allCombinations;
	}
}
