package com.smt.kata.word;

//Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: CompressStringTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tewsts the compress string kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 5, 2021
 * @updates:
 ****************************************************************************/
public class CompressStringTest {

	@Test
	void testCompress() throws Exception {
		CompressString cs = new CompressString();
        assertEquals("A3BCCD4LL", cs.compress("AAABCCDDDDLL"));
        assertEquals("A3BCCD4L", cs.compress("AAABCCDDDDL")); 
        assertEquals("J4A5ME4S7", cs.compress("JJJJAAAAAMEEEESSSSSSS")); 
        assertEquals("MARY", cs.compress("MARY"));
        assertEquals("HELLO 5WORLD", cs.compress("HELLO     WORLD"));
        assertEquals(" 3H3 3O3", cs.compress("   HHH   OOO"));
	}

}
