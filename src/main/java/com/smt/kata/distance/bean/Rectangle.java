package com.smt.kata.distance.bean;

// JDK 11.x
import java.io.Serializable;

/****************************************************************************
 * <b>Title</b>: Rectangle.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Value object holding the coordinates for a rectangle
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 31, 2021
 * @updates:
 ****************************************************************************/
public class Rectangle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3615572197475045115L;
	
	// Members
	CoordinateVO topLeft;
	CoordinateVO bottomRight;
	
	/**
	 * 
	 */
	public Rectangle(CoordinateVO topLeft, CoordinateVO bottomRight) {
		super();
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}
	
	/**
	 * Determines if the provided coordinate is contained within the rectangle. 
	 * @param coord Coordinate to check
	 * @param includeBorder Is the outer row/column included within the rectangle?
	 * @return True if contained, false otherwise
	 */
	public boolean contains(CoordinateVO coord, boolean includeBorder) {
		int border = includeBorder ? 0 : 1;
		
		return (coord.getRow() >= (topLeft.getRow() + border) && 
			coord.getRow() <= (getBottomLeft().getRow() - border) &&
			coord.getColumn() >= (topLeft.getColumn() + border) &&
			coord.getColumn() <= (getBottomRight().getColumn() - border));
	}
	
	/**
	 * Determines if the provided coordinate is contained within the rectangle. The
	 * border row/col is included inside the rectangle
	 * @param coord Coordinate to check
	 * @return True if contained, false otherwise
	 */
	public boolean contains(CoordinateVO coord) {
		return contains(coord, true);
	}

	/**
	 * @return the topLeft
	 */
	public CoordinateVO getTopLeft() {
		return topLeft;
	}
	
	/**
	 * @return the topRight
	 */
	public CoordinateVO getTopRight() {
		if (topLeft == null || bottomRight == null) return null;
		int row = topLeft.getRow();
		int col = bottomRight.getColumn();
		return new CoordinateVO(row, col);
	}

	/**
	 * @return the bottomRight
	 */
	public CoordinateVO getBottomRight() {
		return bottomRight;
	}
	
	/**
	 * @return the topRight
	 */
	public CoordinateVO getBottomLeft() {
		int row = bottomRight.getRow();
		int col = topLeft.getColumn();
		return new CoordinateVO(row, col);
	}

	/**
	 * @param topLeft the topLeft to set
	 */
	public void setTopLeft(CoordinateVO topLeft) {
		this.topLeft = topLeft;
	}

	/**
	 * @param bottomRight the bottomRight to set
	 */
	public void setBottomRight(CoordinateVO bottomRight) {
		this.bottomRight = bottomRight;
	}

}
