package com.smt.kata.data;

import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: CorretTheTime.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Correct the Time.  You have to create a method, 
 * that corrects a given time string.  There was a problem in addition, 
 * so many of the time strings are broken.
 * Time is formatted using the 24-hour clock, so from 00:00:00 to 23:59:59:
 * Examples
 * "09:10:01" -> "09:10:01"  
 * "11:70:10" -> "12:10:10"  
 * "19:99:99" -> "20:40:39"  
 * "24:01:01" -> "00:01:01" 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 24, 2021
 * @updates:
 ****************************************************************************/
public class CorrectTheTime {

	/**
	 * 
	 */
	public CorrectTheTime() {
		super();
	}
	
	public String transform(String time) {
		if (StringUtils.isEmpty(time)) return "";
		String[] parts = time.split(":");
		
		int hour = 0;
		int minute = 0;
		int sec = 0;
		
		if (Integer.parseInt(parts[2]) >= 60) {
			sec = Integer.parseInt(parts[2]) - 60;
			minute = minute + 1;
		} else {
			sec = Integer.parseInt(parts[2]);
		}
		
		if (Integer.parseInt(parts[1]) >= 60) {
			minute += (Integer.parseInt(parts[1]) - 60);
			hour++;
		} else {
			minute += Integer.parseInt(parts[1]);
		}
		
		if (Integer.parseInt(parts[0]) >= 24) hour += (Integer.parseInt(parts[0]) % 24);
		else hour += Integer.parseInt(parts[0]);
		
		return formatTime(hour, minute, sec);
	}
	
	/**
	 * 
	 * @param hour
	 * @param minute
	 * @param sec
	 * @return
	 */
	private String formatTime(int hour, int minute, int sec) {
		StringBuilder s = new StringBuilder(16);
		s.append(convertInt(hour)).append(":")
		 .append(convertInt(minute)).append(":")
		 .append(convertInt(sec));
		
		
		return s.toString();
	}
	
	/**
	 * Pads the number into 2 characters
	 * @param val
	 * @return
	 */
	private String convertInt(int val) {
		return val >= 10 ? String.valueOf(val) : "0" + val;
	}

}
