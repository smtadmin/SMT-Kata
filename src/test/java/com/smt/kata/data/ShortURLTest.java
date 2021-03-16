package com.smt.kata.data;

//Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: ShortURLTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 3, 2021
 * @updates:
 ****************************************************************************/
class ShortURLTest {
	
	// Members
	private ShortURL sUrl = new ShortURL();

	/**
	 * Test method for {@link com.smt.kata.data.ShortURL#ShortURL()}.
	 */
	@Test
	void testShortURL() throws Exception {
		assertNotNull(sUrl);
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.ShortURL#shortenUrl(java.lang.String, int)}.
	 */
	@Test
	void testShortenUrlNull() throws Exception {
		assertNull(sUrl.shortenUrl(null, 6));
	}

	/**
	 * Test method for {@link com.smt.kata.data.ShortURL#shortenUrl(java.lang.String, int)}.
	 */
	@Test
	void testShortenUrlShort() throws Exception {
		assertNull(sUrl.shortenUrl("http://www.smt.com", 3));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.ShortURL#shortenUrl(java.lang.String, int)}.
	 */
	@Test
	void testShortenUrlRestore() throws Exception {
		String shortUrl = sUrl.shortenUrl("http://www.siliconmtn.com", 6);
		assertEquals(6, shortUrl.length());
		assertEquals("http://www.siliconmtn.com", sUrl.restore(shortUrl));
	}

	/**
	 * Test method for {@link com.smt.kata.data.ShortURL#shortenUrl(java.lang.String, int)}.
	 */
	@Test
	void testShortenUrlRestore1() throws Exception {
		String shortUrl = sUrl.shortenUrl("http://www.columbiad.com?this=that&name=SMT", 15);
		assertEquals(15, shortUrl.length());
		assertEquals("http://www.columbiad.com?this=that&name=SMT", sUrl.restore(shortUrl));
	}

}
