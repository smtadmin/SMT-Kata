package com.smt.kata.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/****************************************************************************
 * <b>Title</b>: IdenticalNeighborsTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 6, 2021
 * @updates:
 ****************************************************************************/
public class IdenticalNeighborsTest {

	// Memebrs
	IdenticalNeighbors in = new IdenticalNeighbors();
	
	/**
	 * Test method for {@link com.smt.kata.code.IdenticalNeighbors#parse(int[])}.
	 */
	@Test
	public void testParseEmpty() throws Exception {
		int[] res = in.parse(null);
		assertEquals(0, res.length);
		
		res = in.parse(new int[0]);
		assertEquals(0, res.length);
		
		res = in.parse(new int[] {1});
		assertEquals(1, res.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.IdenticalNeighbors#parse(int[])}.
	 */
	@Test
	public void testParse() throws Exception {
		int[] res = in.parse(new int[]{1, 2, 2, 3, 4, 3, 5, 5, 6, 7, 8, 8});
		assertEquals(6, res.length);
		assertEquals(1, res[0]);
		assertEquals(3, res[1]);
		assertEquals(4, res[2]);
		assertEquals(3, res[3]);
		assertEquals(6, res[4]);
		assertEquals(7, res[5]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.IdenticalNeighbors#parse(int[])}.
	 */
	@Test
	public void testParseTriple() throws Exception {
		int[] res = in.parse(new int[]{1, 2, 2, 2, 3, 4, 3, 5, 5, 6, 7, 8, 8});
		assertEquals(7, res.length);
		assertEquals(1, res[0]);
		assertEquals(2, res[1]);
		assertEquals(3, res[2]);
		assertEquals(4, res[3]);
		assertEquals(3, res[4]);
		assertEquals(6, res[5]);
		assertEquals(7, res[6]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.IdenticalNeighbors#parse(int[])}.
	 */
	@Test
	public void testParseFive() throws Exception {
		int[] res = in.parse(new int[]{1, 2, 2, 2, 2, 2, 3, 4, 3, 5, 5, 6, 7, 8, 8});
		assertEquals(7, res.length);
		assertEquals(1, res[0]);
		assertEquals(2, res[1]);
		assertEquals(3, res[2]);
		assertEquals(4, res[3]);
		assertEquals(3, res[4]);
		assertEquals(6, res[5]);
		assertEquals(7, res[6]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.IdenticalNeighbors#parse(int[])}.
	 */
	@Test
	public void testParseQuad() throws Exception {
		int[] res = in.parse(new int[]{1, 2, 2, 2, 2, 3, 4, 3, 5, 5, 6, 7, 8, 8});
		assertEquals(6, res.length);
		assertEquals(1, res[0]);
		assertEquals(3, res[1]);
		assertEquals(4, res[2]);
		assertEquals(3, res[3]);
		assertEquals(6, res[4]);
		assertEquals(7, res[5]);
	}

	/**
	 * Test method for {@link com.smt.kata.code.IdenticalNeighbors#parse(int[])}.
	 */
	@Test
	public void testParseShort() throws Exception {
		int[] res = in.parse(new int[]{2, 2});
		assertEquals(0, res.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.IdenticalNeighbors#parse(int[])}.
	 */
	@Test
	public void testParseDouble() throws Exception {
		int[] res = in.parse(new int[]{2, 2, 1, 1});
		assertEquals(0, res.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.IdenticalNeighbors#parse(int[])}.
	 */
	@Test
	public void testParseInner() throws Exception {
		int[] res = in.parse(new int[]{2, 1, 1, 2});
		assertEquals(2, res.length);
		assertEquals(2, res[0]);
		assertEquals(2, res[1]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.IdenticalNeighbors#parse(int[])}.
	 */
	@Test
	public void testParseAlternating() throws Exception {
		int[] res = in.parse(new int[]{1,2,1,2});
		assertEquals(4, res.length);
		assertEquals(1, res[0]);
		assertEquals(2, res[1]);
		assertEquals(1, res[2]);
		assertEquals(2, res[3]);
	}
}
