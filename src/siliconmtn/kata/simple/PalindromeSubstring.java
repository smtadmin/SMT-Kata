package siliconmtn.kata.simple;

/****************************************************************************
 * <b>Title</b>: PalindromeSubstring.java
 * <b>Project</b>: _Sandbox
 * <b>Description: </b> Checks a given string to find the largest palindrome contained inside
 * the word.  Returns an empty string if no palindrome. Strings may be used, but no collections or
 * String builders.  
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 6, 2021
 * @updates:
 ****************************************************************************/
public class PalindromeSubstring {

	/**
	 * Creates a variety of test cases to validate the sw
	 * @param args
	 */
	public static void main(String args[]){      
		System.out.println("Caramel: " + getLargestPalendrome("caramel")); // ara
		System.out.println("Abba: " + getLargestPalendrome("AbbA")); // abba
		System.out.println("Monster: " + getLargestPalendrome("Monster")); // ""
	}
	
	/**
	 * Performs a dual loop to get each character and then the rest of the word, shrinking inside to 
	 * get every variation
	 * @param val
	 * @return
	 */
	public static String getLargestPalendrome(String val) {
		String palindrome = "";
		for (int i = 0; i < val.length(); i++) {
			for (int x = val.length(); x > 0; x--) {
				if (i >= x) break;
				String partial = val.substring(i,  x);

				if (isPalindrome(partial) && partial.length() > palindrome.length() && partial.length() > 1) {
					palindrome = partial;
				}
					
			}
		}
		
		return palindrome;
	}

	/**
	 * Reverse the string and compare to the original
	 * @param val
	 * @return
	 */
	private static boolean isPalindrome(String val){
		
		String newVal = "";
		for (int i=val.length()-1; i >= 0; i--) { newVal += val.charAt(i); }
	    return newVal.toString().equalsIgnoreCase(val);
	}

}
