package com.smt.kata.time;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class BerlinClock {

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

	public String generateSingleMinutesRow(String time) {
		String min = null;
		if (verifyTime(time)) {
			int mins = Integer.parseInt(time.split(":")[1]) % 5;

			min = StringUtils.repeat('Y', mins) + StringUtils.repeat('0', 4 - mins);
		}
		return min;
	}

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

	public String generateSingleHoursRow(String time) {
		String hour = null;
		if (verifyTime(time)) {
			int hours = Integer.parseInt(time.split(":")[0]) % 5;

			hour = StringUtils.repeat('R', hours) + StringUtils.repeat('0', 4 - hours);
		}
		return hour;
	}

	public String generateFiveHoursRow(String time) {
		String hour = null;
		if (verifyTime(time)) {
			int hours = Integer.parseInt(time.split(":")[0]) / 5;

			hour = StringUtils.repeat('R', hours) + StringUtils.repeat('0', 4 - hours);
		}
		return hour;
	}

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
