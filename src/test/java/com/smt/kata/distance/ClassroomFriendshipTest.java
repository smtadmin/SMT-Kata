package com.smt.kata.distance;

import static org.junit.jupiter.api.Assertions.assertEquals;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Junit 5
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: ClassroomFriendshipTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Test for the Classroom Friendship Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 22, 2021
 * @updates:
 ****************************************************************************/
class ClassroomFriendshipTest {
	
	// Members
	ClassroomFriendship cf = new ClassroomFriendship();
	
	/**
	 * Test method for {@link com.smt.kata.distance.ClassroomFriendship#countGroups(java.util.Map)}.
	 */
	@Test
	void testCountGroupsNull() throws Exception {
		assertEquals(0, cf.countGroups(null));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.ClassroomFriendship#countGroups(java.util.Map)}.
	 */
	@Test
	void testCountGroupsEmpty() throws Exception {
		Map<Integer, List<Integer>> friends = new LinkedHashMap<>();
		assertEquals(0, cf.countGroups(friends));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.ClassroomFriendship#countGroups(java.util.Map)}.
	 */
	@Test
	void testCountGroupsExampleOneMixedNull() throws Exception {
		Map<Integer, List<Integer>> friends = new LinkedHashMap<>();
		friends.put(Integer.valueOf(0), Arrays.asList(Integer.valueOf(1), Integer.valueOf(2)));
		friends.put(null, Arrays.asList(Integer.valueOf(0), Integer.valueOf(5)));
		friends.put(Integer.valueOf(2), Arrays.asList(Integer.valueOf(0)));
		friends.put(Integer.valueOf(3), Arrays.asList(Integer.valueOf(6)));
		friends.put(Integer.valueOf(4), null);
		friends.put(Integer.valueOf(5), Arrays.asList(Integer.valueOf(1)));
		friends.put(Integer.valueOf(6), null);
		
		assertEquals(3, cf.countGroups(friends));
	}
	
	/**
	 * Test method for {@link com.smt.kata.distance.ClassroomFriendship#countGroups(java.util.Map)}.
	 */
	@Test
	void testCountGroupsExampleOne() throws Exception {
		Map<Integer, List<Integer>> friends = new LinkedHashMap<>();
		friends.put(Integer.valueOf(0), Arrays.asList(Integer.valueOf(1), Integer.valueOf(2)));
		friends.put(Integer.valueOf(1), Arrays.asList(Integer.valueOf(0), Integer.valueOf(5)));
		friends.put(Integer.valueOf(2), Arrays.asList(Integer.valueOf(0)));
		friends.put(Integer.valueOf(3), Arrays.asList(Integer.valueOf(6)));
		friends.put(Integer.valueOf(4), new ArrayList<Integer>());
		friends.put(Integer.valueOf(5), Arrays.asList(Integer.valueOf(1)));
		friends.put(Integer.valueOf(6), Arrays.asList(Integer.valueOf(3)));
		
		assertEquals(3, cf.countGroups(friends));
	}

	/**
	 * Test method for {@link com.smt.kata.distance.ClassroomFriendship#countGroups(java.util.Map)}.
	 */
	@Test
	void testCountGroupsSingle() throws Exception {
		Map<Integer, List<Integer>> friends = new LinkedHashMap<>();
		friends.put(Integer.valueOf(0), Arrays.asList(Integer.valueOf(1), Integer.valueOf(2)));
		
		assertEquals(1, cf.countGroups(friends));
	}
}
