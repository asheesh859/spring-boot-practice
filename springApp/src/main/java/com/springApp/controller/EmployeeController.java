package com.springApp.controller;

import com.springApp.entity.Employee;
import com.springApp.payload.EmployeePayload;
import com.springApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;


	//Handler Method -http://localhost:8080/view
	

	@RequestMapping("/saveReg")
	public String getRegistrationData(@ModelAttribute  EmployeePayload employeePayload , Model model){
	employeeService.saveRegistration(employeePayload);
	return "registration";

	}
	
	
	@RequestMapping("/saveRegistration")
	public String saveEmployeeReistration(@RequestParam String name,@RequestParam String email,@RequestParam String mobile) {
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(mobile);
				return "registration";
		
	}
	
	
	
}
