package com.smt.kata.word;

// JDK 11.x
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Space Libs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: BrokenStrings.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Broken Strings
 * Given a string s and an integer k, break up the string into multiple lines such 
 * that each line has a length of k or less. You must break it up so that words don't 
 * break across lines. Each line has to have the maximum possible amount of words. 
 * If there's no way to break the text up, then return empty list.
 * 
 * You can assume that there are no spaces at the ends of the string and that there 
 * is exactly one space between each word.
 * 
 * For example, given the string "the quick brown fox jumps over the lazy dog" and k = 10, 
 * you should return: ["the quick", "brown fox", "jumps over", "the lazy", "dog"]. 
 * No string in the list has a length of more than 10.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 10, 2021
 * @updates:
 ****************************************************************************/
public class BrokenStrings {

	/**
	 * 
	 */
	public BrokenStrings() {
		super();
	}
	
	/**
	 * Slices the phrase into chunks no greater than k characters long
	 * @param phrase Phrase to slice
	 * @param k Max characters per slice
	 * @return Collection of sliced words
	 */
	public List<String> slice(String phrase, int k) {
		List<String> retItems = new ArrayList<>();
		if (StringUtil.isEmpty(phrase) || k < 3) return retItems;

		return arrangeSlice(Arrays.asList(phrase.trim().split(" ")), k);
	}
	
	/**
	 * 
	 * @param items
	 * @param k
	 * @return
	 */
	private List<String> arrangeSlice(List<String> items, int k) {
		List<String> slices = new ArrayList<>();
		
		StringBuilder temp = new StringBuilder();
		for (String slice : items) {
			if (slice.length() > k) return new ArrayList<>();
			
			if ((temp.length() + slice.length()) <= k) {
				temp.append(slice).append(" "); 
			} else {
				slices.add(temp.toString().trim());
				temp = new StringBuilder();
				temp.append(slice).append(" ");
			}
		}
		
		// Handle the dangling temp value
		slices.add(temp.toString().trim());
		
		// Return the slices
		return  slices;
	}

}
