package com.simplejavaee.service;

import java.sql.Connection;

import javax.naming.InitialContext;

import javax.sql.DataSource;


public class DBServiceLocator {
	private static DBServiceLocator serviceLocator;

	public static DBServiceLocator getInstance()
			throws DBServiceLocatorException {
		if (serviceLocator == null) {
			serviceLocator = new DBServiceLocator();
		}
		return serviceLocator;
	}

	public Connection getConnection() throws DBServiceLocatorException {
		try {
			//String jndi = "java:comp/env/jdbc/mysql_DB";
			String jndi = "java:jboss/lorbpm";
			System.out.println(" ####### jndi : " + jndi);
			
			// Obtain our environment naming context
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(jndi);
			
			// Allocate and use a connection from the pool
			return ds.getConnection();
			
		} catch (Exception e) {
			System.out.println(" #######=========== getConnection : " + e);
			e.printStackTrace();
			throw new DBServiceLocatorException(e.toString());
		}

	}

}