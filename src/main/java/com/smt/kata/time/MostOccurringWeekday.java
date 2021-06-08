package com.smt.kata.time;

// JDK 11.x
import java.util.ArrayList;
import java.util.Calendar;
import java.util.EnumMap;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: MostOccurringWeekday.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> Most-Occurring Weekdays in a Year
 * 
 * Find the weekdays that occur the most in a given year.
 * 
 * Write a function MostOccurringWeekday that takes an integer representing a 
 * year as input and returns a list of the most-occurring weekdays throughout that year.
 * 
 * =MostOccurringWeekday[2018]
 * {Monday}
 * 
 * MostOccurringWeekday[2009]
 * {Thursday}
 * 
 * Multiple weekdays occurred the most in 2012:
 * 
 * MostOccurringWeekday[2012]
 * {Sunday, Monday}
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 10, 2021
 * @updates:
 ****************************************************************************/
public class MostOccurringWeekday {
	/**
	 * Enum for the day of the week
	 */
	public enum WeekDay {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}
	
	/**
	 * Calculates the most occurring week day fo rthe given year 
	 * @param year Year to calculate against
	 * @return Collection of weekdays
	 */
	public List<WeekDay> calculate(int year) {
		List<WeekDay> mostOccurring = new ArrayList<>();
		EnumMap<WeekDay, Integer> values = new EnumMap<>(WeekDay.class);
		int offset = year < 0 ? 2 : 1;
		
		// Get the first day of the year (months start with 0).  If less than 0, 
		// use BC Calendar
		Calendar cal = Calendar.getInstance();
		if (year < 0) cal.set(Calendar.ERA,GregorianCalendar.BC);
		cal.set(year, 0, 1);
		
		// Loop the days until the end of the year and count the occurrences of each day
		while(cal.get(Calendar.YEAR) < (Math.abs(year) + offset)) {
			int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			WeekDay day = WeekDay.values()[dayOfWeek - 1];
			
			if (values.containsKey(day)) values.put(day, values.get(day) + 1);
			else values.put(day, 1);
			
			cal.add(Calendar.DAY_OF_YEAR, 1);
		}
		
		// Get the largest value
		assignLargest(values, mostOccurring);
		
		// Return the collection of most occurring
		return mostOccurring;
	}
	
	/**
	 * Assign the weekdays that match the largest values to the list of most occurring
	 * @param largest
	 * @param values
	 * @param mostOccurring
	 */
	private void assignLargest(Map<WeekDay, Integer> values, List<WeekDay> mostOccurring) {
		int largest = getLargestValue(values);
		
		for (Map.Entry<WeekDay, Integer> entry : values.entrySet()) {
			if (entry.getValue() == largest) mostOccurring.add(entry.getKey());
		}
	}
	
	/**
	 * Gets the largest value in the values map
	 * @param values Values map which has totals for each day
	 * @return Largest value for all entries
	 */
	private int getLargestValue(Map<WeekDay, Integer> values) {
		int largest = 0;
		for (Map.Entry<WeekDay, Integer> entry : values.entrySet()) {
			if (entry.getValue() > largest) largest = entry.getValue();
		}
		
		return largest;
	}
}
