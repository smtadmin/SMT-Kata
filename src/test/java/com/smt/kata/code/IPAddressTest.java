package com.smt.kata.code;

// Junit 5
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/****************************************************************************
 * <b>Title</b>: IPAddressTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Tests the IPAddress Kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Feb 12, 2021
 * @updates:
 ****************************************************************************/
class IPAddressTest {

	/**
	 * Tests the constructor
	 */
	@Test
	void test() {
		IPAddress ip = new IPAddress();
		assertNotNull(ip);
	}

	/**
	 * Tests the counting of ips between the ranges
	 * @throws Exception
	 */
	@Test
	void testNumberHosts() throws Exception {
		IPAddress ip = new IPAddress();
		assertEquals(50, ip.numberHosts("10.0.0.0", "10.0.0.50"));
		assertEquals(256, ip.numberHosts("10.0.0.0", "10.0.1.0"));
		assertEquals(246, ip.numberHosts("20.0.0.10", "20.0.1.0"));
		assertEquals(0, ip.numberHosts("20.0.0.10", "20.0.0.10"));
		assertEquals(11010048, ip.numberHosts("192.168.0.0", "192.0.0.0"));
		assertEquals(65024, ip.numberHosts("192.168.254.0", "192.168.0.0"));
	}

}
