package com.smt.kata.code;

//Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: JosephusProblemTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit test fo rthe Josephus Problem Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class JosephusProblemTest {

	/**
	 * Test method for {@link com.smt.kata.code.JosephusProblem#josephus(int, int)}.
	 */
	@Test
	void testJosephusRecursive() throws Exception {
		JosephusProblem jp = new JosephusProblem();
		assertEquals(1, jp.josephusRecursive(2, 2)); // 1
		assertEquals(18, jp.josephusRecursive(35, 11)); // 18
		assertEquals(11, jp.josephusRecursive(11, 1)); // 11
		assertEquals(31, jp.josephusRecursive(41, 3)); // 31
		assertEquals(13, jp.josephusRecursive(14, 2)); // 13
	}

}
