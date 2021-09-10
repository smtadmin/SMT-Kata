package com.smt.kata.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: WiggleSequence.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 9, 2021
 * @updates:
 ****************************************************************************/
public class WiggleSequence {

	
	public int count(int[] sequence) {
		List<Integer> wiggle = new ArrayList<>();
		System.out.println(Arrays.toString(sequence));
		boolean isClear = true;
		boolean higher = true;
		int val = 0;
		for (int i=0; i < sequence.length - 1; i++) {
			
			if(isClear) val = sequence[i];
			int nextVal = sequence[i + 1];
			
			if (higher && nextVal > val) {
				if(! wiggle.contains(val)) wiggle.add(val);
				if(! wiggle.contains(nextVal)) wiggle.add(nextVal);
				higher = false;
				isClear = true;
			} else if (! higher && nextVal < val) {
				if(! wiggle.contains(val)) wiggle.add(val);
				if(! wiggle.contains(nextVal)) wiggle.add(nextVal);
				higher = true;
				isClear = true;
			} else {
				isClear = false;
			}
		}
		System.out.println(wiggle);
		System.out.println("============================");
		return wiggle.size();
	}
}
