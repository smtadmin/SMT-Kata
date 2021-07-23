package com.smt.kata.time;

import static org.junit.Assert.assertNull;
// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// Spacelibs 1.x
import com.siliconmtn.data.format.DateFormat;
import com.siliconmtn.data.format.DateFormat.DatePattern;

// Kata libs
import com.smt.kata.time.UsersInBuilding.EntryType;
import com.smt.kata.time.UsersInBuilding.Response;

/****************************************************************************
 * <b>Title</b>: UsersInBuildingTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for Users in Building Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 28, 2021
 * @updates:
 ****************************************************************************/
class UsersInBuildingTest {

	/**
	 * Test method for {@link com.smt.kata.time.UsersInBuilding#getBusyPeriod()}.
	 */
	@Test
	void testGetBusyPeriod() throws Exception {
		UsersInBuilding uib = new UsersInBuilding();
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 08:00:00"), 10, EntryType.ENTER);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 09:00:00"), 3, EntryType.ENTER);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 12:00:00"), 7, EntryType.EXIT);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 13:00:00"), 6, EntryType.ENTER);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 17:00:00"), 12, EntryType.EXIT);
		Response r = uib.getBusyPeriod();

		assertEquals(13, r.getCount());
		assertEquals(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 09:00:00"), r.getStart());
		assertEquals(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 12:00:00"), r.getEnd());
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.UsersInBuilding#getBusyPeriod()}.
	 */
	@Test
	void testGetBusyPeriodMicro() throws Exception {
		UsersInBuilding uib = new UsersInBuilding();
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 08:00:00"), 1, EntryType.ENTER);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 08:00:01"), 1, EntryType.ENTER);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 08:00:02"), 1, EntryType.ENTER);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 08:00:03"), 1, EntryType.ENTER);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 08:00:04"), 1, EntryType.ENTER);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 08:00:05"), 1, EntryType.ENTER);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 09:00:00"), 3, EntryType.ENTER);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 12:00:00"), 1, EntryType.EXIT);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 12:00:01"), 1, EntryType.EXIT);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 12:00:02"), 1, EntryType.EXIT);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 12:00:03"), 1, EntryType.EXIT);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 12:00:04"), 1, EntryType.EXIT);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 13:00:00"), 6, EntryType.ENTER);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 17:00:03"), 5, EntryType.EXIT);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 17:00:04"), 1, EntryType.EXIT);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 17:00:05"), 1, EntryType.EXIT);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 17:00:06"), 1, EntryType.EXIT);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 17:00:07"), 1, EntryType.EXIT);
		uib.addEntry(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 17:00:08"), 1, EntryType.EXIT);
		Response r = uib.getBusyPeriod();

		assertEquals(10, r.getCount());
		assertEquals(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 13:00:00"), r.getStart());
		assertEquals(DateFormat.formatDate(DatePattern.DATE_TIME_DASH, "2021-06-25 17:00:03"), r.getEnd());
	}
	
	/**
	 * Test method for {@link com.smt.kata.time.UsersInBuilding#getBusyPeriod()}.
	 */
	@Test
	void testGetBusyPeriodNoEntries() throws Exception {
		UsersInBuilding uib = new UsersInBuilding();
		Response r = uib.getBusyPeriod();
		assertEquals(0, r.getCount());
		assertNull(r.getStart());
		assertNull(r.getEnd());
	}

}
