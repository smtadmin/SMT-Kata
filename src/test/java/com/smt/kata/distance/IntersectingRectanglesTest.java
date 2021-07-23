package com.smt.kata.distance;

// JDK 11.x
import java.util.List;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: IntersectingRectanglesTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 19, 2021
 * @updates:
 ****************************************************************************/
class IntersectingRectanglesTest {
	
	// Members
	IntersectingRectangles ir = new IntersectingRectangles();
	
	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingRectangles#getOverlap(com.smt.kata.distance.IntersectingRectangles.Coord, int, int, com.smt.kata.distance.IntersectingRectangles.Coord, int, int)}.
	 */
	@Test
	void testGetOverlapBroken() throws Exception {
		assertEquals(0, ir.getOverlap(null, 0, 0, null, 0, 0).size());
		assertEquals(0, ir.getOverlap(new Coord(1,5), 0, -1, new Coord(1,5), -1, 0).size());
	}

	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingRectangles#getOverlap(com.smt.kata.distance.IntersectingRectangles.Coord, int, int, com.smt.kata.distance.IntersectingRectangles.Coord, int, int)}.
	 */
	@Test
	void testGetOverlap() throws Exception {
		List<Coord> coords = ir.getOverlap(new Coord(1,4), 3, 3, new Coord(0,5), 3, 4);
		assertEquals(6, coords.size());
		assertEquals(new Coord(1,5), coords.get(0));
		assertEquals(new Coord(1,6), coords.get(1));
		assertEquals(new Coord(2,5), coords.get(2));
		assertEquals(new Coord(2,6), coords.get(3));
		assertEquals(new Coord(3,5), coords.get(4));
		assertEquals(new Coord(3,6), coords.get(5));
	}

	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingRectangles#getOverlap(com.smt.kata.distance.IntersectingRectangles.Coord, int, int, com.smt.kata.distance.IntersectingRectangles.Coord, int, int)}.
	 */
	@Test
	void testGetNoOverlap() throws Exception {
		List<Coord> coords = ir.getOverlap(new Coord(1,4), 3, 3, new Coord(6,6), 4, 3);
		assertEquals(0, coords.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.IntersectingRectangles#getOverlap(com.smt.kata.distance.IntersectingRectangles.Coord, int, int, com.smt.kata.distance.IntersectingRectangles.Coord, int, int)}.
	 */
	@Test
	void testGetOverlapAll() throws Exception {
		List<Coord> coords = ir.getOverlap(new Coord(1,4), 3, 3, new Coord(1,4), 3, 3);
		assertEquals(9, coords.size());
		assertEquals(new Coord(1,4), coords.get(0));
		assertEquals(new Coord(1,5), coords.get(1));
		assertEquals(new Coord(1,6), coords.get(2));
		assertEquals(new Coord(2,4), coords.get(3));
		assertEquals(new Coord(2,5), coords.get(4));
		assertEquals(new Coord(2,6), coords.get(5));
		assertEquals(new Coord(3,4), coords.get(6));
		assertEquals(new Coord(3,5), coords.get(7));
		assertEquals(new Coord(3,6), coords.get(8));
	}
	
}
