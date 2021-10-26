package com.smt.kata.distance;

// JDK 11.x
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Apache commons 3.x
import org.apache.commons.collections.CollectionUtils;

/****************************************************************************
 * <b>Title</b>: ClassroomFriendship.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Classroom Friendship Kata
 * 
 * A classroom consists of N students, whose friendships can be represented in an 
 * adjacency list. For example, the following descibes a situation where 0 is 
 * friends with 1 and 2, 3 is friends with 6, and so on.
 * 
 * {0: [1, 2],
 *  1: [0, 5],
 *  2: [0],
 *  3: [6],
 *  4: [],
 *  5: [1],
 *  6: [3]} 
 * 
 * Each student can be placed in a friend group, which can be defined as the 
 * transitive closure of that student's friendship relations. In other words, 
 * this is the smallest set such that no student in the group has any friends 
 * outside this group. For the example above, the friend groups 
 * would be {0, 1, 2, 5}, {3, 6}, {4}.
 * 
 * Given a friendship list such as the one above, determine the number of 
 * friend groups in the class.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Oct 22, 2021
 * @updates:
 ****************************************************************************/
public class ClassroomFriendship {

	/**
	 * Counts the groups of friends
	 * @param friends friend assignments
	 * @return count of the number of friend groups
	 */
	public int countGroups(Map<Integer, List<Integer>> friends) {
		if (friends == null || friends.isEmpty()) return 0;
		
		List<Set<Integer>> groups = new ArrayList<>();
		
		// Loop the friends and update the groups
		for (Map.Entry<Integer, List<Integer>> items : friends.entrySet()) {
			if (items == null || items.getKey() == null) continue;
			else if (items.getValue() == null) items.setValue(new ArrayList<>());
			
			// If this is the first entry, just add it to the collection
			if (groups.isEmpty()) {
				Set<Integer> newGroup = new HashSet<>();
				newGroup.add(items.getKey());
				newGroup.addAll(items.getValue());
				groups.add(newGroup);
			} else {
				manageGroups(items.getKey(), items.getValue(), groups);
			}
		}
		
		return groups.size();
	}
	
	/**
	 * checks the existing groups against the new list of friends and adds to groups
	 * @param person Person in the classroom
	 * @param friends friends of that person
	 * @param groups Groups of friends to update
	 */
	private void manageGroups(Integer person, List<Integer> friends, List<Set<Integer>> groups) {
		// Loop the groups and find friend matches
		for (Set<Integer> lists : groups) {
			if (lists.contains(person)) {
				lists.addAll(friends);
				return;
			} else if(CollectionUtils.containsAny(lists, friends)){
				lists.addAll(friends);
				lists.add(person);
				return;
			}
		}
		
		// With no matches, add another group
		Set<Integer> newGroup = new HashSet<>();
		newGroup.add(person);
		newGroup.addAll(friends);
		groups.add(newGroup);
	}
}
