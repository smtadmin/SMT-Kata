package com.smt.kata.code;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.List;



/****************************************************************************
 * <b>Title</b>: PhoneNumberCombosTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Phone Number Combos Kata Unit Test
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Sep 2, 2021
 * @updates:
 ****************************************************************************/
class PhoneNumberCombosTest {
	
	PhoneNumberCombos pnc = new PhoneNumberCombos();

	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberCombos#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		assertEquals(0, pnc.calculate(null).size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberCombos#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		assertEquals(0, pnc.calculate("").size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberCombos#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateInvalid() throws Exception {
		assertEquals(0, pnc.calculate("12r4").size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberCombos#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateDual() throws Exception {
		String[] results = new String[] {"ad","ae","af","bd","be","bf","cd","ce","cf" };
		List<String> nums = pnc.calculate("23");
		
		for (String res : results) {
			assertTrue(nums.contains(res));
		}
	}

	/**
	 * Test method for {@link com.smt.kata.code.PhoneNumberCombos#calculate(java.lang.String)}.
	 */
	@Test
	void testCalculateTriple() throws Exception {
		String[] results = new String[] {"gmw","gmx","gmy","gmz","gnw","gnx","gny","gnz","gow","gox","goy","goz","hmw","hmx","hmy","hmz","hnw","hnx","hny","hnz","how","hox","hoy","hoz","imw","imx","imy","imz","inw","inx","iny","inz","iow","iox","ioy","ioz" };
		List<String> nums = pnc.calculate("469");
		
		for (String res : results) {
			assertTrue(nums.contains(res));
		}
	}
	
}
