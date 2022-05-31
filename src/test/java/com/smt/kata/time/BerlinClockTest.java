package com.smt.kata.time;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BerlinClockTest {

	BerlinClock bc = new BerlinClock();

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleMinutesRow()}.
	 */
	@Test
	void testSingleMinutesNull() {
		assertEquals(null, bc.generateSingleMinutesRow(""));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleMinutesRow()}.
	 */
	@Test
	void testSingleMinutesInvalid1() {
		assertEquals(null, bc.generateSingleMinutesRow("000000"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleMinutesRow()}.
	 */
	@Test
	void testSingleMinutesInvalid2() {
		assertEquals(null, bc.generateSingleMinutesRow("ab:c1:23"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleMinutesRow()}.
	 */
	@Test
	void testSingleMinutesZeros() {
		assertEquals("0000", bc.generateSingleMinutesRow("00:00:00"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleMinutesRow()}.
	 */
	@Test
	void testSingleMinutesMax() {
		assertEquals("YYYY", bc.generateSingleMinutesRow("23:59:59"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleMinutesRow()}.
	 */
	@Test
	void testSingleMid() {
		assertEquals("YY00", bc.generateSingleMinutesRow("12:32:00"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleMinutesRow()}.
	 */
	@Test
	void testSingleMinutesFull() {
		assertEquals("YYYY", bc.generateSingleMinutesRow("12:34:00"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleMinutesRow()}.
	 */
	@Test
	void testSingleMinutesFive() {
		assertEquals("0000", bc.generateSingleMinutesRow("12:35:00"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateFiveMinutesRow()}.
	 */
	@Test
	void testFiveMinutesNull() {
		assertEquals(null, bc.generateFiveMinutesRow(""));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateFiveMinutesRow()}.
	 */
	@Test
	void testFiveMinutesInvalid1() {
		assertEquals(null, bc.generateFiveMinutesRow("000000"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateFiveMinutesRow()}.
	 */
	@Test
	void testFiveMinutesInvalid2() {
		assertEquals(null, bc.generateFiveMinutesRow("ab:c1:23"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateFiveMinutesRow()}.
	 */
	@Test
	void testFiveMinutesZeros() {
		assertEquals("00000000000", bc.generateFiveMinutesRow("00:00:00"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateFiveMinutesRow()}.
	 */
	@Test
	void testFiveMinutesMax() {
		assertEquals("YYRYYRYYRYY", bc.generateFiveMinutesRow("23:59:59"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateFiveMinutesRow()}.
	 */
	@Test
	void testFiveMinutesSubLevel() {
		assertEquals("00000000000", bc.generateFiveMinutesRow("12:04:00"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateFiveMinutesRow()}.
	 */
	@Test
	void testFiveMinutesUpper() {
		assertEquals("YYRY0000000", bc.generateFiveMinutesRow("12:23:00"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateFiveMinutesRow()}.
	 */
	@Test
	void testFiveMinutesMid() {
		assertEquals("YYRYYRY0000", bc.generateFiveMinutesRow("12:35:00"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleHoursRow()}.
	 */
	@Test
	void testSingleHoursNull() {
		assertEquals(null, bc.generateSingleHoursRow(""));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleHoursRow()}.
	 */
	@Test
	void testSingleHoursInvalid1() {
		assertEquals(null, bc.generateSingleHoursRow("000000"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleHoursRow()}.
	 */
	@Test
	void testSingleHoursInvalid2() {
		assertEquals(null, bc.generateSingleHoursRow("ab:c1:23"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleHoursRow()}.
	 */
	@Test
	void testSingleHoursZeros() {
		assertEquals("0000", bc.generateSingleHoursRow("00:00:00"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleHoursRow()}.
	 */
	@Test
	void testSingleHoursMax() {
		assertEquals("RRR0", bc.generateSingleHoursRow("23:59:59"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleHoursRow()}.
	 */
	@Test
	void testSingleHoursMid() {
		assertEquals("RR00", bc.generateSingleHoursRow("02:04:00"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleHoursRow()}.
	 */
	@Test
	void testSingleHoursFull() {
		assertEquals("RRRR", bc.generateSingleHoursRow("14:35:00"));
	}

	/**
	 * Test method for
	 * {@link com.smt.kata.time.BerlinClock#generateSingleHoursRow()}.
	 */
	@Test
	void testSingleHoursThree() {
		assertEquals("RRR0", bc.generateSingleHoursRow("08:23:00"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateFiveHoursRow()}.
	 */
	@Test
	void testFiveHoursNull() {
		assertEquals(null, bc.generateFiveHoursRow(""));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateFiveHoursRow()}.
	 */
	@Test
	void testFiveHoursInvalid1() {
		assertEquals(null, bc.generateFiveHoursRow("000000"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateFiveHoursRow()}.
	 */
	@Test
	void testFiveHoursInvalid2() {
		assertEquals(null, bc.generateFiveHoursRow("ab:c1:23"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateFiveHoursRow()}.
	 */
	@Test
	void testFiveHoursZeros() {
		assertEquals("0000", bc.generateFiveHoursRow("00:00:00"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateFiveHoursRow()}.
	 */
	@Test
	void testFiveHoursMax() {
		assertEquals("RRRR", bc.generateFiveHoursRow("23:59:59"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateFiveHoursRow()}.
	 */
	@Test
	void testFiveHoursMid() {
		assertEquals("RRR0", bc.generateFiveHoursRow("16:35:00"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateFiveHoursRow()}.
	 */
	@Test
	void testFiveHoursStart() {
		assertEquals("R000", bc.generateFiveHoursRow("08:23:00"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateFiveHoursRow()}.
	 */
	@Test
	void testFiveHoursFive() {
		assertEquals("0000", bc.generateFiveHoursRow("02:04:00"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateTime()}.
	 */
	@Test
	void testGenerateTimeNull() {
		assertEquals(null, bc.generateTime(""));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateTime()}.
	 */
	@Test
	void testGenerateTimeInvalid1() {
		assertEquals(null, bc.generateTime("000000"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateTime()}.
	 */
	@Test
	void testGenerateTimeInvalid2() {
		assertEquals(null, bc.generateTime("ab:c1:23"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateTime()}.
	 */
	@Test
	void testGenerateTimeZeros() {
		assertEquals("Y00000000000000000000000", bc.generateTime("00:00:00"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateTime()}.
	 */
	@Test
	void testGenerateTimeMax() {
		assertEquals("0RRRRRRR0YYRYYRYYRYYYYYY", bc.generateTime("23:59:59"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateTime()}.
	 */
	@Test
	void testGenerateTime2() {
		assertEquals("YRRR0R000YYRYYRYYRY00000", bc.generateTime("16:50:06"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateTime()}.
	 */
	@Test
	void testGenerateTime3() {
		assertEquals("0RR00R000YYRYYRY0000YY00", bc.generateTime("11:37:01"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateSeconds()}.
	 */
	@Test
	void testSecondsNull() {
		assertEquals(null, bc.generateSeconds(""));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateSeconds()}.
	 */
	@Test
	void testSecondsInvalid1() {
		assertEquals(null, bc.generateSeconds("000000"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateSeconds()}.
	 */
	@Test
	void testSecondsInvalid2() {
		assertEquals(null, bc.generateSeconds("ab:c1:23"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateSeconds()}.
	 */
	@Test
	void testSecondsEven() {
		assertEquals("Y", bc.generateSeconds("00:00:00"));
	}

	/**
	 * Test method for {@link com.smt.kata.time.BerlinClock#generateSeconds()}.
	 */
	@Test
	void testSecondsOdd() {
		assertEquals("0", bc.generateSeconds("23:59:59"));
	}
}
