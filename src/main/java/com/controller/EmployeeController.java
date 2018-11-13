package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Employee;
import com.service.EmployeeService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/showAllEmployees")
	public String showAllEmployees(HttpServletRequest request){
		List<Employee> list = employeeService.queryAllEmployees();
		HttpSession session = request.getSession();
		session.setAttribute("list", list);
		return "forward:/ems/emplist.jsp";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Employee employee){
		employeeService.insert(employee);
		return "redirect:/emp/showAllEmployees";
	}
	
	@RequestMapping("/deleteEmployee")
	public String deleteEmployee(int id){
		employeeService.delete(id);
		return "redirect:/emp/showAllEmployees";
	}
	
	@RequestMapping("/updateEmployee")
	public String updateEmployee(Employee employee){
		employeeService.update(employee);
		return "redirect:/emp/showAllEmployees";
	}
	
	@RequestMapping("/queryOneById")
	public String queryOneById(int id,HttpServletRequest request){
		Employee employee = employeeService.queryOneById(id);
		HttpSession session = request.getSession();
		session.setAttribute("employee", employee);
		return "forward:/ems/updateEmp.jsp";
	}
}
