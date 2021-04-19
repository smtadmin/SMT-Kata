package com.smt.kata.data;

// JDK 11
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Apache commons 3.x
import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: PatternDecoder.java <b>Project</b>: SMT-Kata <b>Description:
 * </b> Given the mapping a = 1, b = 2, ... z = 26, and an encoded message,
 * count the number of ways it can be decoded. For example, the message '111'
 * would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'. You can
 * assume that the messages are decodable. For example, '001' is not allowed.
 * <b>Copyright:</b> Copyright (c) 2021 <b>Company:</b> Silicon Mountain
 * Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class PatternDecoder {
	/**
	 * Character to value map
	 */
	private Map<String, String> charMap = new LinkedHashMap<>();
	
	/**
	 * Initializes the char map
	 */
	public PatternDecoder() {
		super();
		charMap.put("1", "a");
		charMap.put("2", "b");
		charMap.put("3", "c");
		charMap.put("4", "d");
		charMap.put("5", "e");
		charMap.put("6", "f");
		charMap.put("7", "g");
		charMap.put("8", "h");
		charMap.put("9", "i");
		charMap.put("10", "j");
		charMap.put("11", "k");
		charMap.put("12", "l");
		charMap.put("13", "m");
		charMap.put("14", "n");
		charMap.put("15", "o");
		charMap.put("16", "p");
		charMap.put("17", "q");
		charMap.put("18", "r");
		charMap.put("19", "s");
		charMap.put("20", "t");
		charMap.put("21", "u");
		charMap.put("22", "v");
		charMap.put("23", "w");
		charMap.put("24", "x");
		charMap.put("25", "y");
		charMap.put("26", "z");
	}

	/**
	 * Ensures the parsed data is decodable
	 * @param message
	 * @return
	 */
	public boolean isDecodable(String message) {
		if (StringUtils.isEmpty(message)) {
			return false;
		}
		
	    for (int i = 0; i < message.length(); i++) {

	        try {
	        	int parsed = Integer.parseInt(message.charAt(i) + "");
	        	
	        	if (! (parsed > 0 && parsed < 27)) return false;
	        } catch (Exception e) {
	        	return false;
	        }
	    }
	    
	    return true;
	}
	
	/**
	 * Decodes the given pattern
	 * 
	 * @param pattern Valid pattern to compare
	 * @return Collection of the matching patterns
	 */
	public List<String> decodePattern(String pattern) {
		List<String> patterns = new ArrayList<>();
		if (! isDecodable(pattern)) return patterns;
		
		List<List<Integer>> options = getPatternOptions(pattern);
		
		for (List<Integer> po : options) {
			StringBuilder match = new StringBuilder();
			int val = 0;
			for (int i = 0; i < po.size(); i = val) {
				val = i + po.get(i);
				match.append(charMap.get(pattern.substring(i, val)));

				// if the first loop has 2 chars to begin, reduce the val by 1
				if (i == 0 && (val - i) == 2)
					--val;
			}
			
			patterns.add(match.toString());
		}

		return patterns;
	}

	/**
	 * get the number of
	 * 
	 * @param size
	 * @return
	 */
	private List<List<Integer>> getPatternOptions(String pattern) {
		int length = pattern.length();
		List<List<Integer>> patterns = getPattern(pattern);
		List<List<Integer>> vals = new ArrayList<>();
		Integer[] elements = new Integer[pattern.length()];
		Arrays.fill(elements, 1);
		
		// Process length 3
		if (length == 3) processLengthThree(patterns, vals, elements, length);
		else if (length == 4) processLengthFour(patterns, vals, elements, length);
		
		return vals;
	}
	
	/**
	 * Processes patterns with a length of 3
	 * @param patterns
	 * @param vals
	 * @param elements
	 * @param length
	 */
	private void processLengthThree(List<List<Integer>> patterns, List<List<Integer>> vals, Integer[] elements, int length) {
			if (patterns.get(0).contains(1)) vals.add(Arrays.asList(elements));
			if (patterns.get(0).contains(2)) vals.add(Arrays.asList(2,1));
			if (patterns.get(1).contains(2)) vals.add(Arrays.asList(1,2));
	}
	
	/**
	 * Processes patterns with a length of 4
	 * @param patterns
	 * @param vals
	 * @param elements
	 * @param length
	 */
	private void processLengthFour(List<List<Integer>> patterns, List<List<Integer>> vals, Integer[] elements, int length) {
		if (patterns.get(0).contains(1)) vals.add(Arrays.asList(elements));
		if (patterns.get(0).contains(2) && patterns.get(2).contains(2)) vals.add(Arrays.asList(2, 2));
		if (patterns.get(0).contains(2)) vals.add(Arrays.asList(2,1,1));
		if (patterns.get(1).contains(2)) vals.add(Arrays.asList(1,2,1));
		if (patterns.get(2).contains(2)) vals.add(Arrays.asList(1,1,2));
	}
	
	/**
	 * 
	 * @param pattern
	 * @return
	 */
	private static List<List<Integer>> getPattern(String pattern) {
		int length = pattern.length();
		List<List<Integer>> vals = new ArrayList<>();
		
		for (int i=0; i < length; i++) {
			if (length -1 == i) vals.add(Arrays.asList(1));
			else if (pattern.charAt(i) > '2') vals.add(Arrays.asList(1));
			else if (pattern.charAt(i) == '1' || (pattern.charAt(i) == '2' && pattern.charAt(i + 1) < '7')) {
				vals.add(Arrays.asList(1, 2));
			} else vals.add(Arrays.asList(1));
		}
		
		return vals;
	}

}
