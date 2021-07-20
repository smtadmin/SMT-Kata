package com.smt.kata.distance;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;

// Spacelibs 1.x
import com.smt.kata.util.HashCodeUtil;

/****************************************************************************
 * <b>Title</b>: IntersectingRectangles.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Intersecting Rectangles Kata
 * 
 * Given two rectangles on a 2D graph, return the list of of their intersecting 
 * coordinates. If the rectangles don't intersect, return empty List.
 * 
 * For example, given the following rectangles:
 * 
 * {
 * 		"top_left": (1, 4),
 * 		"dimensions": (3, 3) # width, height
 * }
 * 
 * and
 * 
 * {
 * 		"top_left": (0, 5),
 * 		"dimensions": (4, 3) # width, height
 * }
 * 
 * return List with 6 coordinates 
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 19, 2021
 * @updates:
 ****************************************************************************/
public class IntersectingRectangles {
	
	/**
	 * Finds the overlap between 2 rectangles
	 * @param one Starting coordinate of the first rectangle
	 * @param width1 width of the first rectangle
	 * @param height1 height of the first rectangle
	 * @param two Starting coordinate of the first rectangle
	 * @param width2 width of the first rectangle
	 * @param height2 height of the first rectangle
	 * @return List of overlapping coordinates
	 */
	public List<Coord> getOverlap(Coord one, int width1,  int height1, Coord two, int width2, int height2) {
		if (one == null || two == null || (width1 < 1 || width2 < 1 || height1 < 1 || height2 < 1))
			return new ArrayList<>();
		
		List<Coord> rect1 = createCoordList(one, width1, height1);
		List<Coord> rect2 = createCoordList(two, width2, height2);
		
		rect1.retainAll(rect2);
		
		return rect1;
	}
	
	/**
	 * Creates a list of all of the coordinates in the rectangle
	 * @param coord Starting point for the rectangle
	 * @param width Width if the rectangle
	 * @param height Height of the rectangle
	 * @return Collection of coordinates for the rectangle
	 */
	public List<Coord> createCoordList(Coord coord, int width, int height) {
		List<Coord> coords = new ArrayList<>();
		for (int i=coord.top; i < (coord.top + height); i++) {
			for (int j = coord.left; j < (coord.left + width); j++) {
				coords.add(new Coord(i, j));
			}
		}
		
		return coords;
	}

}

class Coord {
	int top = 0;
	int left = 0;
	
	public Coord() {
		super();
	}
	
	public Coord(int top, int left) {
		this();
		this.top = top;
		this.left = left;
	}
	
	public String toString() {
		return top + "," + left;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Coord)) return false;
		Coord c = (Coord)o;
		
		return c.top == top && c.left == left;
	}
	
	@Override
	public int hashCode() {
		return HashCodeUtil.hash(top) + HashCodeUtil.hash(left);
	}
}

