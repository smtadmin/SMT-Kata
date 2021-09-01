package com.smt.kata.database;

// JDK 11.x
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Apache Commons 3.x
import org.apache.commons.lang3.StringUtils;

// Spacelibs 1.x
import com.siliconmtn.data.report.ExcelReport;

/****************************************************************************
 * <b>Title</b>: ExcelGenerator.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> CHANGE ME!!
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 29, 2021
 * @updates:
 ****************************************************************************/
public class ExcelGenerator {
	// Members
	protected Connection conn;
	
	/**
	 * 
	 */
	public ExcelGenerator(Connection conn) {
		super();
		this.conn = conn;
	}
	
	/**
	 * 
	 * @param actionGroupId
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public byte[] getContactReport(String actionGroupId) 
	throws IOException, SQLException {
		if (StringUtils.isEmpty(actionGroupId)) throw new SQLException("Action Group ID is required");
		Map<String, String> headerMap = this.getHeaderMap(actionGroupId);
		List<Map<String, String>> data = this.getSubmittedData(actionGroupId);
		
		ExcelReport er = new ExcelReport(headerMap);
		er.setFileName(actionGroupId);
		er.setData(data);
		return er.generateReport();
	}
	
	/**
	 * Retrieves the headings for the spreadsheet
	 * @param actionGroupId Set of actions to retrieve the results (same form, multiple versions)
	 * @return Map of contact_field_id and the field visual name
	 * @throws SQLException
	 */
	protected Map<String, String> getHeaderMap(String actionGroupId) throws SQLException {
		 Map<String, String> headerMap = new LinkedHashMap<>();
		 StringBuilder sql = new StringBuilder(256);
		 sql.append("select cf.contact_field_id, cf.field_nm ");
		 sql.append("from sb_action sa ");
		 sql.append("inner join contact_assoc ca on sa.action_id = ca.action_id "); 
		 sql.append("inner join contact_field cf on ca.contact_field_id = cf.contact_field_id "); 
		 sql.append("where sa.action_group_id = ? ");
		 sql.append("order by order_no");
		 
		try (PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			ps.setString(1, actionGroupId);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					headerMap.put(rs.getString("contact_field_id"), rs.getString("field_nm"));
				}
			}
		}
		 
		 return headerMap;
	}
	
	/**
	 * Retrieves a collection of data for each row and adds that row data 
	 * to an outer collection
	 * @param actionGroupId ID to filter the results
	 * @return Collection of maps that represent a row of data
	 * @throws SQLException
	 */
	protected List<Map<String, String>> getSubmittedData(String actionGroupId) throws SQLException {
		List<Map<String, String>> data = new ArrayList<>();
		StringBuilder sql = new StringBuilder(256);
		sql.append("select cd.contact_field_id, cd.value_txt, cs.contact_submittal_id ");
		sql.append("from sb_action sa ");
		sql.append("inner join contact_submittal cs on sa.action_id = cs.action_id "); 
		sql.append("inner join contact_data cd on cs.contact_submittal_id = cd.contact_submittal_id "); 
		sql.append("where sa.action_group_id = ? ");
		sql.append("order by cs.create_dt desc, cs.contact_submittal_id ");
		
		try (PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			ps.setString(1, actionGroupId);
			try (ResultSet rs = ps.executeQuery()) {
				String id = "";
				Map<String, String> row = new LinkedHashMap<>();
				while (rs.next()) {
					if (!StringUtils.isEmpty(id) && !id.equals(rs.getString("contact_submittal_id"))) {
						data.add(row);
						row = new LinkedHashMap<>();
					}
					
					row.put(rs.getString("contact_field_id"), rs.getString("value_txt"));
					id = rs.getString("contact_submittal_id");
				}
				
				// Add the last row
				if (row.size() > 0) data.add(row);
			}
		}
		
		return data;
	}

	
	/**
	 * Gets the list of contact forms by action_group_id and the number of records  
	 * submitted per form for all forms that have had at least one submittal
	 * @param orgId Organization ID to filter
	 * @return Map of action_group_id and count(*) of items
	 * @throws SQLException 
	 */
	public Map<String, Integer> getContactCountByOrganization(String orgId) 
	throws SQLException {
		if (StringUtils.isEmpty(orgId)) throw new SQLException("Organization ID is required");
		Map<String, Integer> data = new LinkedHashMap<>();
		
		StringBuilder sql = new StringBuilder(256);
		sql.append("select cast(count(*) as int) as total, a.action_group_id ");
		sql.append("from sb_action a ");
		sql.append("inner join contact c on a.action_id = c.action_id ");
		sql.append("inner join contact_submittal cs on c.action_id = cs.action_id ");
		sql.append("where a.organization_id = ? ");
		sql.append("group by a.action_group_id ");
		sql.append("order by total desc ");
		
		try(PreparedStatement ps = conn.prepareStatement(sql.toString())) {
			ps.setString(1, orgId);
			
			try(ResultSet rs = ps.executeQuery()) {
				while(rs.next()) {
					data.put(rs.getString("action_group_id"), rs.getInt("total"));
				}
			}
		}
		
		return data;
	}
}
