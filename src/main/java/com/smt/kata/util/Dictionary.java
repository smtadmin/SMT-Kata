package com.smt.kata.util;

// JDK 11.x
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/****************************************************************************
 * <b>Title</b>: Dictionary.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Loads the dictionary for various Kata Challenges
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 8, 2021
 * @updates:
 ****************************************************************************/
public class Dictionary {

	/**
	 * Location of the dictionary
	 */
	public static final String RESOURCE = "/data/dictionary.txt";
	
	/**
	 * 
	 */
	public Dictionary() {
		super();
	}
	
	/**
	 * Retrieves the dictionary
	 * @return
	 * @throws IOException
	 */
	public Set<String> getDictionary() throws IOException {
        Set<String> dict = new TreeSet<>();
        try (InputStreamReader isr = new InputStreamReader(  this.getClass().getResourceAsStream(RESOURCE))) {
	    	try ( BufferedReader reader = new BufferedReader(isr)) {
	            String s;
	            while ( (s = reader.readLine() ) !=null ) {
	                dict.add(s);
	            }
	    	}
        }
    	
        return dict;
	}
	
	/**
	 * Retrieves the dictionary as an array
	 * @return
	 * @throws IOException
	 */
	public String[] getDictionaryArray() throws IOException {
		
		Set<String> d = getDictionary();
		String[] dict = new String[d.size()];
		d.toArray(dict);
		return dict;
	}

}
