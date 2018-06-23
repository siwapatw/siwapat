package com.simplejavaee.dao;

public abstract class DAOFactory {

	public static UtilDAO getUtilDAO() {
		return new UtilDAOImpl();
	}
	

}
