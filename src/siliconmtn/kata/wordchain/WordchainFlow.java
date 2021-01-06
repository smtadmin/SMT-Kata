package siliconmtn.kata.wordchain;

// JDK 8.x
import java.util.ArrayDeque;
import java.util.Deque;

/****************************************************************************
 * <b>Title</b>: WordchainFlow.java <p/>
 * <b>Project</b>: Kata <p/>
 * <b>Description: </b> Solves the wordchain puzzle. Find a chain of words 
 * starting with one word and ending with another. Successive entries in the 
 * chain must all be real words, and each can differ from the previous word by just one letter.
 * <p/>
 * <b>Copyright:</b> Copyright (c) 2020<p/>
 * <b>Company:</b> Silicon Mountain Technologies<p/>
 * @author james
 * @version 1.0
 * @since Dec 29, 2020<p/>
 * <b>Changes: </b>
 ****************************************************************************/
public class WordchainFlow {
    private String[] dict;
    private int max;

    /**
     * Accepts the dictionary and the max number of depths to traverse for the chain
     * @param wordList
     * @param max
     */
    public WordchainFlow(String[] wordList, int max) {
        this.dict = wordList;
        this.max = max;
    }


    /**
     * Retrieves the word chain based upon the provided words
     * @param from
     * @param to
     * @return
     */
    public String [] getChain( String from, String to ) {
        // check that from and to exists
        if ( ! ( dictHas(from) && dictHas(to) ) ) return new String[0];

        for ( int i=0; i < max; i++ ) {
            Deque<String> deque = new ArrayDeque<>();
            recurse( from, to, deque, i );
            if ( deque.size() != 1 ) return deque.toArray( new String[deque.size()] );
        }
        return new String[0];
    }

    /**
     * Recursive method that navigates the dictionary
     * @param from
     * @param to
     * @param deque
     * @param maxDepth
     * @return
     */
    private boolean recurse( String from, String to, Deque<String> deque, int maxDepth ) {
        deque.push( from );
        if( deque.size() > maxDepth ) return false;  // prune
        if ( from.equals( to) ) return true;

        for ( String w: dict) {
            if ( w.length() == from.length() && dif( from, w ) == 1 && !deque.contains(w) ) {
                if ( recurse( w, to, deque, maxDepth ) ) return true;
                deque.pop();
            }
        }
        return false;
    }

    /**
     * Determine the number of differences between each word
     * @param a
     * @param b
     * @return
     */
    private int dif( String a, String b ) {
        int dif = 0;
        for ( int i=0; i< a.length(); i++ ) {
            if ( a.charAt(i) != b.charAt(i) ) dif++;
        }
        return dif;
    }

    /**
     * Ensures the start and end word in the chain are in the dictionary
     * @param word
     * @return
     */
    private boolean dictHas(String word) {
        for ( String s: dict) {
            if ( s.equals( word ) ) return true;
        }
        return false;
    }
}
