package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: CheckWriterTest.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Tests the CheckWriter class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 4, 2021
 * @updates:
 ****************************************************************************/
class CheckWriterTest {

	/**
	 * Test method for {@link com.smt.kata.number.CheckWriter#convertWords(double)}.
	 */
	@Test
	void testConvertWords() {
		CheckWriter cw = new CheckWriter();

		assertEquals("Ten thousand nine hundred eighty five dollars and 25/100", cw.convertWords(10985.25));
		assertEquals("One hundred twenty five dollars and 75/100", cw.convertWords(125.75));
		assertEquals("Ninety five dollars ", cw.convertWords(95.00));
		assertEquals("Sixty nine dollars ", cw.convertWords(69));
		assertEquals("Two hundred seventeen dollars and 12/100", cw.convertWords(217.12));
	}

	/**
	 * tests the constructor and loading of the nnumber map
	 * @throws Exception
	 */
	@Test
	
	void testCheckWriter() throws Exception {
		CheckWriter cw = new CheckWriter();
		assertEquals("six", cw.numberMap.get(6));
	}

}
