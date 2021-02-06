package com.smt.kata.word;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: MirrorAlphabetTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the MirrorAplphabet Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class MirrorAlphabetTest {

	/**
	 * Test method for {@link com.smt.kata.word.MirrorAlphabet#getMagicList()}.
	 * @throws IOException 
	 */
	@Test
	void testGetMagicList() throws IOException {
		MirrorAlphabet ma = new MirrorAlphabet();
		List<String> wordList = ma.getMagicList();
		assertTrue(wordList.contains("Babbitry"));
		assertTrue(wordList.contains("Issayeff"));
		assertTrue(wordList.contains("maharaj"));
		assertTrue(wordList.contains("Pablum"));
		assertTrue(wordList.contains("UNISTAR"));

	}
	
	/**
	 * Test method for {@link com.smt.kata.word.MirrorAlphabet#getMagicList()}.
	 */
	@Test
	void testGetMagicListEmpty() {
		MirrorAlphabet ma = new MirrorAlphabet(new String[]{"Anaconda", "Bathtub", "Comic"});
		List<String> wordList = ma.getMagicList();
		assertTrue(wordList.isEmpty());

	}

}
