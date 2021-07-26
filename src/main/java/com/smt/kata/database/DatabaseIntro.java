package com.smt.kata.database;

// JDK 11.x
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: DatabaseIntro.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Database Intro
 * This kata is designed to provide a basic understanding of database connections 
 * and queries in java.  This class has 2 methods that must be configured.  The first
 * is designed to teach you how to load meta data information form the database.
 * The second method is designed to help you pull data from the database using 
 * SQL packages
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 26, 2021
 * @updates:
 ****************************************************************************/
public class DatabaseIntro {
	
	// Members
	private Connection conn;

	/**
	 * Initializes the class with the database connection
	 * @param dbConn
	 */
	public DatabaseIntro(Connection conn) throws SQLException {
		super();
		if (conn == null || conn.isClosed()) 
			throw new SQLException("Invalid DB COnnection");
		
		this.conn = conn;
	}

	/**
	 * Retrieves the metadata for the provided column
	 * @param tableName Table to retrieve metadata
	 * @return Map with the column name as the key and ther java data type as the value
	 * @throws SQLException 
	 */
	public Map<String, String> getTableMetaData(String tableName) throws SQLException {
		Map<String, String> metaData = new LinkedHashMap<>();
		
		try (PreparedStatement stmt = conn.prepareStatement("select * from " + tableName)) {
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			
			for (int i=1; i <= numberOfColumns; i++) {
				metaData.put(rsmd.getColumnName(i), rsmd.getColumnClassName(i));
			}
		}
		
		return metaData;
	}
	
	/**
	 * Loads a the data elements from the provided table
	 * @param tableName Table to retrieve it's data
	 * @return Collection of key values for each row.  The map has the column name
	 * as the key and the value for each row as the value
	 */
	public List<Map<String, Object>> retrieveDataFromTable(String tableName) throws SQLException {
		List<Map<String, Object>> data = new ArrayList<>();
		
		Map<String, String> metaData = this.getTableMetaData(tableName);
		
		try (PreparedStatement stmt = conn.prepareStatement("select * from " + tableName)) {
			try (ResultSet rs = stmt.executeQuery()) {
			
				while(rs.next()) {
					Map<String, Object> row = new LinkedHashMap<>();
					for (String column : metaData.keySet()) {
						row.put(column, rs.getObject(column));
					}
					
					data.add(row);
				}
			}
		}
		
		return data;
	}
}
