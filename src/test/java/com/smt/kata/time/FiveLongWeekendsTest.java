package com.smt.kata.time;

// Junit 5
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.Calendar;
import java.util.Date;

// Spaclibs Java
import com.siliconmtn.data.format.DateFormat;
import com.siliconmtn.data.format.DateFormat.DatePattern;

/****************************************************************************
 * <b>Title:</b> FiveLongWeekendsTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit Test for the Five Long Weekends Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 30, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class FiveLongWeekendsTest {
	
	// Members
	FiveLongWeekends flw = new FiveLongWeekends();

	/**
	 * Test method for {@link com.smt.kata.time.FiveLongWeekends#findNext(java.util.Date)}.
	 */
	@Test
	void testFindNext() throws Exception {
		Date d = DateFormat.formatDate(DatePattern.DATE_DASH, "2017-01-03");
		Date res = flw.findNext(d);
		
		assertEquals(2017, getYear(res));
		assertEquals(12, getMonth(res));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.FiveLongWeekends#findNext(java.util.Date)}.
	 */
	@Test
	void testFindNext2016OnDate() throws Exception {
		Date d = DateFormat.formatDate(DatePattern.DATE_DASH, "2016-01-01");
		Date res = flw.findNext(d);
		
		assertEquals(2016, getYear(res));
		assertEquals(1, getMonth(res));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.FiveLongWeekends#findNext(java.util.Date)}.
	 */
	@Test
	void testFindNext2016() throws Exception {
		Date d = DateFormat.formatDate(DatePattern.DATE_DASH, "2016-01-03");
		Date res = flw.findNext(d);
		
		assertEquals(2016, getYear(res));
		assertEquals(7, getMonth(res));
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.FiveLongWeekends#findNext(java.util.Date)}.
	 */
	@Test
	void testFindNextNone() throws Exception {
		Date d = new Date();
		assertNull(flw.findNext(d));
	}
	
	/**
	 * Gets the month from the date
	 * @param d Date of the long weekend month
	 * @return Number of the month
	 */
	private int getMonth(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal.get(Calendar.MONTH) + 1;
	}
	
	/**
	 * Gets the year from the date
	 * @param d Date of the long weekend year
	 * @return Number of the year
	 */
	private int getYear(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal.get(Calendar.YEAR);
	}

}
