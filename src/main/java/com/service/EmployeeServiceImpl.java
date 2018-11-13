package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmployeeDAO;
import com.entity.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public List<Employee> queryAllEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.queryAllEmployees();
	}

	@Override
	public void insert(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.insert(employee);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeeDAO.delete(id);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDAO.update(employee);
	}

	@Override
	public Employee queryOneById(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.queryOneById(id);
	}
	
	
}
