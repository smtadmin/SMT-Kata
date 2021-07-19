package com.smt.kata.object;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// JDK 11.x
import java.util.Map;

/****************************************************************************
 <b>Title</b>: JsonParserTest.java
 <b>Project</b>: SMT-Kata
 <b>Description: </b> CHANGE ME!!
 <b>Copyright:</b> Copyright (c) 2021
 <b>Company:</b> Silicon Mountain Technologies
 
 @author James Camire
 @version 3.0
 @since Jul 19, 2021
 @updates:
 ****************************************************************************/
class JsonParserTest {
	// Members
	JsonParser jp = new JsonParser();
	StringBuilder json;
	StringBuilder jsonAllRoot;
	StringBuilder jsonStringValues;
	
	@BeforeEach
	void init() {
		json = new StringBuilder();
		json.append("{ \n");
		json.append("\t'key': 3, \n");
		json.append("\t'foo': { \n");
		json.append("\t\t'a': 5, \n");
		json.append("\t\t'bar': { \n");
		json.append("\t\t\t'baz': 8 \n");
		json.append("\t\t} \n");
		json.append("\t} \n");
		json.append("} \n");
		
		jsonAllRoot = new StringBuilder();
		jsonAllRoot.append("{ \n");
		jsonAllRoot.append("\t'key': 1, \n");
		jsonAllRoot.append("\t'foo': 2, \n");
		jsonAllRoot.append("\t'bar': 3, \n");
		jsonAllRoot.append("} \n");
		
		jsonStringValues = new StringBuilder();
		jsonStringValues.append("{ \n");
		jsonStringValues.append("\t'key': { \n");
		jsonStringValues.append("\t\t'foo': { \n");
		jsonStringValues.append("\t\t\t'bar': { \n");
		jsonStringValues.append("\t\t\t\t'name': 'SMT' \n");
		jsonStringValues.append("\t\t\t} \n");
		jsonStringValues.append("\t\t} \n");
		jsonStringValues.append("\t} \n");
		jsonStringValues.append("} \n");
	}
	
	/**
	 Test method for {@link com.smt.kata.object.JsonParser#parse(java.lang.String)}.
	 */
	@Test
	void testParseNull() throws Exception {
		Map<String, Object> response = jp.parse(null);
		assertEquals(0, response.size());
	}
	
	/**
	 Test method for {@link com.smt.kata.object.JsonParser#parse(java.lang.String)}.
	 */
	@Test
	void testParseEmpty() throws Exception {
		Map<String, Object> response = jp.parse("");
		assertEquals(0, response.size());
	}
	
	/**
	 Test method for {@link com.smt.kata.object.JsonParser#parse(java.lang.String)}.
	 */
	@Test
	void testParse() throws Exception {
		Map<String, Object> response = jp.parse(json.toString());
		assertEquals(3, response.get("key"));
		assertEquals(5, response.get("foo.a"));
		assertEquals(8, response.get("foo.bar.baz"));
	}
	
	/**
	 Test method for {@link com.smt.kata.object.JsonParser#parse(java.lang.String)}.
	 */
	@Test
	void testParseAllRoot() throws Exception {
		Map<String, Object> response = jp.parse(jsonAllRoot.toString());
		assertEquals(1, response.get("key"));
		assertEquals(2, response.get("foo"));
		assertEquals(3, response.get("bar"));
	}
	
	/**
	 Test method for {@link com.smt.kata.object.JsonParser#parse(java.lang.String)}.
	 */
	@Test
	void testParseDepthString() throws Exception {
		Map<String, Object> response = jp.parse(jsonStringValues.toString());
		assertEquals("SMT", response.get("key.foo.bar.name"));
	}

}
