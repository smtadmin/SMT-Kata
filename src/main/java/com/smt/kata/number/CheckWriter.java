package com.smt.kata.number;

// JDK 8.x
import java.util.HashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: CheckWriter.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b>
 * Given a currency value output the English equivalent as written on a check:
 * 
 * Input: 10,985.25   Output: Ten thousand nine hundred eighty five dollars and 25/100
 * Input: 125.75      Output: One hundred twenty five dollars and 75/100
 * Input: 95.00       Output: Ninety five dollars only
 * Input: 69          Output: Sixty nine dollars only
 * Input: 217.12	  Output: Two hundred seventeen dollars and 12/100
 * 
 * Note the initial capital on the output line.
 * Note the input may be an integer or a float.
 * 
 * Collections, Strings or other java classes (other than currency specific classes) may be used.

 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class CheckWriter {
	/**
	 * Holds the map to convert integer to words
	 */
	Map<Integer, String> numberMap = new HashMap<>();
	
	/**
	 * Initializes the Checkwriter and loads the xref map
	 */
	public CheckWriter() {
		// Load the word map
		loadMap();
	}

	/**
	 * Converts a number into a check syntax sentence
	 * @param data
	 * @return
	 */
	public String convertWords(double data) {
		int[] vals = new int[] {1000000, 1000, 100, 10, 1};
		StringBuilder holder = new StringBuilder();
		boolean hasTeen = false;
		for (int val : vals) {
			
			int numItem = (int) data / val;
			if (numItem == 0) continue;
				
			if (val < 100) {
				if (val == 10 && numItem == 1) hasTeen = true;
				else {
					holder.append(numberMap.get(val * numItem + (hasTeen ? 10 : 0))).append(" ");
				}
			} else {
				holder.append(numberMap.get(numItem)).append(" ");
				holder.append(numberMap.get(val)).append(" ");
			}
			
			data = data - (numItem * val);
			
		}
		
		return getHolder(holder, data);
	}
	
	/**
	 * Processes the final entries for the check writer
	 * @param holder The current output values
	 * @param data data element (remainder)
	 * @return String of the shceck writer
	 */
	public String getHolder(StringBuilder holder, double data) {
		holder.append("dollars ");
		if (data > 0 && data < 1) holder.append("and ").append((int)(data * 100)).append("/100");

		return holder.toString().substring(0, 1).toUpperCase() + holder.toString().substring(1);
	}

	/**
	 * Create a numbers map to convert ints to words
	 */
	protected void loadMap() {
		numberMap.put(1, "one");
		numberMap.put(2, "two");
		numberMap.put(3, "three");
		numberMap.put(4, "four");
		numberMap.put(5, "five");
		numberMap.put(6, "six");
		numberMap.put(7, "seven");
		numberMap.put(8, "eight");
		numberMap.put(9, "nine");
		numberMap.put(10, "ten");
		numberMap.put(11, "eleven");
		numberMap.put(12, "twelve");
		numberMap.put(13, "thirteen");
		numberMap.put(14, "fourteen");
		numberMap.put(15, "fifteen");
		numberMap.put(16, "sixteen");
		numberMap.put(17, "seventeen");
		numberMap.put(18, "eighteen");
		numberMap.put(19, "nineteen");
		numberMap.put(20, "twenty");
		numberMap.put(30, "thirty");
		numberMap.put(40, "forty");
		numberMap.put(50, "fifty");
		numberMap.put(60, "sixty");
		numberMap.put(70, "seventy");
		numberMap.put(80, "eighty");
		numberMap.put(90, "ninety");
		numberMap.put(100, "hundred");
		numberMap.put(1000, "thousand");
		numberMap.put(1000000, "million");
	}

}
