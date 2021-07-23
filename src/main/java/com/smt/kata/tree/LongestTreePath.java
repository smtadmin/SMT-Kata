package com.smt.kata.tree;

// JDK 11.x
import java.util.List;

/****************************************************************************
 * <b>Title</b>: LongestTreePath.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Longest Tree Path
 * Given a tree where each edge has a weight, compute the length of the longest path in the tree.
 * 
 * For example, given the following tree:
 *
 *	   a
 *	  /|\
 *	 b c d
 *	    / \
 *	   e   f
 *	  / \
 *	 g   h
 * 
 * and the weights: a-b: 3, a-c: 5, a-d: 8, d-e: 2, d-f: 4, e-g: 1, e-h: 1, the 
 * longest path would be c -> a -> d -> f, with a length of 17.
 *
 * The path does not have to pass through the root, and each node can have any amount of children.
 * Each node on the tree can only be used once.  This means that once you hit a leaf, the 
 * path is at the end, as you would have to backtrack and use the same node twice
 * 
 * The root path will always have a weight of 0.
 *
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 24, 2021
 * @updates:
 ****************************************************************************/
public class LongestTreePath {

	/**
	 * Calculates the longest path for the assigned weights at each node
	 * @param nodes Collection of nodes to calculate against
	 * @return Sum of the weights from each node in the path
	 */
	public int caclculatePath(List<KataNode<Integer>> nodes) {
		
		return nodes.size();
	}

}
