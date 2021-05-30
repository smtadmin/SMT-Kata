package com.smt.kata.word;

// JDK 11.x
import java.util.Arrays;
import java.util.stream.Collectors;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title</b>: OrderPlease.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
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
                .sorted((o1, o2) -> {
                    int numberOfFirstString = Integer.parseInt(0 + o1.replaceAll("\\D+", ""));
                    int numberOfSecondString = Integer.parseInt(0 + o2.replaceAll("\\D+", ""));
                    return Integer.compare(numberOfFirstString, numberOfSecondString);
                })
                .collect(Collectors.joining(" "));
    }
}
