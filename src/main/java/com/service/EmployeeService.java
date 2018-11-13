package com.service;

import java.util.List;

import com.entity.Employee;

public interface EmployeeService {
	List<Employee> queryAllEmployees();
	void insert(Employee employee);
	void delete(int id);
	void update(Employee employee);
	Employee queryOneById(int id);
}
