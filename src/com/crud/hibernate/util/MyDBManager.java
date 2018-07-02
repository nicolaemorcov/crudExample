package com.crud.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyDBManager {
	
	Configuration cfg;
	
	SessionFactory sessionFactory;
	
	
	
	public MyDBManager() {
		initJPA();
	}

	public void initJPA() {
		readAndCreateConfigFile();
		createDBFactory();
	}
	
	public void readAndCreateConfigFile() {
		cfg = new Configuration().configure();
	}
	
	public void createDBFactory() {
		sessionFactory = cfg.buildSessionFactory();
	}
	
	public SessionFactory getDBFactory() {
		return sessionFactory;
	}

}
