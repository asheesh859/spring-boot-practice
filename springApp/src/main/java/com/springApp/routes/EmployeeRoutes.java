package com.springApp.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springApp.repository.EmployeeRepository;

@Controller
public class EmployeeRoutes {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@RequestMapping("/")
	public String loadRegistration() {
		return "registration";
	}
	

	@RequestMapping("/employeeRegister")
	public String loadEmployee() {
		return "employee";
	}
	
	@RequestMapping("/updateRegister")
	public String loadUpdateRegistration() {
		return "updateRegistration";
	}
}
