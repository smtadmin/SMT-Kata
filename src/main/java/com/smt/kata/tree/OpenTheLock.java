package com.smt.kata.tree;

// JDK 11.x
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/****************************************************************************
 * <b>Title</b>: OpenTheLock.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Open The Lock Kata
 * 
 * You have a lock in front of you with 4 circular wheels. Each wheel has 
 * 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate 
 * freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. 
 * Each move consists of turning one wheel one slot.
 * 
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * 
 * You are given a list of deadends dead ends, meaning if the lock displays any of 
 * these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * 
 * Given a target representing the value of the wheels that will unlock the lock, 
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * 
 * Example 1:
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * 
 * Example 2:
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 * 
 * Example 3:
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation:
 * We can't reach the target without getting stuck.
 * 
 ************************ Hint: Breadth First Search!!
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 26, 2021
 * @updates:
 ****************************************************************************/
public class OpenTheLock {

	/**
	 * Calculates the number of moves to unlock the lock
	 * @param deadends Numbers that are not allowed to be used
	 * @param target Combination to target
	 * @return Number of moves.  -1 if it can't be accomplished
	 */
	public int calculatePath(String[] deadends, String target) {

        // convert to hashset for ease of use
        HashSet<String> deadEnds = new HashSet<>(Arrays.asList(deadends));

        // taking visited hashset
        HashSet<String> visited = new HashSet<>();

        // initialize the queue and add the target
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        // initialize moves
        int moves = 0;

        // add neighbours while queue is not empty
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while (size != 0){

                String currentPosition = queue.poll();

                // check if current position is in deadends or is already visited
                if (deadEnds.contains(currentPosition) || visited.contains(currentPosition)){
                    size--;
                    continue;
                }

                // add to visited if not already visited
                visited.add(currentPosition);

                // check if current position is the ans
                if (currentPosition.equals(target)) return moves;

                // add to the queue all the neighbours of current position
                addNeighbors(currentPosition, deadEnds, visited, queue);
                size--;
            }

            moves++;
        }

        return -1;
    }

	/**
	 * Increments and decrements the current position
	 * @param currentPosition current combination
	 * @param deadEnds Combinations that can't be used
	 * @param visited Visited locations
	 * @param queue Queue to track moves
	 */
	private void addNeighbors(String currentPosition, Set<String> deadEnds, Set<String> visited, Queue<String> queue) {
        StringBuilder sb = new StringBuilder(currentPosition);
        for (int i = 0; i < 4; i++){
            String s1 = sb.substring(0,i) + (sb.charAt(i) == '9' ? 0 : sb.charAt(i) - '0' + 1) + sb.substring(i+1);
            String s2 = sb.substring(0,i) + (sb.charAt(i) == '0' ? 9 : sb.charAt(i) - '0' - 1) + sb.substring(i+1);

            // add the neighbours to the queue
            if (!visited.contains(s1) && !deadEnds.contains(s1)) queue.add(s1);
            if (!visited.contains(s2) && !deadEnds.contains(s2)) queue.add(s2);

        }
	}
}
