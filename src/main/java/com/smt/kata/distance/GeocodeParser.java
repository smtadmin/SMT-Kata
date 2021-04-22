package com.smt.kata.distance;

// JDK 11.x
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

// Spacelibs 1.x
import com.siliconmtn.data.text.StringUtil;
import com.siliconmtn.io.http.SMTHttpConnectionManager;
import com.siliconmtn.io.http.SMTHttpConnectionManager.HttpConnectionType;

// Kata imports
import com.smt.kata.distance.bean.Location;
import com.smt.kata.distance.bean.MatchCode;

/****************************************************************************
 * <b>Title:</b> GeocodeParser.java
 * <b>Project:</b> SMT-Kata
 * <b>Description:</b> Geocode Parser
 * 
 * In this kata, you must connect to an SMT geocoder and parse the response into 
 * the provided location object (com.smt.kata.distance.bean.Location)
 * 
 * The response from the geocoder is in XML format.  You may use any libraries
 * that are included in the JDK.  The javax.xml, javax.xml.parsers and org.w3c.dom
 * are great places to start.  You may use Xpath or DocumentBuilders to solve
 * this kata.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Apr 21, 2021
 * <b>updates:</b>
 * 
 ****************************************************************************/
public class GeocodeParser {
	
	/**
	 * Base URL
	 * Example: http://smtproxy-dev.aws.siliconmtn.com/websvc/geocoder?addr=&city=&state=&zip=80211&country=US
	 */
	public static final String SMT_GEO_URL = "http://smtproxy-dev.aws.siliconmtn.com/websvc/geocoder?";
	
	/**
	 * 
	 */
	public GeocodeParser() {
		super();
	}

	/**
	 * Makes a geocode request and parses the results into a location object
	 * @param addr Address to geocode
	 * @param city city name
	 * @param state state 2 letter code
	 * @param zip zip code to geocode
	 * @param country 2 letter iso country code
	 * @return Geocoded location
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public Location getGeocode(String addr, String city, String state, String zip, String country) 
	throws IOException, ParserConfigurationException, SAXException {
		// Build the URL
		String url = getUrl(addr, city, state, zip, country);
		
		// Get the geocode data
		SMTHttpConnectionManager conn = new SMTHttpConnectionManager();
		ByteArrayInputStream is = new ByteArrayInputStream(conn.getRequestData(url, null, HttpConnectionType.GET));
		Document doc = buildXmlDocument(is);

		// Convert the XML to a location
	    return getLocation(doc.getElementsByTagName("GeocodeLocation").item(0));
	}
	
	/**
	 * Builds the URL from the provided address info
	 * @param addr Address to geocode
	 * @param city city name
	 * @param state state 2 letter code
	 * @param zip zip code to geocode
	 * @param country 2 letter iso country code
	 * @return Properly formatted URL
	 * @throws UnsupportedEncodingException 
	 */
	private String getUrl(String addr, String city, String state, String zip, String country) 
	throws UnsupportedEncodingException {
		return String.format("%saddr=%s&city=%s&state=%s&zip=%s&country=%s", 
				SMT_GEO_URL, 
				URLEncoder.encode(StringUtil.defaultString(addr, ""), "UTF-8"), 
				URLEncoder.encode(StringUtil.defaultString(city, ""), "UTF-8"), 
				StringUtil.defaultString(state, ""), 
				StringUtil.defaultString(zip, ""), 
				StringUtil.defaultString(country, "US"));
	}
	
	/**
	 * Builds the XML document
	 * @param is Input stream to the document
	 * @return A dom document with the xml tree
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private Document buildXmlDocument(ByteArrayInputStream is) 
	throws ParserConfigurationException, SAXException, IOException {
		// Parse the XML
		DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
		df.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Compliant
		df.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); // compliant
		DocumentBuilder builder = df.newDocumentBuilder();
		Document doc = builder.parse(is);
		doc.getDocumentElement().normalize();
		
		return doc;
	}
	
	/**
	 * Converts the node into a location object
	 * @param n Nod to process
	 * @return A geocode location object
	 */
	public Location getLocation(Node n) {
	    Element ele = (Element) n;
	    Location loc = new Location();
	    loc.setMatchCode(MatchCode.getMatchCode(getValue(ele.getElementsByTagName("MatchCode"))));
        loc.setAddress(getValue(ele.getElementsByTagName("Address")));
        loc.setCity(getValue(ele.getElementsByTagName("City")));
        loc.setState(getValue(ele.getElementsByTagName("State")));
        loc.setCounty(getValue(ele.getElementsByTagName("County")));
        loc.setCountry(getValue(ele.getElementsByTagName("Country")));
        loc.setCountryName(getValue(ele.getElementsByTagName("CountryName")));
        loc.setZipCode(getValue(ele.getElementsByTagName("ZipCode")));
        loc.setZipSuffixCode(getValue(ele.getElementsByTagName("zipSuffixCode")));
        
        if (! MatchCode.NO_MATCH.equals(loc.getMatchCode())) {
        	loc.setLatitude(Double.parseDouble(getValue(ele.getElementsByTagName("Latitude"))));
        	loc.setLongitude (Double.parseDouble(getValue(ele.getElementsByTagName("Longitude"))));
        }
        
        return loc;
	}
	
	/**
	 * Checks if the element has a value. 
	 * @param ele NodeList to get the value
	 * @return Value of the element.  "" otherwise
	 */
	private String getValue(NodeList ele) {
		if (ele.getLength() > 0) return ele.item(0).getTextContent();
		else return "";
	}
}
