package com.smt.kata.data;

// JDK 8.x
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: QueryStringParser.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Using the standard parsing of Query String rules, convert 
 * the query string elements into a Map of values.  All rules of query string 
 * will be implemented.  You may use collections and anything else not requiring
 * an import
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jan 5, 2021
 * @updates:
 ****************************************************************************/
public class QueryStringParser {

	/**
	 * Separates the KV and stores into a String, String[]
	 * @param qs
	 * @return
	 */
	public Map<String, List<String>> parseString(String qs){
		
		String[] pairs = qs.split("&");
		Map<String, List<String>> mapping = new HashMap<>();
		
		for (String pair : pairs) {
			String[] kv = pair.split("=");
			String key = kv[0];
			String value = decode(kv.length == 2 ? kv[1] : "");
			
			if (mapping.containsKey(kv[0])) {
			
				List<String> vals = mapping.get(key);
				vals.add(value);
			} else {
				List<String> values = new ArrayList<>();
				values.add(value);
				mapping.put(key, values);
			}
		}
		
		return mapping;
	}
	
	/**
	 * Decodes an individual value
	 * @param val
	 * @return
	 */
	private String decode(String val) {
		if (val.isEmpty()) return val;
		
		List<String> replaceVals = new ArrayList<>();
		
		for (int i=0; i < val.length(); i++) {
			if (val.charAt(i) == '%') {
				replaceVals.add(val.charAt(i + 1) + "" + val.charAt(i + 2));
			}
		}
		
		
		val = val.replace('+',  ' ');
		for (String replaceVal : replaceVals) {
			val = val.replaceAll("%" + replaceVal,  (char)Integer.parseInt(replaceVal, 16) + "");
		}
		
		return val;
	}

}
