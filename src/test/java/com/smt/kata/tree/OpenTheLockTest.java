package com.smt.kata.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: OpenTheLockTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Open The Lock Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
class OpenTheLockTest {
	
	// Members
	OpenTheLock otl = new OpenTheLock();
	
	/**
	 * Test method for {@link com.smt.kata.tree.OpenTheLock#calculatePath(java.lang.String[], java.lang.String)}.
	 */
	@Test
	void testCalculatePath0009() throws Exception {
		assertEquals(1, otl.calculatePath(new String[] {"8888"}, "0009"));
	}

	/**
	 * Test method for {@link com.smt.kata.tree.OpenTheLock#calculatePath(java.lang.String[], java.lang.String)}.
	 */
	@Test
	void testCalculatePath8888() throws Exception {
		assertEquals(-1, otl.calculatePath(new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.OpenTheLock#calculatePath(java.lang.String[], java.lang.String)}.
	 */
	@Test
	void testCalculatePath0202() throws Exception {
		assertEquals(6, otl.calculatePath(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
	}

}
