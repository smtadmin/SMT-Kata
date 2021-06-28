package com.smt.kata.distance;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: PixelSwapTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the pixel swap kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 28, 2021
 * @updates:
 ****************************************************************************/
class PixelSwapTest {
	
	// Members
	PixelSwap ps = new PixelSwap();
	
	/**
	 * Test method for {@link com.smt.kata.distance.PixelSwap#swap(char[][], int[], char)}.
	 */
	@Test
	void testSwapEmpty() throws Exception {
		assertEquals(0, ps.swap(null, null, 'G').length);
		assertEquals(0, ps.swap(new char[5][3], null, 'G').length);
		assertEquals(0, ps.swap(null, new int[] {0,0}, 'G').length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.PixelSwap#swap(char[][], int[], char)}.
	 */
	@Test
	void testSwapBadCoords() throws Exception {
		char[][] pixels = new char[][] {
			{ 'B', 'B', 'W' },
			{ 'W', 'W', 'W' },
			{ 'W', 'W', 'W' },
			{ 'B', 'B', 'B' }
		};
		
		assertEquals(0, ps.swap(pixels, new int[] {5,6}, 'G').length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.PixelSwap#swap(char[][], int[], char)}.
	 */
	@Test
	void testSwap() throws Exception {
		char[][] pixels = new char[][] {
			{ 'B', 'B', 'W' },
			{ 'W', 'W', 'W' },
			{ 'W', 'W', 'W' },
			{ 'B', 'B', 'B' }
		};
		
		char[][] swapped = ps.swap(pixels, new int[] { 2,2 }, 'G');
		assertEquals('G', swapped[0][2]);
		assertEquals('G', swapped[1][0]);
		assertEquals('G', swapped[1][1]);
		assertEquals('G', swapped[1][2]);
		assertEquals('G', swapped[2][1]);
		assertEquals('G', swapped[2][1]);
		assertEquals('G', swapped[2][2]);
	}

	/**
	 * Test method for {@link com.smt.kata.distance.PixelSwap#swap(char[][], int[], char)}.
	 */
	@Test
	void testSwapStairs() throws Exception {
		char[][] pixels = new char[][] {
			{ 'W', 'W', 'B', 'B' },
			{ 'B', 'W', 'W', 'B' },
			{ 'B', 'B', 'W', 'W' },
			{ 'B', 'B', 'B', 'W' }
		};
		
		char[][] swapped = ps.swap(pixels, new int[] { 0,0 }, 'R');
		assertEquals('R', swapped[0][0]);
		assertEquals('R', swapped[0][1]);
		assertEquals('R', swapped[1][1]);
		assertEquals('R', swapped[1][2]);
		assertEquals('R', swapped[2][2]);
		assertEquals('R', swapped[2][3]);
		assertEquals('R', swapped[3][3]);
	}

	/**
	 * Test method for {@link com.smt.kata.distance.PixelSwap#swap(char[][], int[], char)}.
	 */
	@Test
	void testSwapOneMatch() throws Exception {
		char[][] pixels = new char[][] {
			{ 'B', 'B', 'B', 'B' },
			{ 'B', 'B', 'B', 'B' },
			{ 'B', 'B', 'B', 'B' },
			{ 'B', 'B', 'B', 'W' }
		};
		
		char[][] swapped = ps.swap(pixels, new int[] { 3,3 }, 'R');
		assertEquals('R', swapped[3][3]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.PixelSwap#swap(char[][], int[], char)}.
	 */
	@Test
	void testSwapBackwardStairs() throws Exception {
		char[][] pixels = new char[][] {
			{ 'W', 'W', 'B', 'B' },
			{ 'B', 'W', 'W', 'B' },
			{ 'B', 'B', 'W', 'W' },
			{ 'B', 'B', 'B', 'W' }
		};
		
		char[][] swapped = ps.swap(pixels, new int[] { 3,3 }, 'R');
		assertEquals('R', swapped[0][0]);
		assertEquals('R', swapped[0][1]);
		assertEquals('R', swapped[1][1]);
		assertEquals('R', swapped[1][2]);
		assertEquals('R', swapped[2][2]);
		assertEquals('R', swapped[2][3]);
		assertEquals('R', swapped[3][3]);
	}
}
