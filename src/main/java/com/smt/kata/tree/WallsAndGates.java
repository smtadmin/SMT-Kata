package com.smt.kata.tree;

/****************************************************************************
 * <b>Title</b>: WallsAndGates.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Walls and Gates Kata
 * 
 * You are given a m x n 2D grid initialized with these three possible values.
 * 
 * -1 - A wall or an obstacle.
 *  0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to r
 *       epresent INF as you may assume that the distance to a gate is less than 2147483647.
 * 
 * Fill each empty room with the distance to its nearest gate. If it is impossible 
 * to reach a gate, it should be filled with INF.
 * 
 * Example: 
 * 
 * Given the 2D grid:
 * 
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 *   
 *   After running your function, the 2D grid should be:
 * 
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 *   
 *  **** Hint: Try using a depth first search algorithm
 *   
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 29, 2021
 * @updates:
 ****************************************************************************/
public class WallsAndGates {
	
	/**
	 * Assigns the distance from each room to a gate
	 * @param rooms Matrix of rooms, gates and walls
	 */
	public int[][] assign(int[][] rooms) {
		if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) 
			return new int[0][];
		
        // Iterate through the matrix calling dfs on all indices that contain a zero
        for(int rows = 0; rows < rooms.length; rows++) {
            for(int cols = 0; cols < rooms[0].length; cols++) {
                if(rooms[rows][cols] == 0) {
                    dfs(rooms, rows, cols, 0);
                }
            }
        }
        
        return rooms;
    }
	
	/**
	 * Recursive method to check every location's path in all four directions
	 * @param rooms Matrix array
	 * @param row Row index of the gate
	 * @param col Column index of the gate
	 * @param distance Steps fomr the gate
	 */
	protected void dfs(int[][] rooms, int row, int col, int distance) {
        //if you have gone out of the bounds of the array or you have run into a wall/obstacle, return
        // room[i][j] < distance also ensure that we do not overwrite any previously determined 
		// distance if it is shorter than our current distance
        if(row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length || rooms[row][col] < distance) {
            return;
        }
        
        //set current index's distance to distance
        rooms[row][col] = distance;
        
        //recurse on all adjacent neighbors of rooms[i][j]
        dfs(rooms, row + 1, col, distance + 1);
        dfs(rooms, row - 1, col, distance + 1);
        dfs(rooms, row, col + 1, distance + 1);
        dfs(rooms, row, col - 1, distance + 1);
    }

}
