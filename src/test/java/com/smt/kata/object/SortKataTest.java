package com.smt.kata.object;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: SortKataTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Test Class for the sort kata challenge
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 7, 2021
 * @updates:
 ****************************************************************************/
class SortKataTest {
	
	private static List<SortKata> people = new ArrayList<>();
	private static SortKata p1;
	private static SortKata p2;
	private static SortKata p3;
	private static SortKata p4;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		p1 = new SortKata();
		p1.setId("123");
		p1.setAge(21);
		p1.setName("Andy");
		people.add(p1);
		
		p2 = new SortKata();
		p2.setId("64");
		p2.setAge(35);
		p2.setName("Mary");
		people.add(p2);
		
		p3 = new SortKata();
		p3.setId("112345");
		p3.setAge(56);
		p3.setName("James");
		people.add(p3);
		
		p4 = new SortKata();
		people.add(p4);
	}

	/**
	 * Test method for {@link com.smt.kata.object.SortKata#SortKata()}.
	 */
	@Test
	void testSortKata() {
		
		assertEquals(false, p1.equals(p2));
		assertEquals(false, p1.equals(null));
		assertEquals(false, p1.equals(new SortKata()));
		assertEquals(false, p1.equals(new Object()));

		assertEquals(4, people.size());
		assertNotEquals("1", people.get(0).getId());
		
		Collections.sort(people);
		assertEquals(null, people.get(0).getId());
		assertEquals("112345", people.get(1).getId());
		
		people.sort(p1.new AgeComparator());
		assertEquals(0, people.get(0).getAge());
		assertEquals(21, people.get(1).getAge());
		
		people.sort(p1.new NameComparator());
		assertNull(people.get(0).getName());
		assertEquals("Andy", people.get(1).getName());

		
		assertEquals("123|Andy|21",  p1.toString());
		assertEquals(1418,  p1.hashCode());
		assertEquals(1401,  p2.hashCode());
		assertEquals(1707,  p3.hashCode());
	}

}
