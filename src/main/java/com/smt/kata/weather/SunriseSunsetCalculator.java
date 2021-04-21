package com.smt.kata.weather;

// JDK 11.x
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

// Google Gson 2.8.x
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
// Space Libs 1.x
import com.siliconmtn.data.format.DateFormat;
import com.siliconmtn.data.format.DateFormat.DatePattern;
import com.siliconmtn.data.text.StringUtil;
import com.siliconmtn.io.http.SMTHttpConnectionManager;
import com.siliconmtn.io.http.SMTHttpConnectionManager.HttpConnectionType;

/****************************************************************************
 * <b>Title:</b> SunriseSunsetCalculator.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> In this Kata, you will call out to a json api and format it into 
 * a data structure and return the data structure.  You will use the Gson json classes
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 20, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class SunriseSunsetCalculator {

	/**
	 * Base url for the sunrise sunset calculator
	 */
	public static final String SUNRISE_SUNSET_URL = "https://api.sunrise-sunset.org/json?";
	private SunriseSunsetVO results;
	private String status;
	
	/**
	 * 
	 */
	public SunriseSunsetCalculator() {
		super();
	}
	
	/**
	 * 
	 * @param date
	 * @param lat
	 * @param lng
	 * @throws IOException 
	 */
	public SunriseSunsetCalculator(Date date, double lat, double lng) throws IOException {
		super();
		this.getSunriseSunset(date, lat, lng);
	}
	
	/**
	 * 
	 * @param date
	 * @param lat
	 * @param lng
	 * @throws IOException 
	 */
	private void getSunriseSunset(Date date, double lat, double lng) throws IOException {
		// Build the URL
		StringBuilder sb = new StringBuilder(SUNRISE_SUNSET_URL);
		sb.append("lat=").append(lat).append("&lng=").append(lng).append("&date=");
		sb.append(DateFormat.toFormattedString(DatePattern.DATE_DASH, date));
		
		// Retrieve the data
		SMTHttpConnectionManager conn = new SMTHttpConnectionManager();
		byte[] response = conn.getRequestData(sb.toString(), null, HttpConnectionType.GET);

		// Convert the json into java object
		Gson g = new Gson();
		SunriseSunsetCalculator calc = g.fromJson(new String(response), SunriseSunsetCalculator.class);
		this.setResults(calc.getResults());
		this.setStatus(calc.getStatus());
	}
	
	/*
	 * (non-javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return StringUtil.getToString(this);
	}

	/**
	 * @return the results
	 */
	public SunriseSunsetVO getResults() {
		return results;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param results the results to set
	 */
	public void setResults(SunriseSunsetVO results) {
		this.results = results;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}

/**
 *  Inner Class data structure
 */
class SunriseSunsetVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1711126471696728890L;

	// Members
	private String sunrise;
	private String sunset;
	
	@SerializedName(value = "solar_noon", alternate = "solarNoon")
	private String solarNoon;
	
	@SerializedName(value = "day_length", alternate = "dayLength")
	private String dayLength;
	
	@SerializedName(value = "civil_twilight_begin", alternate = "civilTwilightBegin")
	private String civilTwilightBegin;
	
	@SerializedName(value = "civil_twilight_end", alternate = "civilTwilightend")
	private String civilTwilightEnd;
	
	@SerializedName(value = "nautical_twilight_begin", alternate = "nauticalTwilightBegin")
	private String nauticalTwilightBegin;
	
	@SerializedName(value = "nautical_twilight_end", alternate = "nauticalTwilightEnd")
	private String nauticalTwilightEnd;
	
	@SerializedName(value = "astronomical_twilight_begin", alternate = "astronomicalTwilightBegin")
	private String astronomicalTwilightBegin;
	
	@SerializedName(value = "astronomical_twilight_end", alternate = "astronomicalTwilightEnd")
	private String astronomicalTwilightEnd;

	/*
	 * (non-javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return StringUtil.getToString(this);
	}

	/**
	 * @return the sunrise
	 */
	public String getSunrise() {
		return sunrise;
	}

	/**
	 * @return the sunset
	 */
	public String getSunset() {
		return sunset;
	}

	/**
	 * @return the solarNoon
	 */
	public String getSolarNoon() {
		return solarNoon;
	}

	/**
	 * @return the dayLength
	 */
	public String getDayLength() {
		return dayLength;
	}

	/**
	 * @return the civilTwilightBegin
	 */
	public String getCivilTwilightBegin() {
		return civilTwilightBegin;
	}

	/**
	 * @return the civilTwilightEnd
	 */
	public String getCivilTwilightEnd() {
		return civilTwilightEnd;
	}

	/**
	 * @return the nauticalTwilightBegin
	 */
	public String getNauticalTwilightBegin() {
		return nauticalTwilightBegin;
	}

	/**
	 * @return the nautical_twilight_end
	 */
	public String getNauticalTwilightEnd() {
		return nauticalTwilightEnd;
	}

	/**
	 * @return the astronomicalTwilightBegin
	 */
	public String getAstronomicalTwilightBegin() {
		return astronomicalTwilightBegin;
	}

	/**
	 * @return the astronomicalTwilightEnd
	 */
	public String getAstronomicalTwilightEnd() {
		return astronomicalTwilightEnd;
	}

	/**
	 * @param sunrise the sunrise to set
	 */
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	/**
	 * @param sunset the sunset to set
	 */
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

	/**
	 * @param solarNoon the solarNoon to set
	 */
	public void setSolarNoon(String solarNoon) {
		this.solarNoon = solarNoon;
	}

	/**
	 * @param dayLength the dayLength to set
	 */
	public void setDayLength(String dayLength) {
		this.dayLength = dayLength;
	}

	/**
	 * @param civilTwilightBegin the civilTwilightBegin to set
	 */
	public void setCivilTwilightBegin(String civilTwilightBegin) {
		this.civilTwilightBegin = civilTwilightBegin;
	}

	/**
	 * @param civilTwilightEnd the civilTwilightEnd to set
	 */
	public void setCivilTwilightEnd(String civilTwilightEnd) {
		this.civilTwilightEnd = civilTwilightEnd;
	}

	/**
	 * @param nauticalTwilightBegin the nauticalTwilightBegin to set
	 */
	public void setNauticalTwilightBegin(String nauticalTwilightBegin) {
		this.nauticalTwilightBegin = nauticalTwilightBegin;
	}

	/**
	 * @param nautical_twilight_end the nautical_twilight_end to set
	 */
	public void setNauticalTwilightEnd(String nauticalTwilightEnd) {
		this.nauticalTwilightEnd = nauticalTwilightEnd;
	}

	/**
	 * @param astronomicalTwilightBegin the astronomicalTwilightBegin to set
	 */
	public void setAstronomicalTwilightBegin(String astronomicalTwilightBegin) {
		this.astronomicalTwilightBegin = astronomicalTwilightBegin;
	}

	/**
	 * @param astronomicalTwilightEnd the astronomicalTwilightEnd to set
	 */
	public void setAstronomicalTwilightEnd(String astronomicalTwilightEnd) {
		this.astronomicalTwilightEnd = astronomicalTwilightEnd;
	}
}
