package com.smt.kata.distance;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> LexigraphicOrderingTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit test for the Lexigraphic Ordering Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 23, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class LexigraphicOrderingTest {
	
	// Members
	LexigraphicOrdering lo = new LexigraphicOrdering();
	/**
	 * Test method for {@link com.smt.kata.distance.LexigraphicOrdering#orderData(char[][])}.
	 */
	@Test
	void testOrderDataEmpty() throws Exception {
		assertEquals(0, lo.orderData(null).length);
		assertEquals(0, lo.orderData(new char[0][]).length);
	}

	/**
	 * Test method for {@link com.smt.kata.distance.LexigraphicOrdering#orderData(char[][])}.
	 */
	@Test
	void testOrderData() throws Exception {
		char[][] data = lo.orderData(new char[][] {
			{ 'c', 'b', 'a' },
			{ 'd', 'a', 'f' },
			{ 'g', 'h', 'i' }
		});
		
		assertEquals(3, data.length);
		assertEquals(2, data[0].length);
		assertEquals('a', data[0][1]);
		assertEquals('f', data[1][1]);
		assertEquals('i', data[2][1]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.LexigraphicOrdering#orderData(char[][])}.
	 */
	@Test
	void testOrderDataAll() throws Exception {
		char[][] data = lo.orderData(new char[][] {
			{ 'c', 'b', 'a' },
			{ 'd', 'g', 'f' },
			{ 'g', 'h', 'i' }
		});
		
		assertEquals(3, data.length);
		assertEquals(3, data[0].length);
		assertEquals('a', data[0][2]);
		assertEquals('f', data[1][2]);
		assertEquals('i', data[2][2]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.LexigraphicOrdering#orderData(char[][])}.
	 */
	@Test
	void testOrderDataSingleRow() throws Exception {
		char[][] data = lo.orderData(new char[][] {
			{ 'a', 'b', 'c', 'd', 'e', 'f' }
		});
		
		assertEquals(1, data.length);
		assertEquals(6, data[0].length);
	}

	/**
	 * Test method for {@link com.smt.kata.distance.LexigraphicOrdering#orderData(char[][])}.
	 */
	@Test
	void testOrderDataNoCols() throws Exception {
		char[][] data = lo.orderData(new char[][] {
			{ 'z', 'y', 'x' },
			{ 'w', 'v', 'u' },
			{ 't', 's', 'r' }
		});
		
		assertEquals(0, data.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.LexigraphicOrdering#orderData(char[][])}.
	 */
	@Test
	void testOrderDataOneCols() throws Exception {
		char[][] data = lo.orderData(new char[][] {
			{ 'z', 'y', 'x', 'a' },
			{ 'w', 'v', 'u', 'b' },
			{ 't', 's', 'r', 'c' }
		});
		
		assertEquals(3, data.length);
		assertEquals(1, data[0].length);
	}
}
