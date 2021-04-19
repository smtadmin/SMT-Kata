package com.smt.kata.data;

// Junit 5
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: TagParserTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the TagParser Kata class
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 27, 2021
 * @updates:
 ****************************************************************************/
class TagParserTest {
	
	// Members
	private TagParser tp = new TagParser();

	/**
	 * Test method for {@link com.smt.kata.data.TagParser#TagParser()}.
	 */
	@Test
	void testTagParser() throws Exception {
		TagParser tp = new TagParser();
		assertNotNull(tp);
	}

	/**
	 * Test method for {@link com.smt.kata.data.TagParser#evaluateTags(java.lang.String)}.
	 */
	@Test
	void testEvaluateTagsNull() throws Exception {
		assertEquals(0, tp.evaluateTags(null).size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.TagParser#evaluateTags(java.lang.String)}.
	 */
	@Test
	void testEvaluateTagsNoTag() throws Exception {
		List<String> tags = tp.evaluateTags("This is a test");
		assertEquals(0, tags.size());

		tags = tp.evaluateTags("<h2 This is a test");
		assertEquals(0, tags.size());

		tags = tp.evaluateTags("<h2> This is a test");
		assertEquals(0, tags.size());
		
		tags = tp.evaluateTags("<h2 This is a test</h2>");
		assertEquals(0, tags.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.TagParser#evaluateTags(java.lang.String)}.
	 */
	@Test
	void testEvaluateTagsSimples() throws Exception {
		assertEquals(1, tp.evaluateTags("<h1>Hello World</h1>").size());
		assertEquals("<h1>Hello World</h1>", tp.evaluateTags("<h1>Hello World</h1>").get(0));
	}

	/**
	 * Test method for {@link com.smt.kata.data.TagParser#evaluateTags(java.lang.String)}.
	 */
	@Test
	void testEvaluateTagsDouble() throws Exception {
		List<String> tags = tp.evaluateTags("<h1>Hello World</h1><div>Another Tag</div>");
		assertEquals(2, tags.size());
		assertEquals("<h1>Hello World</h1>", tags.get(0));
		assertEquals("<div>Another Tag</div>", tags.get(1));
	}
	
	/**
	 * Test method for {@link com.smt.kata.data.TagParser#evaluateTags(java.lang.String)}.
	 */
	@Test
	void testEvaluateTagsInner() throws Exception {
		List<String> tags = tp.evaluateTags("<div><span>Another Tag</span><b>Hello World</b></div>");
		assertEquals(3, tags.size());
		assertEquals("<div><span>Another Tag</span><b>Hello World</b></div>", tags.get(0));
		assertEquals("<span>Another Tag</span>", tags.get(1));
		assertEquals("<b>Hello World</b>", tags.get(2));
	}
}
