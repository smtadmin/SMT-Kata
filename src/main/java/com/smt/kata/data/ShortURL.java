package com.smt.kata.data;

// JDK 11
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// Apache commons 3.x
import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: ShortURL.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Implement a URL shortener with the following methods: 
 * shorten(url), which shortens the url into a six-character alphanumeric string, 
 * such as ZLG6WL.
 * 
 * restore(short), which expands the shortened string into the original url. 
 * If no such shortened string exists, return null.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Mar 3, 2021
 * @updates:
 ****************************************************************************/
public class ShortURL {
	/**
	 * Holds all of the short urls to full url mapping
	 */
	private Map<String, String> urlMap = new HashMap<>();
	
	/**
	 * Holds the list of available characters
	 */
	private List<Character> charList = new ArrayList<>();
	
	
	public ShortURL() {
		super();
		for (int i=48; i < 91; i++) {
			if (i > 57 && i < 65) continue;
			charList.add(Character.valueOf((char)i));
		}
	}
	
	/**
	 * Converts
	 * @param url Full URL to be shortened
	 * @param length Must be at least 4 
	 * @return
	 */
	public String shortenUrl(String url, int length) {
		if (StringUtils.isEmpty(url) || length < 5) return null;
		
		StringBuilder phrase = new StringBuilder(length);
		for (int i=0; i < length; i++) {
			phrase.append(getRandom());
		}
		
		urlMap.put(phrase.toString(), url);
		return phrase.toString();
	}
	
	/**
	 * Returns the full URL
	 * @param code
	 * @return
	 */
	public String restore(String code) {
		
		return urlMap.get(code);
	}
	
	/**
	 * Gets a random character from the char list
	 * @return
	 */
	public char getRandom() {
		return charList.get(new Random().nextInt(charList.size()));
	}
}
