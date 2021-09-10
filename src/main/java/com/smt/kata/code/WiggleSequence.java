package com.smt.kata.code;

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
		int counter = 1;
		for (int i = 0; i < sequence.length - 1; i++) {
			int val = sequence[i];
			int nextVal = sequence[i + 1];
			
			if ((i % 2) == 0 && nextVal > val) counter++;
			else if ((i % 2) == 1 && nextVal < val) counter++;
		}
		
		return counter;
	}
}
