package com.smt.kata.database.util;

// JDK 11.x
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Apache commons 3
import org.apache.commons.lang3.StringUtils;

/****************************************************************************
 * <b>Title</b>: Connection.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Connects to the database with the provided info
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 26, 2021
 * @updates:
 ****************************************************************************/
public class DBConnection {

	private String user; 
	private String pwd; 
	private String driver; 
	private String url;
	private Connection conn;
	
	/**
	 * 
	 * @param host
	 * @param pwd
	 * @param driver
	 * @param url
	 */
	public DBConnection(String user, String pwd, String driver, String url) {
		super();
		this.user = user;
		this.pwd = pwd;
		this.driver = driver;
		this.url = url;
	}
	
	
	/**
	 * Connects to the database 
	 * @return
	 */
	public Connection getConnection() throws SQLException {
		// Check to see if the connection is already open
		if (conn != null) return conn;
		
		// Validate the input
		if (StringUtils.isAllEmpty(driver, url, user, pwd)) 
			throw new SQLException ("Invalid data.  All fields in constructor are required");
		
		// Connect to the database
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			throw new SQLException("Unable to load driver: " + driver);
		}
		
		return conn;
	}
	
	/**
	 * Identifies whether there is a connection to the db
	 * @return
	 */
	public boolean isConnected() {
		try {
			if (conn == null) return false;
			else return ! conn.isClosed();
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Closes the database connection
	 *
	 */
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {/* Intentionally Blank */ }
		
		conn = null;
	}

}
