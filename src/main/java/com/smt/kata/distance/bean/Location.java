package com.smt.kata.distance.bean;

// JDK 11.x
import java.io.Serializable;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;

/****************************************************************************
 * <b>Title:</b> Location.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Data structure to hold a geocoded location
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 21, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7171033548379700133L;
	
	// Members
	protected String address;
	protected String address2;
	protected String city;
	protected String county;
	protected String zipCode;
	protected String zipSuffixCode;
	protected String state;
	protected String country;
	protected String countryName;
	protected double latitude = 0.0;
	protected double longitude = 0.0;
	protected MatchCode matchCode = MatchCode.NO_MATCH;
	
	/**
	 * Default constructor
	 */
	public Location() {
		super();
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @return the zipSuffixCode
	 */
	public String getZipSuffixCode() {
		return zipSuffixCode;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @return the matchCode
	 */
	public MatchCode getMatchCode() {
		return matchCode;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @param zipSuffixCode the zipSuffixCode to set
	 */
	public void setZipSuffixCode(String zipSuffixCode) {
		this.zipSuffixCode = zipSuffixCode;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @param matchCode the matchCode to set
	 */
	public void setMatchCode(MatchCode matchCode) {
		this.matchCode = matchCode;
	}
}
