package com.smt.kata.code;

// JDK 11.x
import java.util.Arrays;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: DashatizeIt.java 
 * <b>Project</b>: SMT-Kata 
 * <b>Description: </b> Dashatize It
 * 
 * Given a variable n,
 * 
 * If n is an integer, Return a string with dash'-'marks before and after each
 * odd integer, but do not begin or end the string with a dash mark. If n is
 * negative, then the negative sign should be removed.
 * 
 * If n is not an integer, return an empty value.
 * 
 * Ex:
 * dashatize(274) -> '2-7-4' 
 * dashatize(6815) -> '68-1-5'
 * 
 * <b>Copyright:</b> Copyright (c) 2021 
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
public class DashatizeIt {

	/**
	 * Formats the string of numbers into a Dashatize format
	 * @param input String to be processed.  All non numeric characters are omitted
	 * @return Formatted string.  Empty string if input is empty or null
	 */
    public String process(String input) {
    	if (StringUtil.isEmpty(input)) { return ""; }
        
        // Strip the non-alphas and convert to an int array
        int[] digits = Arrays
                .stream(String.valueOf(input).split(""))
                .filter(s -> Character.isDigit(s.charAt(0)))
                .mapToInt(Integer::valueOf)
                .toArray();
        
        // Loop the digit and append to the string builder
        return format(digits);
    }
    
    /**
     * Loops the digits array and formats into the proper structure
     * @param digits Array of digits to process
     * @return Formatted string
     */
    private String format(int[] digits) {
        boolean previousOdd = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            int j = digits[i];
            
            // Based on whether the character is odd or even, append characters
            if (j % 2 != 0) {
                result.append("-");
                result.append(j);
                previousOdd = true;
            } else {
                if (previousOdd) {
                    previousOdd = false;
                    result.append("-");
                }
                
                result.append(j);
            }
        }
        
        // Since we prepend the "-", need to strip it if it exists
        String output = result.toString();
        return output.startsWith("-") ? output.substring(1) : output;
    }
}
