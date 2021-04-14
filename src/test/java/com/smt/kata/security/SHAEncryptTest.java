package com.smt.kata.security;

// Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title:</b> SHA256EncryptTest.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Tests the SHA256Encrpt Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 24, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
class SHAEncryptTest {
	
	// Members
	private SHAEncrypt enc = new SHAEncrypt();

	/**
	 * Test method for {@link com.smt.kata.security.SHAEncrypt#SHA256Encrypt()}.
	 */
	@Test
	void testSHA256Encrypt() throws Exception {
		assertNotNull(enc);
	}

	/**
	 * Test method for {@link com.smt.kata.security.SHAEncrypt#encrypt(java.lang.String)}.
	 */
	@Test
	void testEncrypt() throws Exception {
		assertEquals("872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4", enc.encrypt("HelloWorld"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.SHAEncrypt#encrypt(java.lang.String)}.
	 */
	@Test
	void testEncrypt512() throws Exception {
		SHAEncrypt enc512 = new SHAEncrypt("SHA-512");
		assertEquals("8ae6ae71a75d3fb2e0225deeb004faf95d816a0a58093eb4cb5a3aa0f197050d7a4dc0a2d5c6fbae5fb5b0d536a0a9e6b686369fa57a027687c3630321547596", enc512.encrypt("HelloWorld"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.SHAEncrypt#encrypt(java.lang.String)}.
	 */
	@Test
	void testEncryptNull() throws Exception {
		assertThrows(NullPointerException.class, () -> enc.encrypt(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.SHAEncrypt#encrypt(java.lang.String)}.
	 */
	@Test
	void testEncryptBadType() throws Exception {
		SHAEncrypt encBad = new SHAEncrypt("BAD_TYPE");
		assertThrows(NoSuchAlgorithmException.class, () -> encBad.encrypt("EncryptMe"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.SHAEncrypt#encrypt(java.lang.String)}.
	 */
	@Test
	void testEncryptEmpty() throws Exception {
		assertEquals("e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855", enc.encrypt(""));
	}
	
	/**
	 * Test method for {@link com.smt.kata.security.SHAEncrypt#encrypt(java.lang.String)}.
	 */
	@Test
	void testEncryptJava() throws Exception {
		assertEquals("f1d5f8d75bb55c777207c251d07d9091dc10fe7d6682db869106aacb4b7df678", enc.encrypt("Javarmi123"));
	}

	/**
	 * Test method for {@link com.smt.kata.security.SHAEncrypt#encrypt(java.lang.String)}.
	 */
	@Test
	void testEncryptSpecial() throws Exception {
		assertEquals("c97bb1ef84a907230227181ce72fdffdb9127581151039eac121c3437daf8c40", enc.encrypt("Th1s&That!"));
	}
}
