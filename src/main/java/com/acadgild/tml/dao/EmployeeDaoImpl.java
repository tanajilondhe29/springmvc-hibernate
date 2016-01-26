package com.acadgild.tml.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.acadgild.tml.model.Employee;

/**
 * 
 * @author TML
 *
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getEmployees() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Employee> employeeList = session.createQuery("from Employee")
				.list();
		session.close();
		return employeeList;
	}

	@Override
	public Employee getEmployee(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		session.close();
		return employee;
	}

	@Override
	public int addOrUpdateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(employee);
		tx.commit();
		Serializable id = session.getIdentifier(employee);
		session.close();
		return (Integer) id;
	}

	@Override
	public Employee deleteEmployee(int id) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
		return employee;
	}

}
