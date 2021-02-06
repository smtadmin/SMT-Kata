package com.smt.kata.word;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: WordSplitTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> test of the WordSplit Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 3, 2021
 * @updates:
 ****************************************************************************/
class WordSplitTest {

	@Test
	void test() {
		WordSplit ws = new WordSplit();
		assertNotNull(ws);
	}
}
