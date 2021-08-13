package com.smt.kata.math;

// JDK 11.x
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/****************************************************************************
 * <b>Title</b>: ModulusSets.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Modulus Sets
 * 
 * Given a set of distinct positive integers, find the largest subset such that 
 * every pair of elements in the subset (i, j) satisfies either i % j = 0 or j % i = 0.  
 * 
 * For example, given the set [3, 5, 10, 20, 21], you should return [5, 10, 20]. 
 * 
 * Given [1, 3, 6, 24], return [1, 3, 6, 24]
 * 
 * The items in the array will NOT always be in order.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 12, 2021
 * @updates:
 ****************************************************************************/
public class ModulusSets {

	/**
	 * Calculates the number of modulus sets
	 * @param sequence Numbers to calculate against
	 * @return Largest colleciton of matchin modulus values
	 */
	public Collection<Integer> calculate(int[] input) {
		// Validate the input
		Set<Integer> finalSet = new HashSet<>();
		if (input == null || input.length < 3) return finalSet;
		
		// Put the data in order
		List<Integer> sequence = Arrays.stream(input).boxed().collect(Collectors.toList());
		Collections.sort(sequence);;
		
		// 2 loops, one for the starting value and one for the iteration of the sequence
		for (int i=0; i < sequence.size(); i++) {
			Set<Integer> data = new TreeSet<>();
			for (int j =0; j < sequence.size(); j++) {
				if (i >= j) continue;
				int iVal = sequence.get(i);
				int jVal = sequence.get(j);
				
				// If modulus is zero, add the elements to the set
				if (jVal % iVal == 0) {
					data.add(iVal);
					data.add(jVal);
				}
			}
			
			// If a given iteration is bigger than a previous one, update the final set
			if (data.size() > finalSet.size()) finalSet = data;
		}
		
		return finalSet;
	}

}
