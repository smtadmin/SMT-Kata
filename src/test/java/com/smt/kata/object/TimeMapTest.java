package com.smt.kata.object;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> TimeMapTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Unit test for the TimeMap Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 14, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class TimeMapTest {
	
	TimeMap<Integer, Integer> tm;
	TimeMap<String, String> tmStr;
	
	@BeforeEach
	void init() {
		tm = new TimeMap<>();
		tmStr = new TimeMap<>();
	}

	/**
	 * Test method for {@link com.smt.kata.object.TimeMap#size()}.
	 */
	@Test
	void testSize() throws Exception {
		assertEquals(0, tm.size());
	}

	/**
	 * Test method for {@link com.smt.kata.object.TimeMap#set(java.lang.Object, java.lang.Object, int)}.
	 */
	@Test
	void testSet() throws Exception {
		tm.set(1, 3, 0);
		assertEquals(1, tm.size());
		assertEquals(3, tm.get(1, 0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.TimeMap#set(java.lang.Object, java.lang.Object, int)}.
	 */
	@Test
	void testSame() throws Exception {
		tm.set(1, 1, 0);
		tm.set(1, 2, 0);
		assertEquals(2, tm.get(1, 0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.TimeMap#set(java.lang.Object, java.lang.Object, int)}.
	 */
	@Test
	void testSetEmpty() throws Exception {
		tm.set(null, null, 0);
		assertEquals(1, tm.size());
		assertEquals(null, tm.get(null, 0));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.TimeMap#set(java.lang.Object, java.lang.Object, int)}.
	 */
	@Test
	void testSetNull() throws Exception {
		assertEquals(0, tm.size());
		assertEquals(null, tm.get(3, 0));
	}

	/**
	 * Test method for {@link com.smt.kata.object.TimeMap#set(java.lang.Object, java.lang.Object, int)}.
	 */
	@Test
	void testSetDiffTime() throws Exception {
		tm.set(1, 3, 1);
		tm.set(1, 5, 2);
		assertEquals(2, tm.size());
		assertEquals(5, tm.get(1, 2));
		assertEquals(5, tm.get(1, 3));
		assertEquals(3, tm.get(1, 1));
		assertEquals(5, tm.get(1, 7));
		assertEquals(null, tm.get(2, 7));
	}

	/**
	 * Test method for {@link com.smt.kata.object.TimeMap#set(java.lang.Object, java.lang.Object, int)}.
	 */
	@Test
	void testSetLarge() throws Exception {
		
		for (int i = 0; i < 17; i++) {
			tm.set(i, 12, i);
		}
		
		assertEquals(17, tm.size());
		assertEquals(null, tm.get(24,  2));
	}
	
	/**
	 * Test method for {@link com.smt.kata.object.TimeMap#set(java.lang.Object, java.lang.Object, int)}.
	 */
	@Test
	void testSetString() throws Exception {
		tmStr.set("hello", "World", 1);
		assertEquals(1, tmStr.size());
		assertEquals("World", tmStr.get("hello", 1));
	}

	/**
	 * Test method for {@link com.smt.kata.object.TimeMap#toString()}.
	 */
	@Test
	void testToString() throws Exception {
		tmStr.set("hello", "World", 1);
		assertEquals("hello|World|1", tmStr.get(0).toString());
		assertEquals(null, tmStr.get(100));
	}

}
