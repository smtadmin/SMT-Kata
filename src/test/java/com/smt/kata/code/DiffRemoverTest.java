package com.smt.kata.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DiffRemoverTest {

	private DiffRemover dr = new DiffRemover();

	/**
	 * Test method for {@link com.smt.kata.code.AnagramIndices#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void bothInputNull() throws Exception {
		int[] diff = dr.deDiff(null, null);
		assertEquals(0, diff.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.AnagramIndices#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void removeNull() throws Exception {
		int [] master = new int[]{1,2,3};
		int[] diff = dr.deDiff(master, null);
		assertEquals(3, diff.length);
		assertEquals(diff[0], master[0]);
		assertEquals(diff[1], master[1]);
		assertEquals(diff[2], master[2]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.AnagramIndices#find(java.lang.String, java.lang.String)}.
	 */
	@Test
	void masterNull() throws Exception {
		int[] diff = dr.deDiff(null, new int[]{1,2,3});
		assertEquals(0, diff.length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DiamondGenerate#generateDiamond(java.lang.Character)}.
	 */
	@Test
	void removeDiff1() throws Exception {
		int[] diff = dr.deDiff(new int[]{1,2,3}, new int[]{1});
		assertEquals(2, diff.length);
		assertEquals(diff[0], 2);
		assertEquals(diff[1], 3);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DiamondGenerate#generateDiamond(java.lang.Character)}.
	 */
	@Test
	void removeDiff2UnOrdered() throws Exception {
		int[] diff = dr.deDiff(new int[]{1,3,2}, new int[]{1});
		assertEquals(2, diff.length);
		assertEquals(diff[0], 2);
		assertEquals(diff[1], 3);
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DiamondGenerate#generateDiamond(java.lang.Character)}.
	 */
	@Test
	void removeDiffDuplicates() throws Exception {
		int[] diff = dr.deDiff(new int[]{1,1,1,1,3,2}, new int[]{1});
		assertEquals(2, diff.length);
		assertEquals(diff[0], 2);
		assertEquals(diff[1], 3);
	}
	/**
	 * Test method for {@link com.smt.kata.code.DiamondGenerate#generateDiamond(java.lang.Character)}.
	 */
	@Test
	void removeDiffDuplicatesMixed() throws Exception {
		int[] diff = dr.deDiff(new int[]{1,2,1,3,1,3,2,1}, new int[]{1});
		assertEquals(4, diff.length);
		assertEquals(diff[0], 2);
		assertEquals(diff[1], 2);
		assertEquals(diff[2], 3);
		assertEquals(diff[3], 3);
	}
}
