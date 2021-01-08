package siliconmtn.kata.simple;

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
	 * Creates a variety of test cases to validate the sw
	 * @param args
	 */
	public static void main(String args[]) {
		String qs = "name=james";
		System.out.println("QS: " + parseString(qs)); 
		// {name=[james]}
		
		qs = "name=james%26mary&business=smt+company";
		System.out.println("QS: " + parseString(qs)); 
		// {business=[smt company], name=[james&mary]}
		
		qs = "name=james%26mary%20camire&business=smt+company&type=";
		System.out.println("QS: " + parseString(qs)); 
		// {business=[smt company], name=[james&mary camire], type=[]}
		
		qs = "name=james%26mary%20camire&business=smt+company&type=&name=Mike";
		System.out.println("QS: " + parseString(qs));
		// {business=[smt company], name=[james&mary camire, Mike], type=[]}
		
		qs = "business=smt%3drules&";
		System.out.println("QS: " + parseString(qs));
		// {business=[smt=rules]}
	}

	
	private static Map<?,?> parseString(String qs){
		
		String[] pairs = qs.split("&");
		Map<String, List<String>> mapping = new HashMap<>();
		
		for (String pair : pairs) {
			String[] kv = pair.split("=");
			String key = kv[0];
			String value = decode(kv.length == 2 ? kv[1] : "");
			
			if (mapping.containsKey(kv[0])) {
			
				List<String> vals = mapping.get(kv[0]);
				vals.add(value);
			} else {
				List<String> values = new ArrayList<>();
				values.add(value);
				mapping.put(kv[0], values);
			}
		}
		
		return mapping;
	}
	
	/**
	 * 
	 * @param val
	 * @return
	 */
	private static String decode(String val) {
		if (val.isEmpty()) return val;
		
		List<String> replaceVals = new ArrayList<>();
		
		for (int i=0; i < val.length(); i++) {
			if (val.charAt(i) == '%' && (i + 2) < val.length()) {
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
