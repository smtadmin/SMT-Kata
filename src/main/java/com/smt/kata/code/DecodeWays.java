package com.smt.kata.code;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: DecodeWays.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Decode Ways
 * 
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back 
 * into letters using the reverse of the mapping above (there may be multiple ways). 
 * For example, "11106" can be mapped into:
 * 
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped 
 * into 'F' since "6" is different from "06".
 * 
 * Given a string s containing only digits, return the number of ways to decode it.
 * 
 * Example 1:
 * Input: s = "12"
 * Count: 2
 * Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
 * 
 * Example 2:
 * Input: s = "226"
 * Count: 3
 * Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * 
 * Example 3:
 * Input: s = "0"
 * Count: 0
 * Explanation: There is no character that is mapped to a number starting with 0.
 * The only valid mappings with 0 are 'J' -> "10" and 'T' -> "20", neither of which start with 0.
 * Hence, there are no valid ways to decode this since all digits need to be mapped.
 * 
 * Example 4:
 * Input: s = "06"
 * Count: 0
 * Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 18, 2021
 * @updates:
 ****************************************************************************/
public class DecodeWays {
	
	List<List<String>> data;
	
	/**
	 * Encodes the provided sequence into all possible variations
	 * @param code Code to be encoded
	 * @return Collection of possible codes
	 */
	public List<String> encode(String code) {
		// Filter invalid codes
		data = new ArrayList<>();
		if (StringUtil.isEmpty(code)) return new ArrayList<>();
		
		// Get all possible combinations
		combination(code, 0, "");
		
		// Remove the combinations that are invalid
		filter();
		
		// Decode the numbers into letters and return
		return decode();
	}
	
	/**
	 * Converts the numbers into a character
	 * @return List of codes
	 */
	public List<String> decode() {
		List<String> codes = new ArrayList<>();
		
		// Loop each collection of numbers and convert to letters
		for (List<String> ele : data ) {
			StringBuilder code = new StringBuilder();
			for (String s : ele) code.append(((char) (Integer.parseInt(s) + 64)));
			codes.add(code.toString());
		}
		
		return codes;
	}
	
	/**
	 * Filters the data down to the acceptable params.  Filters out "0"
	 * and numbers grater than 26
	 */
	public void filter() {
		List<List<String>> items = new ArrayList<>();
		
		// Loop all of the items and only keep ones that match the filter
		for (List<String> item : data) {
			List<String> temp =  item
				.stream()
				.filter(val -> ! val.startsWith("0") && Integer.parseInt(val) < 27)
				.collect(Collectors.toList());
			
			// Only add the item if the number of elements match before and after
			if (item.size() == temp.size()) items.add(item);
		}
		
		// Reset the data elements to the filtered items
		data = items;
	}
	
	/**
	 * Gets all of the possible combinations
	 * @param s String to split
	 * @param i Current index
	 * @param out String part of the iteration
	 */
	public void combination(String s, int i, String out) {
		if (i == s.length()) {
			data.add(Arrays.asList(out.substring(0, out.length() - 1).split("\\|")));
		}

		// consider each substring `S[i, j]`
		for (int j = s.length() - 1; j >= i; j--) {
			String subStr = s.substring(i, j + 1) + "|";

			// append the substring to the result and recur with an index of
			// the next character to be processed and the result string
			combination(s, j + 1, out + subStr);
		}
	}
}
