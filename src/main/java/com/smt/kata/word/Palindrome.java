package com.smt.kata.word;

/****************************************************************************
 * <b>Title</b>: Palindrome.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> This program does not use any API method instead it uses 
 * division and remainder operator of Java programming language to determine if 
 * number is palindrome or not.  No Strings, StringBuilders, or Collections are allowed.  
 * Arrays are not to be used in the calculation of the palindrome (only as source for the output)
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class Palindrome {

	/**
	 * Reverse the number and compare to the original
	 * @param startNumber
	 * @return
	 */
	public boolean isPalindrome(int startNumber){
		int number = startNumber;
	    int reverse = 0;     
	    while(number != 0){
	      reverse = reverse*10 + number%10; 
	      number = number/10;
	    }
	    
	    return reverse == startNumber;
	}

}
