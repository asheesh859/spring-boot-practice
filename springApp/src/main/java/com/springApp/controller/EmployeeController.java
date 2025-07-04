package com.springApp.controller;

import com.springApp.payload.EmployeePayload;
import com.springApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;


	//Handler Method -http://localhost:8080/view
	@RequestMapping("/view")
	public String viewRegisterPage() {
		return "registration";
	}

	@RequestMapping("/saveReg")
	public String getRegistrationData(@ModelAttribute  EmployeePayload employeePayload , Model model){
	employeeService.saveRegistration(employeePayload);
	return "registration";

	}
}
