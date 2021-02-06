package com.smt.kata.code;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: ISBNTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> test case for the kata ISBN class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class ISBNTest {

	/**
	 * Test method for {@link com.smt.kata.code.ISBN#isISBN(java.lang.String)}.
	 */
	@Test
	void testIsISBN() {
		ISBN i = new ISBN();
		assertEquals(true, i.isISBN("1-84356-028-3"));
		assertEquals(true, i.isISBN("0-684-84328-5"));
		assertEquals(true, i.isISBN("0-8044-2957-X"));
		assertEquals(true, i.isISBN("0-85131-041-9"));
		assertEquals(true, i.isISBN("93-86954-21-4"));
		assertEquals(true, i.isISBN("0-943396-04-2"));
		assertEquals(false, i.isISBN("0-9752398-0-X"));
		assertEquals(false, i.isISBN("1-85121-041-9"));
	}

}
