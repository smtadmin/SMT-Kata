package com.smt.kata.code;

// JDK 11.x
import java.util.Arrays;
import java.util.List;

/****************************************************************************
 * <b>Title</b>: IPAddress.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Implement a class that receives two IPv4 addresses, 
 * and returns the number of addresses between them (including the first one, 
 * excluding the last one). All inputs will be valid IPv4 addresses in the form 
 * of strings. The last address will always be greater than the first one. 
 * Examples ips_between("10.0.0.0", "10.0.0.50")  ==   50 
 * ips_between("10.0.0.0", "10.0.1.0")   ==  256 
 * ips_between("20.0.0.10", "20.0.1.0")  ==  246
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 12, 2021
 * @updates:
 ****************************************************************************/
public class IPAddress {

	/**
	 * Initializes the class
	 */
	public IPAddress() {
		super();
	}

	/**
	 * Determines the number of hosts between the 2 ip's
	 * @param ipStart
	 * @param ipEnd
	 * @return
	 */
	public int numberHosts(String ipStart, String ipEnd) {
		int startCount = getIpCounts(ipStart);
		int endCount = getIpCounts(ipEnd);
		
		return Math.abs(startCount - endCount);
	}
	
	/**
	 * Takes the IP and calculates the number of hosts
	 * @param ip
	 * @return
	 */
	private int getIpCounts(String ip) {
		List<String> ipList = Arrays.asList(ip.split("\\."));
		int count = 0;
		int pow = 3;
		for (int i = 0; i < ipList.size(); i++) {
			count += this.calculateHosts(Integer.parseInt(ipList.get(i)), pow--);
		}
		
		return count;
	}
	
	/**
	 * based upon the location of the ip section, calculates the number of hosts
	 * @param count
	 * @param power
	 * @return
	 */
	private int calculateHosts(int count, int power) {
		return (int)(count * Math.pow(256, power));
	}
}
