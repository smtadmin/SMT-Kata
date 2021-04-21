package com.smt.kata.weather;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.Date;

// Spacelibs 1.x
import com.siliconmtn.data.format.DateFormat;
import com.siliconmtn.data.format.DateFormat.DatePattern;

/****************************************************************************
 * <b>Title:</b> SunriseSunsetCalculatorTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit Test for the Sunrise Sunset Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 21, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class SunriseSunsetCalculatorTest {

	/**
	 * Test method for {@link com.smt.kata.weather.SunriseSunsetCalculator#SunriseSunsetCalculator(java.util.Date, double, double)}.
	 */
	@Test
	void testSunriseSunsetCalculatorDateDoubleDouble() throws Exception {
		Date d = DateFormat.formatDate(DatePattern.DATE_DASH, "2021-04-21");
		SunriseSunsetCalculator calc = new SunriseSunsetCalculator(d, 36.7201600, -4.4203400);
		assertEquals("OK", calc.getStatus());
		assertEquals("5:34:42 AM", calc.getResults().getSunrise());
	}

	/**
	 * Test method for {@link com.smt.kata.weather.SunriseSunsetCalculator#getSunriseSunsetUrl()}.
	 */
	@Test
	void testGetSunriseSunsetSolarNoon() throws Exception {
		Date d = DateFormat.formatDate(DatePattern.DATE_DASH, "2021-04-21");
		SunriseSunsetCalculator calc = new SunriseSunsetCalculator(d, 36.7201600, -4.4203400);
		assertEquals("OK", calc.getStatus());
		assertEquals("12:16:14 PM", calc.getResults().getSolarNoon());
	}
	
	/**
	 * Test method for {@link com.smt.kata.weather.SunriseSunsetCalculator#getSunriseSunsetUrl()}.
	 */
	@Test
	void testGetSunriseSunsetCheckAllNewYearsDayBristol() throws Exception {
		Date d = DateFormat.formatDate(DatePattern.DATE_DASH, "2021-01-1");
		SunriseSunsetCalculator calc = new SunriseSunsetCalculator(d, 41.6750889, -72.9224329);
		assertEquals("OK", calc.getStatus());
		assertEquals("12:18:41 PM", calc.getResults().getSunrise());
		assertEquals("9:32:42 PM", calc.getResults().getSunset());
		assertEquals("4:55:41 PM", calc.getResults().getSolarNoon());
		assertEquals("09:14:01", calc.getResults().getDayLength());
		assertEquals("11:47:28 AM", calc.getResults().getCivilTwilightBegin());
		assertEquals("10:03:55 PM", calc.getResults().getCivilTwilightEnd());
		assertEquals("11:12:37 AM", calc.getResults().getNauticalTwilightBegin());
		assertEquals("10:38:46 PM", calc.getResults().getNauticalTwilightEnd());
		assertEquals("10:38:54 AM", calc.getResults().getAstronomicalTwilightBegin());
		assertEquals("11:12:29 PM", calc.getResults().getAstronomicalTwilightEnd());
	}

}
