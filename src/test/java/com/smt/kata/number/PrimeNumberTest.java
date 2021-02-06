package com.smt.kata.number;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: PrimeNumberTest.java
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
class PrimeNumberTest {

	/**
	 * Test method for {@link com.smt.kata.number.PrimeNumber#getPrimes(int)}.
	 */
	@Test
	void testGetPrimes10() {
		PrimeNumber pn = new PrimeNumber();
		List<Integer> numbers = pn.getPrimes(10);
		assertEquals(4, numbers.size());
		assertTrue(numbers.contains(2));
		assertTrue(numbers.contains(3));
		assertTrue(numbers.contains(5));
		assertTrue(numbers.contains(7));
	}

	/**
	 * Test method for {@link com.smt.kata.number.PrimeNumber#getPrimes(int)}.
	 */
	@Test
	void testGetPrimes100() {
		PrimeNumber pn = new PrimeNumber();
		List<Integer> numbers = pn.getPrimes(100);
		assertEquals(25, numbers.size());
		assertTrue(numbers.contains(11));
		assertTrue(numbers.contains(13));
		assertTrue(numbers.contains(17));
		assertTrue(numbers.contains(31));
		assertTrue(numbers.contains(47));
		assertTrue(numbers.contains(59));
		assertTrue(numbers.contains(97));
	}
}
