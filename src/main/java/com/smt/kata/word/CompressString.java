package com.smt.kata.word;

/****************************************************************************
 * <b>Title</b>: CompressString.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Compress a string such that 'AAABCCDDDD' becomes 
 * 'A3BCCD4'. Only compress the string if it saves space.
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 7, 2021
 * @updates:
 ****************************************************************************/
public class CompressString {
	/**
	 * Compress the string by combining a character with the number of characters when concurrent 
	 * characters exceeds 2 characters
	 * @param startNumber
	 * @return
	 */
	public String compress(String val){
		StringBuilder compressed = new StringBuilder();
		val = val.toUpperCase();
		
		char prev = '~';
		int ctr = 1;
		for (int i=0; i < val.length(); i++) {
			char c = val.charAt(i);
			
			if (i > 0 && c == prev) ctr++;
			else if (i > 0) {
				compressed.append(prev);
				if (ctr == 2) compressed.append(prev);
				else if (ctr > 2) compressed.append(ctr);
				ctr = 1;
			}
			
			prev = c;
		}
		
		// Cleanup any existing characters
		compressed.append(prev);
		if (ctr == 2) compressed.append(prev);
		else if (ctr > 2) compressed.append(ctr);
		
		return compressed.toString();
	}

}
