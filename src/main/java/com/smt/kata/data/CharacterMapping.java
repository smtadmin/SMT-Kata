package com.smt.kata.data;

// JDK 11.x
import java.io.InvalidObjectException;
import java.util.Arrays;
import java.util.Map;

/****************************************************************************
 * <b>Title:</b> CharacterMapping.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Character Mapping
 * Given a mapping of digits to letters (as in a phone number), and a digit 
 * character, concatenate the corresponding location between the arrays. You can assume 
 * each valid number in the mapping is a single digit.
 * 
 * For example if {2: ['a', 'b', 'c'], 3: ['d', 'e', 'f'], …} then '23' 
 * should return ["ad", "be", "cf"].
 * 
 * You may use java.util.Map and any of it's implementing classes.  No other 
 * collections may be used or anything other than the standard java imports
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 29, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class CharacterMapping {
	
	private Map<Integer, char[]> digitMap;
	private int arrayLength = 0;

	/**
	 * Constructor assigns amp
	 * @param digitMap The digit make to work against
	 */
	public CharacterMapping(Map<Integer, char[]> digitMap) throws InvalidObjectException {
		super();
		if (digitMap == null || digitMap.isEmpty()) 
			throw new InvalidObjectException("Digit Map must not be empty");
		
		this.digitMap = digitMap;
		calculateLength();
	}

	/**
	 * Adds (concatenates) the elements in the provided locations
	 * @param locations Locations to concatenate
	 * @return concatenated string array
	 */
	public String[] add(int[] locations) {
		String[] addArray = new String[arrayLength];
		
		for (Integer key : locations) {
			char[] row = digitMap.get(key);
			if (row == null) continue;
			
			for (int i=0; i < row.length; i++) {
				addArray[i] = (addArray[i] == null ? "" : addArray[i]) + row[i];
			}
		}
		
		return trimArray(addArray);
	}

	/**
	 * Since each array in the map can be of any length, we need to know how long the 
	 * array needs to be to hold the response
	 */
	public void calculateLength() {
		
		for (Map.Entry<Integer, char[]> row : digitMap.entrySet()) {
			if (row.getValue() == null) continue;
			
			if (row.getValue().length > arrayLength) arrayLength = row.getValue().length;
		}
	}
	
	/**
	 * If the number of items in each row of the digit map are not the same, the
	 * array may need to be truncated
	 * @param results un-truncated result array
	 * @return truncated array of strings
	 */
	public String[] trimArray(String[] results) {
		int length = 0;
		for (int i=0; i < results.length; i++) {
			String val = results[i];
			if (val != null) length = i + 1;
		}
		
		return Arrays.copyOf(results, length);
	}
}
