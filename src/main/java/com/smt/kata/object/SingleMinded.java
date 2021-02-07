package com.smt.kata.object;

// JDK 11.x
import java.util.HashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: SingleMinded.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Kata challenge.  Create a class that only has one instance
 * in its lifecycle.  This is called a "Singleton Pattern" or Singleton.  Create 
 * a Singleton class that keeps a collection of configuration items (key and value)
 * that can be shared across many classes.  The collection will have an add, remove and
 * get method to manage the collection.
 * 
 * The unit test will help identify the names of the methods needed to fulfill this
 * kata challenge
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 7, 2021
 * @updates:
 ****************************************************************************/
public class SingleMinded {
	/**
	 * The one and only instance that will exist
	 */
	protected static SingleMinded singleMinded = null;
	
	/**
	 * Object store for the app configuration
	 */
	private Map<String, String> config = new HashMap<>();

	/**
	 * 
	 */
	private SingleMinded() {
		super();
	}
	
	/**
	 * Returns a single instance of the single minded class
	 * @return Instance of this class
	 */
	public static SingleMinded getInstance() {
		if (singleMinded == null) singleMinded = new SingleMinded();
		
		return singleMinded;
	}
	
	/**
	 * Adds an item to the configuration map.  If a key already exists, the value
	 * will be updated with the new value
	 * @param key Item key by which it is referenced
	 * @param value Value to store for the specified key
	 */
	public void addConfigItem(String key, String value) {
		config.put(key, value);
	}
	
	/**
	 * Removes an item from the configuration map
	 * @param key Map key of the item to remove
	 */
	public void removeConfigItem(String key) {
		config.remove(key);
	}

	/**
	 * Collection of configuration items to retrieve
	 * @return config collection
	 */
	public Map<String, String> getConfig() {
		return config;
	}
	
	/**
	 * Retrieves a configuration item
	 * @param key Key to search against the config collection
	 * @return Value corresponding to the provided key.  Null otherwise
	 */
	public String getConfigItem(String key) {
		return config.get(key);
	}
}
