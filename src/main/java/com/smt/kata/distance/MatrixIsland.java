package com.smt.kata.distance;

// JDK 11.x
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title:</b> MatrixIsland.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Island Matrix
 * 
 * Given a matrix of 1s and 0s, return the number of "islands" in the matrix. 
 * A 1 represents land and 0 represents water, so an island is a group of 1s that are 
 * neighboring (horizontal or vertical or both.  Diagonal only does not count) whose 
 * perimeter is surrounded by water.  Land (1s) on the outside of the matrix are 
 * considered surrounded by water on those edges.  In other words, the matrix is 
 * surrounded by water. The smallest island has 1 node
 * 
 * For example, the largest island in this matrix is 4
 * 
 * 1 0 0 0 0
 * 0 0 1 1 0
 * 0 1 1 0 0
 * 0 0 0 0 0
 * 1 1 0 0 1
 * 1 1 0 0 1
 * 
 * Use whatever classes you want for this
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 1, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class MatrixIsland {
    // Members
    protected int[][] matrix;
    protected boolean hasIslands = false;
    protected int numberIslands = 0;
    protected int nodesInLargestIsland = 0;
    protected List<String> visitedNodes;
    protected Map<Integer, Integer> islands;
    
    /**
     * Assigns the matrix
     */
    public MatrixIsland(int[][] matrix) throws NullPointerException {
        super();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            throw new NullPointerException();
            
            
        visitedNodes = new ArrayList<>();
        islands = new HashMap<>();
        this.matrix = matrix;
        findIslands();
        findLargest();
    }

    /**
     * Finds each of the islands
     */
    private void findIslands() {
        for (int x=0; x < matrix.length; x++) {
            for (int y=0; y < matrix[x].length; y++) {
                if (visitedNodes.contains(x+","+y)) continue;
                if (matrix[x][y] == 1 ) {
                    this.numberIslands++;
                    islands.put(this.numberIslands, 0);
                    sizeIsland(x, y, this.numberIslands);
                } else {
                    visitedNodes.add(x+","+y);
                }
            }
        }
    }
    
    /**
     * Recursively grab the islands and calculate their sides
     * @param x X coordinate from the matrix
     * @param y Y coordinate from the matrix
     * @param island 
     */
    private void sizeIsland(int x, int y, int island) {
        if (visitedNodes.contains(x+","+y)|| y < 0 || x <0 || x >=matrix.length || y >= matrix[x].length ) return;
        visitedNodes.add(x+","+y);
        if (matrix[x][y] == 1) {
            islands.put(island, islands.get(island)+1);
        } else {
            return;
        }
        
        sizeIsland(x+1, y, island);
        sizeIsland(x, y+1, island);
        sizeIsland(x-1, y, island);
        sizeIsland(x, y-1, island);
    }

    /**
     * Finds the largest island and returns the number of nodes in that island
     * @return Number of nodes in the largest island
     */
    protected void findLargest() {
        nodesInLargestIsland = 0;
        for (Integer i : islands.values()) {
            if (i > nodesInLargestIsland) nodesInLargestIsland = i;
        }
        
    }

    /**
     * @return the hasIslands
     */
    public boolean hasIslands() {
        return this.numberIslands > 0;
    }

    /**
     * @return the numberIslands
     */
    public int getNumberIslands() {
        return numberIslands;
    }

    /**
     * @return the nodesInLargestIsland
     */
    public int getNodesInLargestIsland() {
        return nodesInLargestIsland;
    }

}