package com.smt.kata.word;

import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: LongestCommonSequenceAgain.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 12, 2021
 * @updates:
 ****************************************************************************/
public class LongestCommonSequenceAgain {


	/**
	 * Loads and returns the possible permutations of a word
	 * @param word
	 * @return
	 */
    public String getSequence(String[] words) {
        if(words == null) return "";
        String sequence = "";
        
    	List<List<String>> items = new ArrayList<>();
    	
        //Call recursive function
        for (String word : words) {
        	List<String> item = new ArrayList<>();
        	permutation("", word, item);
        	items.add(item);
        	
        	System.out.println(item);
        }
        
        return sequence;
    }
    
    /**
     * Recursive method to get the permutations
     * @param permutation
     * @param word
     */
    private void permutation(String permutation, String word, List<String> item) {
        //Check the base case
        if (word.isEmpty()) {
            item.add(permutation + word);

        } else {
            //iterate through all of the characters
            for (int i = 0; i < word.length(); i++) {
                //Call recursive function with sub strings
                permutation(permutation + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()), item);
            }
        }

    }

}
