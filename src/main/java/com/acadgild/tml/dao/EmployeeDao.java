package com.acadgild.tml.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.acadgild.tml.model.Employee;

/**
 * 
 * @author TML
 *
 */
@Service
public interface EmployeeDao {
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(int id);
	
	public int addOrUpdateEmployee(Employee employee);
	
	public Employee deleteEmployee(int id);
	
}
