package com.smt.kata.word;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;
import org.junit.jupiter.api.Test;

import com.siliconmtn.data.bean.GenericVO;
import com.smt.kata.word.RepeatCounter.MyBean;

/****************************************************************************
 * <b>Title</b>: RepeatCounterTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 28, 2021
 * @updates:
 ****************************************************************************/
class RepeatCounterTest {
	// Members
	RepeatCounter rc = new RepeatCounter();
	
	/**
	 * Test method for {@link com.smt.kata.word.RepeatCounter#calculate(java.lang.Object[])}.
	 */
	@Test
	void testCalculateNull() throws Exception {
		Map<Object, Integer> data = rc.calculate(null);
		assertEquals(0, data.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.RepeatCounter#calculate(java.lang.Object[])}.
	 */
	@Test
	void testCalculateEmpty() throws Exception {
		Map<Object, Integer> data = rc.calculate(new String[] {});
		assertEquals(0, data.size());
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.RepeatCounter#calculate(java.lang.Object[])}.
	 */
	@Test
	void testCalculate() throws Exception {
		Map<Object, Integer> data = rc.calculate(new String[] {"cat", "dog", "cat", "cow", "cow", "cow"});
		
		assertEquals(3, data.get("cow"));
		assertEquals(2, data.get("cat"));
		assertEquals(1, data.get("dog"));
	}

	/**
	 * Test method for {@link com.smt.kata.word.RepeatCounter#calculate(java.lang.Object[])}.
	 */
	@Test
	void testCalculateWithNulls() throws Exception {
		Map<Object, Integer> data = rc.calculate(new String[] {"cat", null, "cat", "cow", null, "cow"});
		
		assertEquals(2, data.get("cow"));
		assertEquals(2, data.get("cat"));
		assertEquals(2, data.get(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.RepeatCounter#calculate(java.lang.Object[])}.
	 */
	@Test
	void testCalculateWithNumbers() throws Exception {
		Map<Object, Integer> data = rc.calculate(new Integer[] {8,6,7,5,3,0,9,8,6,7,5,3,0,9});
		
		assertEquals(2, data.get(8));
		assertEquals(2, data.get(6));
		assertEquals(2, data.get(7));
		
		assertEquals(2, data.get(5));
		assertEquals(2, data.get(3));
		assertEquals(2, data.get(0));
		assertEquals(2, data.get(9));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.RepeatCounter#calculate(java.lang.Object[])}.
	 */
	@Test
	void testCalculateWithGenerics() throws Exception {
		Map<Object, Integer> data = rc.calculate(new GenericVO[] {
			new GenericVO("one", "two"),
			new GenericVO("one", "two"),
			new GenericVO("one", "two"),
			new GenericVO("one", "two"),
			new GenericVO("three", "four"),
			new GenericVO("five", "six"),
			new GenericVO("", "")
		});
		
		assertEquals(4, data.get(new GenericVO("one", "two")));
		assertEquals(1, data.get(new GenericVO("three", "four")));
		assertEquals(1, data.get(new GenericVO("five", "six")));
		assertEquals(1, data.get(new GenericVO("", "")));
	}
	
	/**
	 * Test method for {@link com.smt.kata.word.RepeatCounter#calculate(java.lang.Object[])}.
	 */
	@Test
	void testCalculateWithMyBean() throws Exception {
		Map<Object, Integer> data = rc.calculate(new MyBean[] {
			rc.new MyBean("one", "two"),
			rc.new MyBean("one", "two"),
			rc.new MyBean("one", "two"),
			rc.new MyBean("one", "two"),
			rc.new MyBean("three", "four"),
			rc.new MyBean("five", "six"),
			rc.new MyBean("", "")
		});
		
		assertEquals(4, data.get(rc.new MyBean("one", "two")));
		assertEquals(1, data.get(rc.new MyBean("three", "four")));
		assertEquals(1, data.get(rc.new MyBean("five", "six")));
		assertEquals(1, data.get(rc.new MyBean("", "")));
	}
}
