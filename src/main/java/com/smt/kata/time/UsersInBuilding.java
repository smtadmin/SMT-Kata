package com.smt.kata.time;

// JDK 11.x
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: UsersInBuilding.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Users In Building
 * You are given a list of data entries that represent entries and exits of groups 
 * of people into a building. An entry looks like this:
 * 
 * {"timestamp": 1526579928, count: 3, "type": "enter"}
 * 
 * This means 3 people entered the building. An exit looks like this:
 * 
 * {"timestamp": 1526580382, count: 2, "type": "exit"}
 * 
 * This means that 2 people exited the building. timestamp is in Unix time.
 * 
 * Find the busiest period in the building, that is, the time with the most people 
 * in the building. Return it as response object (start, end, count). You can assume 
 * the building always starts off and ends up empty, i.e. with 0 people inside.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 28, 2021
 * @updates:
 ****************************************************************************/
public class UsersInBuilding {

	private Map<Date, Integer> transactions = new LinkedHashMap<>();
	protected enum EntryType { ENTER, EXIT }
	private int total = 0;
	
	/**
	 * Initializes the counts and transactions
	 */
	public UsersInBuilding() {
		transactions.put(new Date(), 0);
		total = 0;
	}

	/**
	 * Adds an entry of users entering or exiting the 
	 * @param entryTime Time of the transaction
	 * @param count Number of people 
	 * @param type Entering or exiting the building
	 */
	public void addEntry(Date entryTime, int count, EntryType type) {
		if (EntryType.ENTER.equals(type)) total += count;
		else total -= count;
		
		transactions.put(entryTime, total);
	}
	
	/**
	 * Calculates the busy period for the day
	 * @return
	 */
	public Response getBusyPeriod() {
		Response r = new Response();
		if (transactions.size() < 2) return r;
		
		r.count = getHighestCount();
		r.start = getStartTime(r.count);
		r.end = getEndTime(r.count);
		return r;
	}
	
	/**
	 * Finds the time of the highest total people in the building
	 * @return Count of the total
	 */
	private int getHighestCount() {
		int count = 0;
		for(Map.Entry<Date, Integer> entry : transactions.entrySet()) {
			if (entry.getValue() > count) count = entry.getValue();
		}
		
		return count;
	}
	
	/**
	 * Gets the start time of the most people in the building
	 * @param total Count to match
	 * @return
	 */
	private Date getStartTime(int total) {
		for(Map.Entry<Date, Integer> entry : transactions.entrySet()) {
			if (entry.getValue() == total) return entry.getKey();
		}
		
		return null;
	}
	
	/**
	 * Gets the end time for having the most people in the building
	 * @param total Max number of people in the building
	 * @return Date of the end time
	 */
	private Date getEndTime(int total) {
		boolean isTotal = false;
		for(Map.Entry<Date, Integer> entry : transactions.entrySet()) {
			if (entry.getValue() == total) isTotal = true;
			else if (isTotal) return entry.getKey();
		}
		
		return null;
	}
	
	/**
	 * Simple object to hold the response
	 */
	class Response {
		Date start;
		Date end;
		int count = 0;
		public Date getStart() { return start;}
		public Date getEnd() { return end; }
		public int getCount() { return count; }
	}
}
