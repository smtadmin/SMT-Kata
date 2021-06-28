package com.smt.kata.tree;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

// Junit 5
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/****************************************************************************
 * <b>Title</b>: LongestTreePathTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit test for the Longest Tree Path Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 24, 2021
 * @updates:
 ****************************************************************************/
class LongestTreePathTest {
	
	// Members
	LongestTreePath ltp = new LongestTreePath();

	/**
	 * Test method for {@link com.smt.kata.tree.LongestTreePath#caclculatePath(java.util.List)}.
	 */
	@Test
	void testCaclculatePathEmpty() throws Exception {
		List<KataNode<Integer>> nodes = new ArrayList<>();
		assertEquals(0, ltp.caclculatePath(nodes));
 	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.LongestTreePath#caclculatePath(java.util.List)}.
	 */
	@Test
	void testCaclculatePathNull() throws Exception {
		assertEquals(0, ltp.caclculatePath(null));
 	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.LongestTreePath#caclculatePath(java.util.List)}.
	 */
	@Test
	void testCaclculatePathRootOnly() throws Exception {
		List<KataNode<Integer>> nodes = new ArrayList<>();
		String rootId = null;
		nodes.add(new KataNode<Integer>("a", rootId, Integer.valueOf(0)));
		
		assertEquals(0, ltp.caclculatePath(nodes));
 	}
	
	
	/**
	 * Test method for {@link com.smt.kata.tree.LongestTreePath#caclculatePath(java.util.List)}.
	 */
	@Test
	void testCaclculatePathSeventeen() throws Exception {
		List<KataNode<Integer>> nodes = new ArrayList<>();
		String rootId = null;
		nodes.add(new KataNode<Integer>("a", rootId, Integer.valueOf(0)));
		nodes.add(new KataNode<Integer>("b", "a", Integer.valueOf(3)));
		nodes.add(new KataNode<Integer>("c", "a", Integer.valueOf(5)));
		nodes.add(new KataNode<Integer>("d", "a", Integer.valueOf(8)));
		nodes.add(new KataNode<Integer>("e", "d", Integer.valueOf(2)));
		nodes.add(new KataNode<Integer>("f", "d", Integer.valueOf(4)));
		nodes.add(new KataNode<Integer>("g", "e", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("h", "e", Integer.valueOf(1)));
		
		assertEquals(17, ltp.caclculatePath(nodes));
		// c -> a -> d -> f
		// 5 -> 0 -> 8 -> 4 
 	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.LongestTreePath#caclculatePath(java.util.List)}.
	 */
	@Test
	void testCaclculatePathSimple() throws Exception {
		List<KataNode<Integer>> nodes = new ArrayList<>();
		String rootId = null;
		nodes.add(new KataNode<Integer>("a", rootId, Integer.valueOf(0)));
		nodes.add(new KataNode<Integer>("b", "a", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("c", "a", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("d", "a", Integer.valueOf(1)));
		
		assertEquals(2, ltp.caclculatePath(nodes));
		// b -> a -> c
		// 0 -> 1 -> 1
 	}

	/**
	 * Test method for {@link com.smt.kata.tree.LongestTreePath#caclculatePath(java.util.List)}.
	 */
	@Test
	void testCaclculatePathDeepShort() throws Exception {
		List<KataNode<Integer>> nodes = new ArrayList<>();
		String rootId = null;
		nodes.add(new KataNode<Integer>("a", rootId, Integer.valueOf(0)));
		nodes.add(new KataNode<Integer>("b", "a", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("c", "a", Integer.valueOf(20)));
		nodes.add(new KataNode<Integer>("d", "b", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("e", "d", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("f", "e", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("g", "f", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("h", "g", Integer.valueOf(9)));
		nodes.add(new KataNode<Integer>("i", "g", Integer.valueOf(6)));
		
		assertEquals(34, ltp.caclculatePath(nodes));
		// c  -> a -> b -> d -> e -> f -> g -> h
		// 20 -> 0 -> 1 -> 1 -> 1 -> 1 -> 1 -> 9
 	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.LongestTreePath#caclculatePath(java.util.List)}.
	 */
	@Test
	void testCaclculatePathDeepLong() throws Exception {
		List<KataNode<Integer>> nodes = new ArrayList<>();
		String rootId = null;
		nodes.add(new KataNode<Integer>("a", rootId, Integer.valueOf(0)));
		nodes.add(new KataNode<Integer>("b", "a", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("d", "b", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("e", "d", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("f", "e", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("g", "f", Integer.valueOf(1)));
		nodes.add(new KataNode<Integer>("h", "g", Integer.valueOf(9)));
		nodes.add(new KataNode<Integer>("i", "g", Integer.valueOf(6)));
		
		assertEquals(16, ltp.caclculatePath(nodes));
		// h -> g -> i
		// 6 -> 9 -> 1
 	}
	
	/**
	 * Test method for {@link com.smt.kata.tree.LongestTreePath#caclculatePath(java.util.List)}.
	 */
	@Test
	void testCaclculatePathComplex() throws Exception {
		List<KataNode<Integer>> nodes = new ArrayList<>();
		String rootId = null;
		nodes.add(new KataNode<Integer>("a", rootId, Integer.valueOf(0)));
		nodes.add(new KataNode<Integer>("b", "a", Integer.valueOf(2)));
		nodes.add(new KataNode<Integer>("c", "a", Integer.valueOf(4)));
		nodes.add(new KataNode<Integer>("d", "a", Integer.valueOf(6)));
		nodes.add(new KataNode<Integer>("e", "b", Integer.valueOf(8)));
		nodes.add(new KataNode<Integer>("f", "b", Integer.valueOf(10)));
		nodes.add(new KataNode<Integer>("g", "c", Integer.valueOf(12)));
		nodes.add(new KataNode<Integer>("h", "c", Integer.valueOf(10)));
		nodes.add(new KataNode<Integer>("i", "d", Integer.valueOf(8)));
		nodes.add(new KataNode<Integer>("j", "d", Integer.valueOf(10)));
		nodes.add(new KataNode<Integer>("k", "d", Integer.valueOf(12)));
		
		assertEquals(34, ltp.caclculatePath(nodes));
		// k  -> d -> a -> c -> g
		// 12 -> 6 -> 0 -> 4 -> 12
 	}
}
