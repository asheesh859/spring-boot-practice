package com.springApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
	
	//Handler Method -http://localhost:8080/view
	@RequestMapping("/view")
	public String viewRegisterPage() {
		return "registration";
	}
}
