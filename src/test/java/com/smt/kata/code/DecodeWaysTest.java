package com.smt.kata.code;

// JDK 11.x
import java.util.List;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: DecodeWaysTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Decode Ways Kata Unit Test
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
class DecodeWaysTest {
	
	// Members
	DecodeWays dw = new DecodeWays();
	
	/**
	 * Test method for {@link com.smt.kata.code.DecodeWays#encode(java.lang.String)}.
	 */
	@Test
	void testEncodeNull() throws Exception {
		List<String> codes = dw.encode(null);
		assertEquals(0, codes.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DecodeWays#encode(java.lang.String)}.
	 */
	@Test
	void testEncodeEmpty() throws Exception {
		List<String> codes = dw.encode("");
		assertEquals(0, codes.size());
	}

	/**
	 * Test method for {@link com.smt.kata.code.DecodeWays#encode(java.lang.String)}.
	 */
	@Test
	void testEncodeDual() throws Exception {
		List<String> codes = dw.encode("11106");
		assertEquals(2, codes.size());
		assertTrue(codes.contains("KJF"));
		assertTrue(codes.contains("AAJF"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DecodeWays#encode(java.lang.String)}.
	 */
	@Test
	void testEncodeTwelve() throws Exception {
		List<String> codes = dw.encode("12");
		assertEquals(2, codes.size());
		assertTrue(codes.contains("AB"));
		assertTrue(codes.contains("L"));
	}

	/**
	 * Test method for {@link com.smt.kata.code.DecodeWays#encode(java.lang.String)}.
	 */
	@Test
	void testEncode226() throws Exception {
		List<String> codes = dw.encode("226");
		assertEquals(3, codes.size());
		assertTrue(codes.contains("BZ"));
		assertTrue(codes.contains("VF"));
		assertTrue(codes.contains("BBF"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DecodeWays#encode(java.lang.String)}.
	 */
	@Test
	void testEncodeCrazy() throws Exception {
		List<String> codes = dw.encode("134567226");
		System.out.println(codes);
		assertEquals(6, codes.size());
		assertTrue(codes.contains("MDEFGVF"));
		assertTrue(codes.contains("MDEFGBZ"));
		assertTrue(codes.contains("MDEFGBBF"));
		assertTrue(codes.contains("ACDEFGVF"));
		assertTrue(codes.contains("ACDEFGBZ"));
		assertTrue(codes.contains("ACDEFGBBF"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DecodeWays#encode(java.lang.String)}.
	 */
	@Test
	void testEncodeZero() throws Exception {
		List<String> codes = dw.encode("0");
		assertEquals(0, codes.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.code.DecodeWays#encode(java.lang.String)}.
	 */
	@Test
	void testEncodeZeroSix() throws Exception {
		List<String> codes = dw.encode("06");
		assertEquals(0, codes.size());
	}
}
