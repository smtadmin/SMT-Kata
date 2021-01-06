package siliconmtn.kata.wordchain;

// JDK 8.x
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/****************************************************************************
 * <b>Title</b>: WordChain.java <p/>
 * <b>Project</b>: Kata <p/>
 * <b>Description: </b> There’s a type of puzzle where the challenge is to build a 
 * chain of words, starting with one particular word and ending with another. 
 * Successive entries in the chain must all be real words, and each can differ from 
 * the previous word by just one letter. For example, you can get from 
 * “cat” to “dog” using the following chain.
 * • cat
 * • cot
 * • cog
 * • dog
 * The objective of this kata is to write a program that accepts start and end words and, 
 * using words from the dictionary, builds a word chain between them. For added programming 
 * fun, return the shortest word chain that solves each puzzle. For example, you can 
 * turn “lead” into “gold” in four steps (lead, load, goad, gold), and “ruby” into “
 * code” in six steps (ruby, rubs, robs, rods, rode, code).
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2020<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author james
 * @version 1.0
 * @since Dec 29, 2020<p/>
 * <b>Changes: </b>
 ****************************************************************************/
public class WordChain {

	/**
	 * Location of the dictionary
	 */
	public static final String RESOURCE = "./dictionary.txt";
	
	/**
	 * Entry point to run the word chain program
	 * @param args
	 */
    public static void main( String [] args ) throws IOException {
    	WordchainFlow wc = new WordchainFlow(loadDict(), 50);
    	Map<String, String> words = new LinkedHashMap<>();
    	words.put("cat", "dog");
    	words.put("lead", "gold");
    	words.put("beat", "helm");
    	
    	// Loop through the map of words and calculate the chain for each
    	for(Map.Entry<String,String> entry : words.entrySet()) {
    		System.out.println("Starting Wordchain for " + entry.getKey() + " to " + entry.getValue());
    		
    		String[] wordChain = wc.getChain(entry.getKey(), entry.getValue());
	        for( String s: wordChain) {
	            System.out.println(s);
	        }
	        
	        System.out.println("---------------------\n");
    	}
    	
    	System.out.println("Wordchain Complete");
    }

    /**
     * Loads the dictionary as a String array
     * @return
     * @throws IOException 
     */
    public static String[] loadDict() throws IOException {
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
