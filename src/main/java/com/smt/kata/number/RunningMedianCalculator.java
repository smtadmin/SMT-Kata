package com.smt.kata.number;

// JDK 11.x
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: RunningMedianCalculator.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Compute the running median of a sequence of numbers. 
 * That is, given a stream of numbers, print out the median of the list so far 
 * on each new element.
 * 
 * Recall that the median of an even-numbered list is the average of the two middle numbers.
 * 
 * For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
 * 2
 * 1.5
 * 2
 * 3.5
 * 2
 * 2
 * 2
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 25, 2021
 * @updates:
 ****************************************************************************/
public class RunningMedianCalculator {

	/**
	 * 
	 */
	public RunningMedianCalculator() {
		super();
	}
	
	/**
	 * Takes an array of integers and returns the running median value
	 * @param values
	 * @return
	 */
	public List<Double> getMedianValues(int[] values) {
		List<Double> medianValues = new ArrayList<>();
		if (values == null || values.length == 0) return medianValues;
		
		List<Integer> sequence = new ArrayList<>();
		for (int val : values) {
			sequence.add(val);
			Collections.sort(sequence);
			
			if (sequence.size() % 2 == 1) {
				int loc = (int) Math.ceil(sequence.size() / 2);
				medianValues.add(Double.valueOf(sequence.get(loc)));
			} else {
				int loc = sequence.size() / 2;
				double avg = ((sequence.get(loc) + sequence.get(loc - 1)) / (double)2);
				medianValues.add(Math.round(avg * 2) / 2.0);
			}
		}
		
		return medianValues;
	}

}
