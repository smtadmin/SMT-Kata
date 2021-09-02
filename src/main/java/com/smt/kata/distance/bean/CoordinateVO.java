package com.smt.kata.distance.bean;

// JDK 11.x
import java.io.Serializable;

import com.smt.kata.util.HashCodeUtil;

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
	public CoordinateVO(int row, int column) {
		this();
		this.column = column;
		this.row = row;
	}
	
	/**
	 * Outputs the value of this coordinate
	 */
	@Override
	public String toString() {
		return "Row[" + row + "] - Col[" + column + "]";
	}
	
	/**
	 * Compares the row and column values
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof CoordinateVO)) return false;
		CoordinateVO vo = (CoordinateVO) o;
		
		return row == vo.getRow() && column == vo.getColumn();
	}
	
	/**
	 * Adds the hashcode using the hashcode util for the row and column
	 */
	@Override
	public int hashCode() {
		return HashCodeUtil.hash(row) + HashCodeUtil.hash(column);
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
