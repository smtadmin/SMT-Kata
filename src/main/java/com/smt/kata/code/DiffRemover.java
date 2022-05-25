package com.smt.kata.code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Given a master int array and removes diff array.  Remove all instances of
 * elements in remove from master.
 * 
 * Example
 * 
 * master: {1,2,3,3,4,5,6}, remove: {1,3,5} => {2,4,6}
 * master: {1,2,3,3,4,5,6}, remove: {} => {1,2,3,3,4,5,6}
 * master: {1,2,3,3,4,5,6}, remove: {1,2,3,3,4,5,6} => {}
 * master: {}, remove: {1,3,5} => {}
 * 
 * Notes:
 * 
 * Order is not guaranteed on incoming lists but return should be ordered low->high
 * Method always returns an array, even if it is empty or inputs are null.
 * 
 * @author raptor
 *
 */
public class DiffRemover {

	public int[] deDiff(int[] master, int[] remove) {
		
		// Validate the Input
		if(ArrayUtils.isEmpty(master)) {
			return new int[0];
		} else if (ArrayUtils.isEmpty(remove)) {
			Arrays.sort(master);
			return master;
		}
		//Convert the removal to a HashSet
		Set<Integer> rems = new HashSet<>();

		//Populate the removals.
		IntStream.of(remove).forEach(i -> rems.add(i));
		
		///Filter, Sort and return the cleaned master array.
		return IntStream.of(master).filter(i -> !rems.contains(i)).sorted().toArray();
	}
}
