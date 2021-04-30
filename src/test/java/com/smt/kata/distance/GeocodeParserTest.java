package com.smt.kata.distance;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// SMT Kata imports
import com.smt.kata.distance.bean.Location;
import com.smt.kata.distance.bean.MatchCode;

/****************************************************************************
 * <b>Title:</b> GeocodeParserTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit test for the Geocode Parser Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 21, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class GeocodeParserTest {

	/**
	 * Test method for {@link com.smt.kata.distance.GeocodeParser#getGeocode()}.
	 */
	@Test
	void testGetGeocode() throws Exception {
		GeocodeParser gp = new GeocodeParser();
		Location loc = gp.getGeocode("", "", "", "06010", "US");
		assertEquals("BRISTOL", loc.getCity().toUpperCase());
		assertEquals("CT", loc.getState().toUpperCase());
		assertEquals("HARTFORD", loc.getCounty().toUpperCase());
		assertEquals("US", loc.getCountry().toUpperCase());
		assertEquals("UNITED STATES", loc.getCountryName().toUpperCase());
	}

	/**
	 * Test method for {@link com.smt.kata.distance.GeocodeParser#getGeocode()}.
	 */
	@Test
	void testGetGeocodeNoCountry() throws Exception {
		GeocodeParser gp = new GeocodeParser();
		Location loc = gp.getGeocode("", "", "", "06010", "");
		assertEquals("BRISTOL", loc.getCity().toUpperCase());
		assertEquals("CT", loc.getState().toUpperCase());
		assertEquals("HARTFORD", loc.getCounty().toUpperCase());
		assertEquals("US", loc.getCountry().toUpperCase());
		assertEquals("UNITED STATES", loc.getCountryName().toUpperCase());
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.GeocodeParser#getGeocode()}.
	 */
	@Test
	void testGetGeocodeNoData() throws Exception {
		GeocodeParser gp = new GeocodeParser();
		Location loc = gp.getGeocode(null, null, null, null, null);
		assertEquals("", loc.getCity().toUpperCase());
		assertEquals("", loc.getState().toUpperCase());
		assertEquals("", loc.getCounty().toUpperCase());
		assertEquals("US", loc.getCountry().toUpperCase());
		assertEquals("UNITED STATES", loc.getCountryName().toUpperCase());
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.GeocodeParser#getGeocode()}.
	 */
	@Test
	void testGetGeocodeNoMatch() throws Exception {
		GeocodeParser gp = new GeocodeParser();
		Location loc = gp.getGeocode(null, null, null, null, "ZZ");
		assertEquals(MatchCode.NO_MATCH, loc.getMatchCode());
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.GeocodeParser#getGeocode()}.
	 */
	@Test
	void testGetGeocodeMatchLatLong() throws Exception {
		GeocodeParser gp = new GeocodeParser();
		Location loc = gp.getGeocode("", "Fort Wayne", "IN", "", "US");
		assertEquals(MatchCode.CITY, loc.getMatchCode());
		assertEquals(41.1306041, loc.getLatitude());
		assertEquals(-85.1288597, loc.getLongitude());
	}
}
