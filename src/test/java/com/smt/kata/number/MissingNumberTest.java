package com.smt.kata.number;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MissingNumberTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class MissingNumberTest {

	@Test
	void testCalculateSum() {
		MissingNumber mn = new MissingNumber();
		
		assertEquals(10, mn.calculateSum(new int[]{1,2,3,4,5,6,7,8,9,11,12}));
		assertEquals(2, mn.calculateSum(new int[]{1,3}));
		assertEquals(2, mn.calculateSum(new int[]{1,3,4,5,6}));
	}

}
