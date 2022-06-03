package com.smt.kata.code;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Given a list and a number, create a new list that contains each number of list
 * at most N times, without reordering.  For example if the input number is 2, 
 * and the input list is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next 
 * [1,2] since this would lead to 1 and 2 being in the result 3 times, and then
 * take 3, which leads to [1,2,3,1,2,3].  With list [20,37,20,21] and number 1, 
 * the result would be [20,37,21].
 * 
 * Results:
 * removeOccurances should always return an array, empty if validation fails.
 * 
 * validation:
 * data should not be null
 * maxOccurances should not be negative.
 * 
 * @author raptor
 *
 */
public class RemoveNOccurances {

	public int [] removeOccurances(int [] data, int maxOccurances) {
		if(ArrayUtils.isEmpty(data) || maxOccurances < 1) {
			return new int[0];
		}
		Map<Integer, Integer> counts = new HashMap<>();

		return IntStream
			.of(data)
			.boxed()
			.map(i -> counts.compute(i, (k,v) -> v == null ? 0 : v + 1) < maxOccurances ? i : null)
			.filter(i -> i != null)
			.mapToInt(i -> i.intValue())
			.toArray();
	}
}
