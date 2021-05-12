package com.smt.kata.time;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

// JDK 11.x
import java.util.List;

// Kata import
import com.smt.kata.time.MostOccurringWeekday.WeekDay;

/****************************************************************************
 * <b>Title</b>: MostOccurringWeekdayTest.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 10, 2021
 * @updates:
 ****************************************************************************/
public class MostOccurringWeekdayTest {
	
	MostOccurringWeekday mow = new MostOccurringWeekday();

	/**
	 * Test method for {@link com.smt.kata.time.MostOccurringWeekday#calculate(int)}.
	 */
	@Test
	public void testCalculate() throws Exception {
		assertEquals(WeekDay.MONDAY, mow.calculate(2018).get(0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.MostOccurringWeekday#calculate(int)}.
	 */
	@Test
	public void testCalculate2009() throws Exception {
		assertEquals(WeekDay.THURSDAY, mow.calculate(2009).get(0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.MostOccurringWeekday#calculate(int)}.
	 */
	@Test
	public void testCalculate1776() throws Exception {
		List<WeekDay> days = mow.calculate(1776);
		assertEquals(2, days.size());
		assertTrue(days.contains(WeekDay.TUESDAY));
		assertTrue(days.contains(WeekDay.MONDAY));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.MostOccurringWeekday#calculate(int)}.
	 */
	@Test
	public void testCalculateZero() throws Exception {
		List<WeekDay> days = mow.calculate(0);
		assertEquals(0, days.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.MostOccurringWeekday#calculate(int)}.
	 */
	@Test
	public void testCalculateOne() throws Exception {
		List<WeekDay> days = mow.calculate(1);
		assertEquals(1, days.size());
		assertTrue(days.contains(WeekDay.SATURDAY));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.MostOccurringWeekday#calculate(int)}.
	 */
	@Test
	public void testCalculateNegative() throws Exception {
		List<WeekDay> days = mow.calculate(-100);
		assertEquals(1, days.size());
		assertTrue(days.contains(WeekDay.FRIDAY));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.MostOccurringWeekday#calculate(int)}.
	 */
	@Test
	public void testCalculate100() throws Exception {
		List<WeekDay> days = mow.calculate(101);
		assertEquals(1, days.size());
		assertTrue(days.contains(WeekDay.FRIDAY));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.MostOccurringWeekday#calculate(int)}.
	 */
	@Test
	public void testCalculateMultiple() throws Exception {
		List<WeekDay> days = mow.calculate(2012);
		assertEquals(2, days.size());
		assertTrue(days.contains(WeekDay.SUNDAY));
		assertTrue(days.contains(WeekDay.MONDAY));
	}

}
