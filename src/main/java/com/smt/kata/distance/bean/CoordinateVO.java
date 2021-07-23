package com.smt.kata.distance.bean;

// JDK 11.x
import java.io.Serializable;

/****************************************************************************
 * <b>Title</b>: CoordinateVO.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Helper class to hold a set of X/Y Coordinates
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 22, 2021
 * @updates:
 ****************************************************************************/
public class CoordinateVO implements Serializable {
	
	// Members
	private static final long serialVersionUID = 2843552631953420216L;
	private int column;
	private int row;
	
	/**
	 * Default constructor
	 */
	public CoordinateVO() {
		super();
	}

	/**
	 * Constructor.  Assigns coords
	 */
	public CoordinateVO(int x, int y) {
		this();
		this.column = x;
		this.row = y;
	}
	
	/**
	 * Converts this class to an int array
	 * @return Array of 2 items (x, y)
	 */
	public int[] toArray() {
		return new int[] { column, row };
	}

	/**
	 * @return the x
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param x the x to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * @return the y
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param y the y to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

}
