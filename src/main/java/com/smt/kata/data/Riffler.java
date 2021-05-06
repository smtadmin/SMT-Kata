package com.smt.kata.data;

// Spacelibs 1.x
import com.siliconmtn.data.bean.GenericVO;

/****************************************************************************
 * <b>Title:</b> Riffler.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Riffler
 * 
 * Riffle takes two lists and alternately puts their elements into one list: 
 * 
 * Riffle[{a,b,c},{1,2,3}] 
 * {a,1,b,2,c,3} 
 * 
 * Write a function Deriffle that takes a list of any length and separates it into 
 * two lists. The first list should contain all of the entries with odd indices in 
 * the original list, and the second should contain all of the entries with even indices. 
 * 
 * Deriffle[{1,2,3,4,5}] 
 * {{1,3,5},{2,4}} 
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 29, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class Riffler {

	/**
	 * Combines the two arrays by alternating the elements from each array
	 * @param source Source array.  Length must be greater than or equal to dest
	 * @param dest Destination array to combine.  Must be within 1 character of
	 * the source length
	 * @return Combined array.  Empty array if invalid data
	 */
	public char[] riffle(char[] source, char[] dest) {
		// Check the input
		if (isInValidInput(source, dest)) return new char[0];
		
		// Create e new array to hold the compbined that is the length
		// of both arrays summed
		char[] combined = new char[source.length + dest.length];
		
		// Add the odd elements
		int start = 0;
		for (int i=0; i < source.length; i++) {
			combined[start] = source[i];
			start += 2;
		}
		
		// Add the even elements
		start = 1;
		for (int i=0; i < dest.length; i++) {
			combined[start] = dest[i];
			start += 2;
		}
		
		return combined;
	}
	
	/**
	 * Splits the passed array into 2 elements.  
	 * @param combined Array to deriffle
	 * @return Source array as key and the dest array as value
	 */
	public GenericVO deriffle(char[] combined) {
		// Create 2 arrays to hold the odd and even values
		int len = combined.length;
		double sLen = Math.ceil(len / 2.0);
		char[] source = new char[(int)sLen];
		char[] dest = new char[(int)(len - sLen)];
		
		// Add the elements to the 2 arrays
		int insert = 0;
		for(int i = 0; i < len; i++) {
			if ((i % 2) == 0) source[insert] = combined[i];
			else dest[insert++] = combined[i];
		}
		
		// Add the arrays to the vo and return
		return new GenericVO(source, dest);
	}
	
	/**
	 * Validates the input
	 * @param source Source array.  Length must be greater than or equal to dest
	 * @param dest Destination array to combine.  Must be within 1 character of
	 * the length
	 * @return True if data is valid.  False otherwise
	 */
	private boolean isInValidInput(char[] source, char[] dest) {
		return  source == null || 
				dest == null || 
				dest.length > source.length || 
				Math.abs(dest.length - source.length) > 1;
	}

}
