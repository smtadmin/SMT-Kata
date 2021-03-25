package com.smt.kata.number;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title:</b> NumberSubsets.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Number Subsets
 * Given a multiset of integers, return whether it can be partitioned into two 
 * subsets whose sums are the same.
 * 
 * For example, given the multiset {15, 5, 20, 10, 35, 15, 10}, 
 * it would return true, since we can split it up into {15, 5, 10, 15, 10} and 
 * {20, 35}, which both add up to 55.
 * 
 * Given the multiset {15, 5, 20, 10, 35}, it would return false, since we 
 * can't split it up into two subsets that add up to the same sum.
 * 
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
	private List<List<Integer>> combinations = new ArrayList<>();
	
	/**
	 * Method gets every possible combo and then adds the elements in the combos 
	 * to see if we have a match
	 * @param elements Elements to use to add the options
	 * @return True if there is a matching pattern.  False otherwise
	 */
	public boolean findMataches(int[] elements) {
		if (elements == null || elements.length == 0) return false;
		combine(getSequence(elements.length), new StringBuilder(), 0);
		return findMatches(elements);
	}
	
	/**
	 * It's easier to get a list of combinations for a string.  We create a sequential
	 * String on the length of the array (0123)... 
	 * @param len Length of the sequence to create
	 * @return Sequential string starting at 0 and incrementing to the len provided
	 */
	private String getSequence(int len) {
		StringBuilder seq = new StringBuilder(len);
		for (int i=0; i < len; i++) seq.append(i);
		return seq.toString();
	}
	
	/**
	 * Takes each element in the list of options and adds them.  It then adds the 
	 * items not in the list ot form the "other" items and adds them.
	 * @param elements Elements to use to add the options
	 * @return True if there is a matching pattern.  False otherwise
	 */
	private boolean findMatches(int[] elements) {
		
		for (List<Integer> combos : combinations) {
			// If the combo matches the size of the elements, skip
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
			
			if (missing == combo) return true;
		}
		
		return false;
		
	}

	/**
	 * Gets all of the combinations of each character
	 * @param instr String to gets the combos
	 * @param outstr StringBuilder to add the combos
	 * @param index starting location for the combos
	 */
	private void combine(String instr, StringBuilder outstr, int index) {
		for (int i = index; i < instr.length(); i++) {
			outstr.append(instr.charAt(i));
			assign(outstr.toString());
			combine(instr, outstr, i + 1);
			outstr.deleteCharAt(outstr.length() - 1);
		}
	}

	/**
	 * Breaks each combo into a list of integers for that location
	 * @param sequence Numeric sequence to break into a list
	 */
	private void assign(String sequence) {
		List<Integer> combo = new ArrayList<>();
		for(char item : sequence.toCharArray()) {
			combo.add(Integer.valueOf(item - '0'));
		}
		
		combinations.add(combo);
	}
}
