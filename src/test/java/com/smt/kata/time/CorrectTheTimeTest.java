package com.smt.kata.time;

// Junit 5
import org.junit.Test;
import static org.junit.Assert.*;

/****************************************************************************
 * <b>Title</b>: CorretTheTimeTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the CorrectTheTime Kata class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 24, 2021
 * @updates:
 ****************************************************************************/
public class CorrectTheTimeTest {
	// Members
	private CorrectTheTime ctt = new CorrectTheTime();

	/**
	 * Test method for {@link com.smt.kata.time.CorrectTheTime#CorrectTheTime()}.
	 */
	@Test
	public void testCorrectTheTime() throws Exception {
		ctt = new CorrectTheTime();
		assertNotNull(ctt);
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.CorrectTheTime#transform(java.lang.String)}.
	 */
	@Test
	public void testTransformNull() throws Exception {
		assertEquals("", ctt.transform(null));
	}

	/**
	 * Test method for {@link com.smt.kata.time.CorrectTheTime#transform(java.lang.String)}.
	 */
	@Test
	public void testTransformCorrect() throws Exception {
		assertEquals("09:10:01", ctt.transform("09:10:01"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.CorrectTheTime#transform(java.lang.String)}.
	 */
	@Test
	public void testTransformMinutes() throws Exception {
		assertEquals("12:10:10", ctt.transform("11:70:10"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.CorrectTheTime#transform(java.lang.String)}.
	 */
	@Test
	public void testTransformMinSeconds() throws Exception {
		assertEquals("20:40:39", ctt.transform("19:99:99"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.CorrectTheTime#transform(java.lang.String)}.
	 */
	@Test
	public void testTransformHour() throws Exception {
		assertEquals("00:01:01", ctt.transform("24:01:01"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.CorrectTheTime#transform(java.lang.String)}.
	 */
	@Test
	public void testTransformCrazy() throws Exception {
		assertEquals("04:40:39", ctt.transform("99:99:99"));
	}

}
