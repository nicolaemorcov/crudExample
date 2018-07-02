package com.crud.services;

import java.util.List;

import org.hibernate.Session;

import com.crud.entities.Employee;
import com.crud.hibernate.util.MyDBManager;
import com.mysql.jdbc.PreparedStatement;

public class EmpServices {
	MyDBManager dbManager = new MyDBManager();

	public void saveEmployee(Employee emp) {
		Session session = dbManager.getDBFactory().openSession();
		session.beginTransaction();
		
		session.persist(emp);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Employee getEmployeeById(int id) {
		Session session = dbManager.getDBFactory().openSession();
		session.beginTransaction();
		
		Employee emp;
		String sql = "FROM Employee WHERE id='" + id + "'";
		emp = (Employee) session.createQuery(sql).uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return emp;
		
	}
	
	public void update(Employee employee) {
		EmpServices service = new EmpServices();
		Session session = dbManager.getDBFactory().openSession();
		session.beginTransaction();
		
		
		
	}
	
	public void delete(int id) {
		Session session = dbManager.getDBFactory().openSession();
		session.beginTransaction();
		String sql = "FROM Employee WHERE id='" + + id + "'";
		
		Employee emp = (Employee) session.createQuery(sql).uniqueResult();
		session.delete(emp);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public List<Employee> getAllEmployees(){
		Session session = dbManager.getDBFactory().openSession();

		session.beginTransaction();
		
		List<Employee> employees = session.createQuery("FROM Employee").list();
		try {
		session.getTransaction().commit();
		}finally {
		session.close();
		}
		return employees;
	}
	
	
}
