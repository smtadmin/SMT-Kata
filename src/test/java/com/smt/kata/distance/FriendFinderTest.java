package com.smt.kata.distance;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: FriendFinderTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the Friend Finder kata class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 3, 2021
 * @updates:
 ****************************************************************************/
class FriendFinderTest {

	@Test
	void testFriendFinder() {
		FriendFinder ff = new FriendFinder();
		assertNotNull(ff);
	}

	@Test
	void testCalculateDistance() {
		FriendFinder ff = new FriendFinder();
		
		assertEquals(1, ff.calculateDistance("....SF..."));
		assertEquals(9, ff.calculateDistance("S........F"));
		assertEquals(4, ff.calculateDistance("..F...S.."));
		assertEquals(-1, ff.calculateDistance("....F..."));
		assertEquals(-1, ff.calculateDistance("........"));
		assertEquals(-1, ff.calculateDistance("...S....."));
	}

}
