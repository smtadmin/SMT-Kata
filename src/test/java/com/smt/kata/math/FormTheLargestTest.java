package com.smt.kata.math;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: FormTheLargestTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
class FormTheLargestTest {
	
	// Members
	FormTheLargest ftl = new FormTheLargest();

	/**
	 * Test method for {@link com.smt.kata.math.FormTheLargest#calculate(long)}.
	 */
	@Test
	void testCalculate() throws Exception {
		assertEquals(321, ftl.calculate(213));
	}

}
