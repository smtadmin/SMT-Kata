package com.smt.kata.object;

// JDK 11.x
import java.util.Arrays;

/****************************************************************************
 * <b>Title:</b> TimeMap.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> TimeMap
 * 
 * Write a map implementation with a get function that lets you retrieve the 
 * value of a key at a particular time.  You may NOT use collections.  You should 
 * utilize an array to store the data
 * 
 * It should contain the following methods:
 * 
 * set(key, value, time): sets key to value for t = time.
 * 
 * get(key, time): gets the key at t = time.
 * 
 * The map should work like this. If we set a key at a particular time, it will 
 * maintain that value forever or until it gets set at a later time. In other words, 
 * when we get a key at a time, it should return the value that was set for that 
 * key set at the most recent time.
 * 
 * Consider the following examples:
 * 
 * d.set(1, 1, 0) # set key 1 to value 1 at time 0
 * d.set(1, 2, 2) # set key 1 to value 2 at time 2
 * d.get(1, 1) # get key 1 at time 1 should be 1
 * d.get(1, 3) # get key 1 at time 3 should be 2
 * 
 * Another Example:
 * d.set(1, 1, 5) # set key 1 to value 1 at time 5
 * d.get(1, 0) # get key 1 at time 0 should be null
 * d.get(1, 10) # get key 1 at time 10 should be 1
 * 
 * Another Example:
 * d.set(1, 1, 0) # set key 1 to value 1 at time 0
 * d.set(1, 2, 0) # set key 1 to value 2 at time 0
 * d.get(1, 0) # get key 1 at time 0 should be 2
 * 
 * For this Kata, you may not use ANY imports in the collections (java.util.*), 
 * EXCEPT you may java.util.Arrays.  You may NOT use inner classes for this Kata
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 14, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class TimeMap<K,V> {
	
	// Members
	private int defaultSize = 8;
	private TimeMap<K,V>[] items;
	private int currSize = 0;
	private K key;
	private V value;
	private int time;
	
	/**
	 * Initializes the array
	 */
	@SuppressWarnings("unchecked")
	public TimeMap() {
		super();
		items = new TimeMap[defaultSize];
	}
	
	/**
	 * Constructor that populates all items.  Private, used by internal processes
	 * @param key Key of the item
	 * @param value Value of the item
	 * @param time Index of the item
	 */
	private TimeMap(K key, V value, int time) {
		this();
		this.key = key;
		this.value = value;
		this.time = time;
	}
	
	/*
	 * (non-javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return key + "|" + value + "|" + time;
	}
	
	/**
	 * Key value
	 * @return Key
	 */
	private K getKey() {
		return key;
	}

	/**
	 * Value of the TimeMap
	 * @return Value assigned
	 */
	private V getValue() {
		return value;
	}

	/**
	 * Time index
	 * @return int with the time index
	 */
	private int getTime() {
		return time;
	}
	
	/**
	 * Size of the Map
	 * @return integer with the current size
	 */
	public int size() {
		return currSize;
	}

	/**
	 * Sets TimeMap properties
	 * @param key Key of the TimeMap
	 * @param value Value of the TimeMap
	 * @param time Index of the TimeMap
	 */
	public void set(K key, V value, int time) {
		
		// If the array is filled, create an new array
		if ((currSize % defaultSize) < 1) {
			items = Arrays.copyOf(items, currSize + defaultSize);
		}
		
		// Add a new TimeMap to the array
		items[currSize++] = new TimeMap<>(key, value, time);
	}
	
	/**
	 * Gets the TimeMap object at the given index
	 * @param index index to return the time map
	 * @return TimeMap in the provided index.  Null if OOB or missing
	 */
	public TimeMap<K,V> get(int index) {
		if (index > items.length || index < 0) return null;
		return items[index];
	}
	
	/**
	 * Gets the value of the TimeMap at the given key/time
	 * @param key Key to find the value
	 * @param time Time index
	 * @return Value of the matching key and time
	 */
	public V get(K key, int time) {
		V altValue = null;
		int maxTime = -1;
		boolean exact = false;
		for (TimeMap<K,V> t : items) {
			if (t != null && key == t.getKey()) {
				if (time == t.getTime()) {
					altValue =  t.getValue();
					exact = true;
				} else if (!exact && t.getTime() > maxTime) {
					altValue =  t.getValue();
					maxTime = t.getTime();
				}
			}
		}
		
		return altValue;
	}
}
