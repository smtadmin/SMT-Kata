package com.smt.kata.number;

//Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: DisariumNumberTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the Disarium Number Kata class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class DisariumNumberTest {

	@Test
	void testIsDisarium() throws Exception {
		DisariumNumber dn = new DisariumNumber();
		assertFalse(dn.isDisarium(75));
		assertTrue(dn.isDisarium(135));
		assertTrue(dn.isDisarium(518));
		assertTrue(dn.isDisarium(8));
		assertFalse(dn.isDisarium(2456));
		assertTrue(dn.isDisarium(1306));
		assertTrue(dn.isDisarium(2427));
		assertFalse(dn.isDisarium(34237));
	}

}
