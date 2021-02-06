package com.smt.kata.data;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: QueryStringParserTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
class QueryStringParserTest {

	/**
	 * Test method for {@link com.smt.kata.data.QueryStringParser#parseString(java.lang.String)}.
	 */
	@Test
	void testParseString() {
		QueryStringParser qsp = new QueryStringParser();
		Map<String, List<String>> params = qsp.parseString("name=james");
		assertEquals(1, params.size());
		assertEquals("james", params.get("name").get(0));
		
		params = qsp.parseString("name=james%26mary&business=smt+company");
		assertEquals(2, params.size());
		assertEquals("smt company", params.get("business").get(0));
		
		params = qsp.parseString("name=james%26mary%20camire&business=smt+company&type=");
		assertEquals(3, params.size());
		assertEquals("", params.get("type").get(0));
		
		params = qsp.parseString("name=james%26mary%20camire&business=smt+company&type=&name=Mike");
		assertEquals(3, params.size());
		assertEquals("Mike", params.get("name").get(1));
		
		params = qsp.parseString("business=smt%3drules&");
		assertEquals(1, params.size());
		assertEquals("smt=rules", params.get("business").get(0));
	}

}
