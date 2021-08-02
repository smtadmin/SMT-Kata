package com.smt.kata.database;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;

// Junit 5
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// Kata libs
import com.smt.kata.database.util.DBConnection;

/****************************************************************************
 * <b>Title</b>: ExcelGeneratorTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit tests for the excel generator database kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Aug 2, 2021
 * @updates:
 ****************************************************************************/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExcelGeneratorTest {
	
	// Members
	static Map<String, Integer> forms;
	ExcelGenerator eg;
	DBConnection dbConn;

	// Database members
	private static final String URL = "jdbc:postgresql://staging-sb-db.aws.siliconmtn.com:5432/wc_staging_sb?defaultRowFetchSize=25&amp;prepareThreshold=3";
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String USER = "wc_user_sb";
	private static final String PASSWORD = "sqll0gin";
	private static final String ORG_ID = "SMT";
	private static final String FILE_PATH = "/home/etewa/Desktop/ExcelTest/";
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUpBeforeMethod() throws Exception {
		if (dbConn == null) dbConn = new DBConnection(USER, PASSWORD, DRIVER, URL);
		eg = new ExcelGenerator(dbConn.getConnection());
	}


	/**
	 * Test method for {@link com.smt.kata.database.ExcelGenerator#getContactReport(java.lang.String)}.
	 */
	@Test
	@Order(2)
	void testGetContactReport() throws Exception {
		
		for (Map.Entry<String, Integer> item : forms.entrySet()) {
			System.out.println("Form: " + item.getKey() + "|" + item.getValue());
			byte[] report = eg.getContactReport(item.getKey());
			this.saveFile("Excel_" + item.getKey() + ".xlsx", report);
			assertTrue(report != null && report.length > 0);
		}
	}

	/**
	 * Test method for {@link com.smt.kata.database.ExcelGenerator#getContactCountByOrganization(java.lang.String)}.
	 */
	@Test
	@Order(1)
	void testGetContactCountByOrganization() throws Exception {
		System.out.println("First");
		forms = eg.getContactCountByOrganization(ORG_ID);
		assertEquals(6, forms.size());
		assertEquals(1, forms.get("c0a80237dd8b7a2a5cb215e02cd3af00"));
		assertEquals(6, forms.get("c0a802414b160c7c4605e406a3a840db"));
		assertEquals(3, forms.get("c0a802419df2f2fd73312c272b2e864d"));
		assertEquals(72, forms.get("c0a8024190bc749edf9f88c2ac98838"));
		assertEquals(8, forms.get("c0a8021ebdcf63c5994c784475a1503"));
		assertEquals(1, forms.get("c0a802411654f352bd47b4e6f253ef11"));
	}
	
	/**
	 * Saves the excel report tot he file system to be tested
	 * @param fileName
	 * @param data
	 */
	protected void saveFile(String fileName, byte[] data) {
		File file = new File(FILE_PATH);
		if (! file.exists()) file.mkdirs();
		
		try (FileOutputStream fos = new FileOutputStream(FILE_PATH + fileName); 
			 DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos))) {
		    outStream.write(data);
		    outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
