package com.smt.kata.distance.bean;

/****************************************************************************
 * <b>Title:</b> MatchCode.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 21, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public enum MatchCode {
	ADDRESS(50, "Address"),
	INTERSECTION(45, "Intersection"),
	STREET(40, "Street Only"),
	ZIP_CODE(35, "Zip Code"),
	CITY(30, "City"),
	COUNTY(25, "County"),
	STATE(20, "State"),
	COUNTRY(15, "Country"),
	MANUAL(10, "Manually Assigned"),
	POINT_OF_INTEREST(5, "Point of Interest"),
	NO_MATCH(0, "Unable to find a match");
	
	int rank;
	String label;
	
	public int getRank() { return rank; }
	public String getLabel() { return label; }
	
	MatchCode(int rank, String label) {
		this.rank = rank;
		this.label = label;
	}
	
	/**
	 * Converts the geocode response type to a match code
	 * @param gt
	 * @return
	 */
    public static MatchCode getMatchCode(String gt) {
		switch (gt) {
			case "address":
				return MatchCode.ADDRESS;
			case "city":
				return MatchCode.CITY;
			case "country":
				return MatchCode.COUNTRY;
			case "county" :
				return MatchCode.COUNTY;
			case "state":
				return MatchCode.STATE;
			case "street":
				return MatchCode.STREET;
			case "zipCode":
				return MatchCode.ZIP_CODE;
			default:
				return MatchCode.NO_MATCH;
		}
    }
}
