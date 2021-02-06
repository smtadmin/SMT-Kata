package com.smt.kata.data;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: ReverseLettersKeepNumbersTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the kata class for Reverse Letters Keep Numbers
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class ReverseLettersKeepNumbersTest {

	@Test
	void testReverse() {
		ReverseLettersKeepNumbers rev = new ReverseLettersKeepNumbers();
		
		assertEquals("cb89a", rev.reverse("ab89c".toCharArray()));
		assertEquals("onm5lk923j", rev.reverse("jkl5mn923o".toCharArray()));
		assertEquals("123a45", rev.reverse("123a45".toCharArray()));
	}

}
