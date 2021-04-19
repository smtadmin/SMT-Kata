package com.smt.kata.data;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: PatternDecoderTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 1, 2021
 * @updates:
 ****************************************************************************/
public class PatternDecoderTest {
	
	// Members
	Map<String, List<String>> patterns;
	PatternDecoder pd = new PatternDecoder();
	
	@BeforeEach
	void setUpBeforeEach() throws Exception {
		patterns = new LinkedHashMap<>();
		patterns.put("111", Arrays.asList("aaa", "ka", "ak"));
		patterns.put(null, new ArrayList<>());
		patterns.put("111d", new ArrayList<>());
		patterns.put("444", Arrays.asList("ddd"));
		patterns.put("414", Arrays.asList("dad", "dn"));
		patterns.put("6666", Arrays.asList("ffff"));
	}

	/**
	 * Tests that the decode pattern successfully tests the problem domain
	 */
	@Test
	void testDecodePattern() {
		//assertNotNull(pd.decodePattern(null));
		for (Map.Entry<String, List<String>> entry : patterns.entrySet()) {
			List<String> results = entry.getValue();
			List<String> matching = pd.decodePattern(entry.getKey());

			assertEquals(results.size(), matching.size());
			for (String pattern : matching) {
				assertTrue(results.contains(pattern));
			}
		}
	}

}
