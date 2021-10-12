package com.smt.kata.database;

// JDK 11.x
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

// Junit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Kata Libs
import com.smt.kata.database.util.DBConnection;

/****************************************************************************
 * <b>Title</b>: DatabaseQueryTest.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Unit Tests for the DatabaseQuery Class.  That class has a single 
 * method that dynamically executes a query and returns the data,  This unit test 
 * will pass the query to the databse query and get the matching results
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 27, 2021
 * @updates:
 ****************************************************************************/
class DatabaseQueryTest {
	
	// Members
	DBConnection dbConn;
	DatabaseQuery dq;
	
	// Database members
	private static final String URL = "jdbc:postgresql://dev-common-sb-db.aws.siliconmtn.com:5432/columbiad_marathon?defaultRowFetchSize=25&amp;prepareThreshold=3";
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String USER = "columbiad_user";
	private static final String PASSWORD = "sqll0gin";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUpBeforeMethods() throws Exception {
		dbConn = new DBConnection(USER, PASSWORD, DRIVER, URL);
		dq = new DatabaseQuery(dbConn.getConnection());
	}

	/**
	 * Test method for {@link com.smt.kata.database.DatabaseQuery#execute(java.lang.String, java.util.List)}.
	 * 
	 * --- Execute a query to return all of the records form the ezform table
	 */
	@Test
	void testExecuteStar() throws Exception {
		String sql = "select * from ezform";
		
		List<Map<String, Object>> data = dq.execute(sql, null);
		assertEquals(12, data.size());
	}

	/**
	 * Test method for {@link com.smt.kata.database.DatabaseQuery#execute(java.lang.String, java.util.List)}.
	 * 
	 * --- Execute a query to return a count of all of the records in the ezform table
	 */
	@Test
	void testExecuteCountStar() throws Exception {
		String sql = "select count(*) as total from ezform";
		
		List<Map<String, Object>> data = dq.execute(sql, null);
		assertEquals(12l, data.get(0).get("total"));
	}

	/**
	 * Test method for {@link com.smt.kata.database.DatabaseQuery#execute(java.lang.String, java.util.List)}.
	 * 
	 * --- Execute a query to the number of options for each question text that is 
	 * the same
	 */
	@Test
	void testExecuteOptionsPerQuestion() throws Exception {
		StringBuilder sql = new StringBuilder();
		sql
			.append("select question_txt , count(*) as total ")
			.append("from ezform_question eq ")
			.append("inner join ezform_question_option eqo on eq.ezform_question_id = eqo.ezform_question_id ")
			.append("group by question_txt ")
			.append("order by total desc ");
		
		List<Map<String, Object>> data = dq.execute(sql.toString(), null);
		assertEquals(21, data.size());
		assertEquals(630l, data.get(0).get("total"));
		assertEquals(7l, data.get(data.size() - 1).get("total"));
	}
	
	/**
	 * Test method for {@link com.smt.kata.database.DatabaseQuery#execute(java.lang.String, java.util.List)}.
	 * 	 * 
	 * --- Execute a query to the number of options for each question text that is 
	 * the same.  Filter the query by the provided UUID
	 */
	@Test
	void testExecuteOptionsPerQuestionFilterByForm() throws Exception {
		String uuid = "477396fc-8e71-4775-8474-43a171a0e574";
		StringBuilder sql = new StringBuilder();
		sql
			.append("select question_txt , count(*) as total ")
			.append("from ezform_question eq ")
			.append("inner join ezform_question_option eqo on eq.ezform_question_id = eqo.ezform_question_id ")
			.append("where eq.ezform_id = ? ")
			.append("group by question_txt ")
			.append("order by total desc ");
		
		List<Object> params = new ArrayList<>();
		params.add(UUID.fromString(uuid));
		List<Map<String, Object>> data = dq.execute(sql.toString(), params);
		assertEquals(20, data.size());
		assertEquals(90l, data.get(0).get("total"));
		assertEquals(2l, data.get(data.size() - 1).get("total"));
	}
}
