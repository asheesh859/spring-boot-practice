package com.springApp.controller;

import com.springApp.emailService.EmailService;
import com.springApp.entity.Employee;
import com.springApp.payload.EmployeePayload;
import com.springApp.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmailService emailService;

	// Handler Method -http://localhost:8080/view

	@RequestMapping("/saveReg")
	public String getRegistrationData(@ModelAttribute EmployeePayload employeePayload, Model model) {
		employeeService.saveRegistration(employeePayload);
		this.emailService.emailSender(employeePayload.getEmail() , "testing" , "email received..");
		return "registration";

	}

	@RequestMapping("/saveRegistration")
	public String saveEmployeeReistration(@RequestParam String name, @RequestParam String email,
			@RequestParam String mobile) {

		System.out.println(name);
		System.out.println(email);
		System.out.println(mobile);
		return "registration";

	}

//	@RequestMapping("/getAllEmployee")
//	public String viewRegistration(ModelMap model) {
//		List<Employee> employee = employeeService.getAllReistration();
//		model.addAttribute("employees", employee);
//		return "viewRegistration";
//	}

//	@RequestMapping("/deleteEmpolyee")
//	public String deleteEmployeeRegistration(@RequestParam long id, ModelMap model) {
//		employeeService.deleteEmployeeById(id);
//
//		List<Employee> allReistration = employeeService.getAllReistration();
//		model.addAttribute("employees", allReistration);
//		return "viewRegistration";
//	}

//	@RequestMapping("/updateEmployeeDeteilsById")
//	public String updateRegistrationById(@ModelAttribute EmployeePayload employeePayLoad , Model model ) {
//		employeeService.updateRegistrationById(employeePayLoad);
//		List<Employee> allReistration = employeeService.getAllReistration();
//		model.addAttribute("employees",allReistration);
//		return "viewRegistration";
//	}

//	@RequestMapping("/updateEmployeeDeteilsById")
//	public String updateRegistrationById(ModelMap model , @RequestParam long id , @RequestParam String name , @RequestParam String email , @RequestParam String mobile) {
//		System.out.print(id);
//
//
//		int Status = employeeService.updateRegisterById(id, name, email, mobile);
//		System.out.println(Status);
//		List<Employee> allReistration = employeeService.getAllReistration();
//		model.addAttribute("employees",allReistration);
//		return "viewRegistration";
//	}
	
	
	@RequestMapping("/getRegisterById")
	public String getRegistrationById(long id , ModelMap model) {
		Employee employee = employeeService.getREgistrationById(id);
		model.addAttribute("employees" , employee);
		return "updateRegistration";
	}

}
