package com.smt.kata.database;

// JDK 11.x
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Kata libs
import com.smt.kata.database.util.DBConnection;

/****************************************************************************
 * <b>Title</b>: DatabaseIntroTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit test for the database intro kata
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 26, 2021
 * @updates:
 ****************************************************************************/
class DatabaseIntroTest {
	
	// Members
	DatabaseIntro di;
	DBConnection dbConn;
	
	// Database members
	private static final String URL = "jdbc:postgresql://dev-common-sb-db.aws.siliconmtn.com:5432/columbiad_marathon?defaultRowFetchSize=25&amp;prepareThreshold=3";
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String USER = "columbiad_user";
	private static final String PASSWORD = "sqll0gin";
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void initMethod() throws Exception {
		dbConn = new DBConnection(USER, PASSWORD, DRIVER, URL);
		di = new DatabaseIntro(dbConn.getConnection());
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	protected void afterMethod() throws Exception {
		dbConn.close();
	}

	/**
	 * Test method for {@link com.smt.kata.database.DatabaseIntro#getTableMetaData(java.lang.String)}.
	 */
	@Test
	void testGetTableMetaData() throws Exception {
		Map<String, String> md = di.getTableMetaData("ezform");
		
		assertEquals(22, md.size());
		assertEquals("java.util.UUID", md.get("ezform_id"));
		assertEquals("java.sql.Date", md.get("publish_dt"));
		assertEquals("java.lang.Boolean", md.get("display_numbers_flg"));
		assertEquals("java.sql.Timestamp", md.get("create_dt"));
	}

	/**
	 * Test method for {@link com.smt.kata.database.DatabaseIntro#retrieveDataFromTable(java.lang.String)}.
	 */
	@Test
	void testRetrieveDataFromTable() throws Exception {
		List<Map<String, Object>> data = di.retrieveDataFromTable("ezform");
		assertEquals(10, data.size());
		
		for (Map<String, Object> row : data) {
			assertEquals(22, row.size());
			assertDoesNotThrow(() -> UUID.fromString(row.get("ezform_id") + ""));
			assertDoesNotThrow(() -> Timestamp.valueOf(row.get("create_dt") + ""));
			assertDoesNotThrow(() -> Boolean.valueOf(row.get("display_numbers_flg") + ""));
		}
	}

}
