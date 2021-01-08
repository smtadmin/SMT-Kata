package siliconmtn.kata.simple;

/****************************************************************************
 * <b>Title</b>: PolybiusSquare.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> The Polybius Square cipher is a simple substitution cipher 
 * that makes use of a 5x5 square grid. The letters A-Z are written into the grid, 
 * with "I" and "J" typically sharing a slot (as there are 26 letters and only 25 slots).

			1	2	3	4	5
		1	A	B	C	D	E
		2	F	G	H	I/J	K
		3	L	M	N	O	P
		4	Q	R	S	T	U
		5	V	W	X	Y	Z

 * To encipher a message, each letter is merely replaced by its row and column numbers in the grid.
 * Create a function that takes a plaintext or ciphertext message, and returns the corresponding ciphertext or plaintext.
 * As "I" and "J" share a slot, both are enciphered into 24, but deciphered only into "I" (see third and fourth test).
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class PolybiusSquare {
	private static String[][] square = {
		{"A", "B", "C", "D", "E" },
		{"F", "G", "H", "I", "K"},
		{"L", "M", "N", "O", "P" },
		{"Q", "R", "S", "T", "U" },
		{"V", "W", "X", "Y", "Z" }
	};
	
	/**
	 * Creates a variety of test cases to validate the sw
	 * @param args
	 */
	public static void main(String args[]){      

		System.out.println(polybiusEncode("Hi")); // 2324
		System.out.println(polybiusEncode("Hi There Alf")); // 2324 4423154215 113121
		System.out.println(polybiusEncode("Hand Jive")); // 23113314 24245115
		System.out.println(decodeValue("2324")); // hi
		System.out.println(decodeValue("2324 4423154215 113121")); // hi there alf
		System.out.println(decodeValue("23113314 24245115")); // hand iive
	}

	/**
	 * Encodes a sentence into its polybius values
	 * @param term
	 * @return
	 */
	private static String polybiusEncode(String term){
		StringBuilder polybius = new StringBuilder();
	    for (char val : term.toUpperCase().toCharArray()) {
	    	if (val == ' ') polybius.append(" ");
	    	if (val == 'J') val = 'I';
	    	
	    	for (int i = 0; i < square.length; i++) {
	    		String[] inner = square[i];
	    		
	    		for (int x=0; x < inner.length; x++) {
	    			if (inner[x].equalsIgnoreCase(val + "")) {
	    				polybius.append(i + 1).append(x + 1);
	    				break;
	    			}
	    		}
	    	}
	    	
	    }
	    
	    return polybius.toString();
	}
	
	/**
	 * Decodes the polybius back to a string
	 * @param code
	 * @return
	 */
	private static String decodeValue(String code){
	    String[] words = code.split(" ");
	    StringBuilder phrase = new StringBuilder();
	    
	    for (String word : words) {
		    int ctr = 0;

		    while (ctr < word.length()) {
		    	int a = Character.getNumericValue(word.charAt(ctr++)) - 1;
		    	int b = Character.getNumericValue(word.charAt(ctr++)) - 1;

		    	phrase.append(square[a][b]);
		    	
		    }
		    
		    phrase.append(" ");
	    }
			
	    return phrase.toString().toLowerCase();
	}

}
