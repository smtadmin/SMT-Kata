package siliconmtn.kata.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

import siliconmtn.kata.wordchain.WordChain;

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
	public static final String RESOURCE = "/siliconmtn/kata/util/dictionary.txt";
	
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
	public static String[] getDictionary() throws IOException {
    	InputStreamReader isr = new InputStreamReader(  WordChain.class.getResourceAsStream(RESOURCE));
        try ( BufferedReader reader = new BufferedReader(isr)) {
            Set<String> dict = new TreeSet<>();
            String s;
            while ( (s = reader.readLine() ) !=null ) {
                dict.add(s);
            }
            
            return dict.toArray(new String[0]);
        }
	}

}
