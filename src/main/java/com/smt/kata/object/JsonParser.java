package com.smt.kata.object;

// JDK 11.x
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import java.io.InputStreamReader;

/****************************************************************************
 * <b>Title</b>: JsonParser.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Json Parser
 * Write a function to flatten a nested dictionary. Namespace the keys with a period.
 * 
 * For example, given the following dictionary:
 * 
 * {
 *     "key": 3,
 *     "foo": {
 *         "a": 5,
 *         "bar": {
 *             "baz": 8
 *         }
 *     }
 * }
 * 
 * it should become:
 * 
 * {
 *     "key": 3,
 *     "foo.a": 5,
 *     "foo.bar.baz": 8
 * }
 * 
 * You can assume keys do not contain dots in them, i.e. no clobbering will occur.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 19, 2021
 * @updates:
 ****************************************************************************/
public class JsonParser {

	/**
	 * Parses the json string and returns a map of unique keys and values
	 * @param json Json object to parse
	 * @return Map of keys and values.  Values are mapped to their data types
	 * @throws IOException 
	 */
	public Map<String, Object> parse(String json) throws IOException {
		Map<String, Object> data = new HashMap<>();
		assignValues(data, StringUtils.defaultString(json, ""));
		return data;
	}
	
	/**
	 * Assigns the values to the map
	 * @param data Map of keys form the json
	 * @param json Object to parse
	 * @throws IOException
	 */
	private void assignValues(Map<String, Object> data, String json) throws IOException {
		try (ByteArrayInputStream bais = new ByteArrayInputStream(json.getBytes())) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(bais))) {
				String line = "";
				String prevKey = "";
				while((line = br.readLine()) != null) {
					prevKey = processLine(line, prevKey, data);
					
				}
			}
		}
	}
	
	/**
	 * Parses each line of the json object
	 * @param line Individual line to process
	 * @param prevKey Keeps track of the base key
	 * @param data Map of keys and values for the json object
	 * @return Updated previous key
	 */
	private String processLine(String line, String prevKey, Map<String, Object> data) {
		line = removeChars(line);
		
		if (line.contains("}")) {
			prevKey = prevKey.contains(".") ? prevKey.substring(0, prevKey.lastIndexOf(".")) : "";
		} else if (line.contains(":") && line.contains("{")) {
			line = line.replace("{", "");
			String[] keys = line.split(":");
			prevKey += (prevKey.length() == 0 ? "" : ".") + keys[0].trim();
		} else if (! line.contains("{")) {
			String[] keys = line.split(":");
			prevKey += (prevKey.length() == 0 ? "" : ".") + keys[0].trim();
			data.put(prevKey, assignVars(keys[1].trim()));
			prevKey = prevKey.contains(".") ? prevKey.substring(0, prevKey.lastIndexOf(".")) : "";
		}
		
		return prevKey;
	}
	
	/**
	 * Converts the value to a specific data type
	 * @param value Value of the node
	 * @return Converted data object
	 */
	private Object assignVars(String value) {
		if (StringUtils.isNumeric(value.trim())) return Integer.parseInt(value);
		else return value;
	}
	
	/**
	 * Cleans up each line of code
	 * @param line Code to clean
	 * @return Cleaned version
	 */
	private String removeChars(String line) {
		line = line.replace("'", "");
		line = line.replace(",", "");
		line = line.replace("\t", "");
		line = line.replace("\n", "");
		
		return line;
	}
}
