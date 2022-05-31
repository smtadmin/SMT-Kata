package com.smt.kata.time;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * The Berlin Clock (Mengenlehreclock or Berlin Uhr) is a clock that tells the
 * time using a series of illuminated coloured blocks, as you can see in the
 * picture for this project.
 * 
 * https://agilekatas.co.uk/img/katas/kata_berlinclock.png
 * 
 * The top lamp blinks to show seconds- it is illuminated on even seconds (R)
 * and off on odd seconds (0).
 * 
 * The next two rows represent hours (R). The upper row represents 5 hour blocks
 * and is made up of 4 red lamps, off being (0). The lower row represents 1 hour
 * blocks and is also made up of 4 red lamps (R), off being (0).
 * 
 * The final two rows represent the minutes (Y). The upper row represents 5
 * minute blocks, and is made up of 11 lamps- every third lamp is red (R), the
 * rest are yellow (Y) or off (0). The bottom row represents 1 minute blocks,
 * and is made up of 4 yellow(Y) lamps, off being (0).
 * 
 * Requirements:
 * 
 * Input should be validated that it meets a 24H digital time format between
 * 00:00:00 through 23:59:59
 * 
 * GenerateTime should return a String representing
 * {sec}{5Hours}{1Hours}{5Minutes}{1Minute} Methods should return null if
 * invalid.
 * 
 * Examples:
 * 
 * Time 		Clock 
 * 00:00:00 	YOOOOOOOOOOOOOOOOOOOOOOO
 * 23:59:59		ORRRRRRROYYRYYRYYRYYYYYY
 * 16:50:06		YRRROROOOYYRYYRYYRYOOOOO
 * 11:37:01		ORROOROOOYYRYYRYOOOOYYOO
 * 
 * -01:00:00	null
 * 24:00:00		null
 * 23:59:60		null
 * 23:60:59		null
 * aa:bb:cc		null
 * 
 * @author raptor
 *
 */
public class BerlinClock {

	/**
	 * As a clock user I want to be able to see an entire clock So that I can tell
	 * what time it is at a glance
	 * 
	 * @param time
	 * @return
	 */
	public String generateTime(String time) {
		String t = null;
		if (verifyTime(time)) {
			StringBuilder str = new StringBuilder(25);
			str.append(generateSeconds(time));
			str.append(generateFiveHoursRow(time));
			str.append(generateSingleHoursRow(time));
			str.append(generateFiveMinutesRow(time));
			str.append(generateSingleMinutesRow(time));
			t = str.toString();
		}
		return t;
	}

	/**
	 * As a clock user I want to be able to see single minutes So that I can
	 * accurately tell the time down to the minute
	 * 
	 * @param time
	 * @return
	 */
	public String generateSingleMinutesRow(String time) {
		String min = null;
		if (verifyTime(time)) {
			int mins = Integer.parseInt(time.split(":")[1]) % 5;

			min = StringUtils.repeat('Y', mins) + StringUtils.repeat('0', 4 - mins);
		}
		return min;
	}

	/**
	 * As a clock user I want to be able to see five minutes So that I can tell
	 * higher minute amounts more easily at a glance
	 * 
	 * @param time
	 * @return
	 */
	public String generateFiveMinutesRow(String time) {
		String min = null;
		if (verifyTime(time)) {
			int mins = Integer.parseInt(time.split(":")[1]) / 5;

			min = StringUtils.repeat('Y', mins) + StringUtils.repeat('0', 11 - mins);

			int qtrs = Integer.parseInt(time.split(":")[1]) / 15;
			char[] minC = min.toCharArray();
			for (int i = 0; i < qtrs; i++) {
				minC[i * 3 + 2] = 'R';
			}
			min = new String(minC);
		}
		return min;
	}

	/**
	 * As a clock user I want to be able to see single hours So that I can tell what
	 * hour it is
	 * 
	 * @param time
	 * @return
	 */
	public String generateSingleHoursRow(String time) {
		String hour = null;
		if (verifyTime(time)) {
			int hours = Integer.parseInt(time.split(":")[0]) % 5;

			hour = StringUtils.repeat('R', hours) + StringUtils.repeat('0', 4 - hours);
		}
		return hour;
	}

	/**
	 * As a clock user I want to be able to see five hours So that I can tell higher
	 * hour amounts more easily at a glance
	 * 
	 * @param time
	 * @return
	 */
	public String generateFiveHoursRow(String time) {
		String hour = null;
		if (verifyTime(time)) {
			int hours = Integer.parseInt(time.split(":")[0]) / 5;

			hour = StringUtils.repeat('R', hours) + StringUtils.repeat('0', 4 - hours);
		}
		return hour;
	}

	/**
	 * As a clock user I want to be able to see seconds passing So that I can see if
	 * my clock is working at a glance
	 * 
	 * @param time
	 * @return
	 */
	public String generateSeconds(String time) {
		String sec = null;
		if (verifyTime(time)) {
			sec = Integer.parseInt(time.split(":")[2]) % 2 == 0 ? "Y" : "0";
		}
		return sec;
	}

	public boolean verifyTime(String time) {
		return StringUtils.isNotEmpty(time) && Pattern.matches("[0-2][0-9]:[0-5][0-9]:[0-5][0-9]", time);
	}
}
