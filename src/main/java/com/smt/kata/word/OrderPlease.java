package com.smt.kata.word;

// JDK 11.x
import java.util.Arrays;
import java.util.stream.Collectors;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: OrderPlease.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Order Please Kata
 * 
 * Our task is to sort a given string. Each word in the string will contain a 
 * single number. This number is the position the word should have in the result.
 * 
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * 
 * If the input string is empty, return an empty string. The words in the input
 * String will only contain valid consecutive numbers.
 * If a word does not have a number, default it to 0
 * 
 * For Example:
 * Input: "is2 Thi1s T4est 3a"
 * Output: "Thi1s is2 3a T4est"
 * 
 * Input: "We1 1the p1eople i1n o1rder t1o 1form 1a 1more 1perfect 1union"
 * Output: "We1 1the p1eople i1n o1rder t1o 1form 1a 1more 1perfect 1union"
 * 
 * Input: "4of Fo1r pe6ople g3ood th5e the2"
 * Output: "Fo1r the2 g3ood 4of th5e pe6ople"
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 30, 2021
 * @updates:
 ****************************************************************************/
public class OrderPlease {

	
	public String reorder(String phrase) {
        return Arrays
            .stream(StringUtil.isEmpty(phrase) ? new String[0] : phrase.split(" "))
            .sorted((o1, o2) -> Integer.compare(Integer.parseInt(0 + o1.replaceAll("\\D+", "")), Integer.parseInt(0 + o2.replaceAll("\\D+", ""))))
            .collect(Collectors.joining(" "));
    }
}
