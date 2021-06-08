package com.smt.kata.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.siliconmtn.data.bean.GenericVO;

/****************************************************************************
 * <b>Title:</b> RifflerTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 29, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class RifflerTest {
	
	// Members
	private Riffler r = new Riffler();

	/**
	 * Test method for {@link com.smt.kata.data.Riffler#riffle(char[], char[])}.
	 */
	@Test
	void testRiffle() throws Exception {
		char[] res = r.riffle(new char[] {'a','b','c'}, new char[] {'1','2','3'});
		char[] correct = new char[] {'a','1','b','2','c','3'};
		for (int i=0; i < correct.length; i++) {
			assertEquals(correct[i], res[i]);
		}
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.Riffler#riffle(char[], char[])}.
	 */
	@Test
	void testRiffleInvalid() throws Exception {
		assertEquals(0, r.riffle(null,  null).length);
		assertEquals(0, r.riffle(new char[1],  new char[2]).length);
		assertEquals(0, r.riffle(new char[4],  new char[2]).length);
		assertEquals(0, r.riffle(new char[4],  null).length);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.Riffler#riffle(char[], char[])}.
	 */
	@Test
	void testRiffleUneven() throws Exception {
		char[] res = r.riffle(new char[] {'1','3','5'}, new char[] {'2','4'});
		char[] correct = new char[] {'1','2','3','4','5'};
		for (int i=0; i < correct.length; i++) {
			assertEquals(correct[i], res[i]);
		}
	}

	/**
	 * Test method for {@link com.smt.kata.data.Riffler#deriffle(char[])}.
	 */
	@Test
	void testDeriffle() throws Exception {
		GenericVO res = r.deriffle(new char[] {'a','1','b','2','c'});
		char[] src = (char[])res.getKey();
		char[] dest = (char[])res.getValue();
		assertEquals(3, src.length);
		assertEquals(2, dest.length);
		
		assertEquals('a', src[0]);
		assertEquals('b', src[1]);
		assertEquals('c', src[2]);
		
		assertEquals('1', dest[0]);
		assertEquals('2', dest[1]);
	}

}
