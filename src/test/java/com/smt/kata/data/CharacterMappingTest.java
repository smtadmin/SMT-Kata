package com.smt.kata.data;

// JDK 11.x
import java.io.InvalidObjectException;
import java.util.HashMap;
import java.util.Map;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> CharacterMappingTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Tests the CharacterMapping Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 29, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class CharacterMappingTest {

	/**
	 * Test method for {@link com.smt.kata.data.CharacterMapping#CharacterMapping(java.util.Map)}.
	 */
	@Test
	void testCharacterMapping() throws Exception {
		assertThrows(InvalidObjectException.class, () -> new CharacterMapping(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.CharacterMapping#CharacterMapping(java.util.Map)}.
	 */
	@Test
	void testCharacterMappingEmpty() throws Exception {
		assertThrows(InvalidObjectException.class, () -> new CharacterMapping(new HashMap<>()));
	}

	/**
	 * Test method for {@link com.smt.kata.data.CharacterMapping#add(java.lang.Integer[])}.
	 */
	@Test
	void testAdd() throws Exception {
		Map<Integer, char[]> data = new HashMap<>();
		data.put(Integer.valueOf(1), new char[] {'A', 'B', 'C'});
		data.put(Integer.valueOf(2), new char[] {'D', 'E', 'F'});
		data.put(Integer.valueOf(2), new char[] {'G', 'H', 'I'});
		data.put(Integer.valueOf(2), new char[] {'J', 'K', 'L'});
		
		CharacterMapping cm = new CharacterMapping(data);
		String[] results = cm.add(new int[] {1, 2});
		
		assertEquals(3, results.length);
		assertEquals("AJ", results[0]);
		assertEquals("BK", results[1]);
		assertEquals("CL", results[2]);
	}

	/**
	 * Test method for {@link com.smt.kata.data.CharacterMapping#add(java.lang.Integer[])}.
	 */
	@Test
	void testAddMixed() throws Exception {
		Map<Integer, char[]> data = new HashMap<>();
		data.put(Integer.valueOf(1), new char[] {'A', 'B', 'C'});
		data.put(Integer.valueOf(2), new char[] {'D', 'E', 'F'});
		data.put(Integer.valueOf(3), new char[] {'G', 'H', 'I', 'J', 'K', 'L'});
		
		CharacterMapping cm = new CharacterMapping(data);
		String[] results = cm.add(new int[] {1, 2});
		
		assertEquals(3, results.length);
		assertEquals("AD", results[0]);
		assertEquals("BE", results[1]);
		assertEquals("CF", results[2]);

	}
	
	/**
	 * Test method for {@link com.smt.kata.data.CharacterMapping#add(java.lang.Integer[])}.
	 */
	@Test
	void testAddMixed2() throws Exception {
		Map<Integer, char[]> data = new HashMap<>();
		data.put(Integer.valueOf(1), new char[] {'A', 'B', 'C'});
		data.put(Integer.valueOf(2), new char[] {'D', 'E', 'F'});
		data.put(Integer.valueOf(3), new char[] {'G', 'H', 'I', 'J', 'K', 'L'});
		
		CharacterMapping cm = new CharacterMapping(data);
		String[] results = cm.add(new int[] {1, 2, 3});
		
		assertEquals(6, results.length);
		assertEquals("ADG", results[0]);
		assertEquals("BEH", results[1]);
		assertEquals("CFI", results[2]);
		assertEquals("L", results[5]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.CharacterMapping#add(java.lang.Integer[])}.
	 */
	@Test
	void testAddNull() throws Exception {
		Map<Integer, char[]> data = new HashMap<>();
		data.put(Integer.valueOf(1), new char[] {'A', 'B', 'C'});
		data.put(Integer.valueOf(2), null);
		data.put(Integer.valueOf(3), new char[] {'G', 'H', 'I'});
		
		CharacterMapping cm = new CharacterMapping(data);
		String[] results = cm.add(new int[] {1, 2, 3});
		
		assertEquals(3, results.length);
		assertEquals("AG", results[0]);
		assertEquals("BH", results[1]);
		assertEquals("CI", results[2]);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.CharacterMapping#add(java.lang.Integer[])}.
	 */
	@Test
	void testAddAllNull() throws Exception {
		Map<Integer, char[]> data = new HashMap<>();
		data.put(Integer.valueOf(1), null);
		data.put(Integer.valueOf(2), null);
		data.put(Integer.valueOf(3), null);
		
		CharacterMapping cm = new CharacterMapping(data);
		String[] results = cm.add(new int[] {1, 2, 3});
		
		assertEquals(0, results.length);
	}
}
