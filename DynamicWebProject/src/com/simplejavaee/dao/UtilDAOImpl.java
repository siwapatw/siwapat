package com.simplejavaee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.simplejavaee.service.DBServiceLocator;

public class UtilDAOImpl implements UtilDAO {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private Connection getConnection() throws Exception {
		DBServiceLocator serviceLocator = DBServiceLocator.getInstance();
		return serviceLocator.getConnection();
	}
	
	private final void closeConnection() throws Exception{ 
		try{
			if (conn != null){
				try {
					conn.commit();
				} catch (Exception ex) {
				}
			}
			if (rs != null){
				try{
					rs.close();
				} catch (Exception ex) {
				}
			}
			if (ps != null){
				try{
					ps.close();
				} catch (Exception ex) {
				}
			}
			if (conn != null){
				try{
					conn.close();
				} catch (Exception ex) {
				}
			}
			rs = null;
			ps = null;
			conn = null;
		}catch(Exception ex){
			throw ex;
		}
	}	
	
	public String loadUserM(String screenName) throws Exception {
		try {
			
			System.out.println(" ####### before getconnection() ####### ");
			conn = this.getConnection();
			System.out.println(" ####### after getconnection() ####### ");
			
			String name = null;
			
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT * ");
			sql.append(" FROM my_contacts ");
//			sql.append(" WHERE ");
//			sql.append("		SCREENNAME = ? ");
//			sql.append("	AND ROLE <> ? ");
			
			String dSql = String.valueOf(sql);
			System.out.println(" ####### dSql : " + dSql);
			ps = conn.prepareStatement(dSql);
//			ps.setString(1, screenName);
		
			rs = ps.executeQuery();

			while (rs.next()) {
				name = rs.getString("first_name");
			}
			return name;
		
		} catch (SQLException ex) {
			System.out.println("\n--- SQLException caught ---\n");
			while (ex != null) {
				System.out.println("Message:   " + ex.getMessage());
				System.out.println("SQLState:  " + ex.getSQLState());
				System.out.println("ErrorCode: " + ex.getErrorCode());
				ex = ex.getNextException();
				System.out.println("");
			}
			throw new Exception(" SQL Exception occur!");
		} finally {
			try {
				this.closeConnection();
			} catch (Exception ex) {
				throw new RuntimeException(ex);
			}
		}
	}
	

}