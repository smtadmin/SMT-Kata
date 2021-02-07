package com.smt.kata.object;

// Junti 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SingleMindedTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 7, 2021
 * @updates:
 ****************************************************************************/
class SingleMindedTest {

	/**
	 * Test method for {@link com.smt.kata.object.SingleMinded#getInstance()}.
	 */
	@Test
	void testGetInstance() {
		SingleMinded sm = SingleMinded.getInstance();
		assertEquals(0, sm.getConfig().size());
		sm.addConfigItem("name", "SMT");
		sm.addConfigItem("city", "Denver");
		sm.addConfigItem("bad_entry", "remove me");
		sm.removeConfigItem("bad_entry");
		assertEquals(2, sm.getConfig().size());
		
		
		SingleMinded sm1 = SingleMinded.getInstance();
		assertEquals(2, sm1.getConfig().size());
		assertEquals("SMT", sm1.getConfigItem("name"));
		assertEquals("Denver", sm1.getConfigItem("city"));
	}

}
