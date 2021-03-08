package com.smt.kata.word;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: ArrangeWordTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the Arrange Word class.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 6, 2021
 * @updates:
 ****************************************************************************/
class ArrangeWordTest {

	/**
	 * Test method for {@link com.smt.kata.word.ArrangeWord#getPermutations(java.lang.String)}.
	 */
	@Test
	void testGetPermutations() {
		ArrangeWord aw = new ArrangeWord();
		
		// Evaluate simple word
		List<String> permutations = aw.getPermutations("god");
		System.out.println(permutations);
		assertEquals(6, permutations.size());
		assertTrue(permutations.contains("odg"));
		assertTrue(permutations.contains("dog"));
		
		// Evaluate empty case
		permutations = aw.getPermutations(null);
		assertEquals(0, permutations.size());
		
		// Evaluate single letter
		permutations = aw.getPermutations("a");
		assertEquals(1, permutations.size());
		
		// Evaluate long word
		permutations = aw.getPermutations("evaluation");
		assertEquals(3628800, permutations.size());
		assertTrue(permutations.contains("noitaulave"));
		assertFalse(permutations.contains("val"));
	}

}
