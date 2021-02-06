package com.smt.kata.code;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MagicSigilTest.java
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
class MagicSigilTest {

	/**
	 * Test method for {@link com.smt.kata.code.MagicSigil#sigilize(java.lang.String)}.
	 */
	@Test
	void testSigilize() {
		MagicSigil ms = new MagicSigil();
		assertEquals("FNDYSLMT", ms.sigilize("I FOUND MY SOULMATE"));
		assertEquals("MLTHY", ms.sigilize("i am healthy"));
		assertEquals("HVBJNDTPYSWL", ms.sigilize("I have a job I enjoy and it pays well"));
		assertEquals("", ms.sigilize(""));
		assertEquals("", ms.sigilize(null));
	}

}
