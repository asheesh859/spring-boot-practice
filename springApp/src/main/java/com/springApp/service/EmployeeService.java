package com.springApp.service;

import com.springApp.entity.Address;
import com.springApp.entity.Employee;
import com.springApp.payload.EmployeePayload;
import com.springApp.repository.AddressRepository;
import com.springApp.repository.EmployeeRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private AddressRepository addressRepository;

	public EmployeePayload saveRegistration(EmployeePayload employeePayload) {
		Employee emp = new Employee();
		BeanUtils.copyProperties(employeePayload, emp);
		Employee employeeSave = employeeRepository.save(emp);

		Address add = new Address();
		BeanUtils.copyProperties(employeePayload, add);
		Address addressSave = addressRepository.save(add);

		EmployeePayload employeePayLoad = new EmployeePayload();

		BeanUtils.copyProperties(employeeSave,employeePayLoad);
		BeanUtils.copyProperties(addressSave , employeePayLoad);

		return employeePayLoad;
	}

	public List<Employee> getAllReistration() {

		Employee employee = new Employee();
		List<Employee> employees = employeeRepository.findAll();
		return employees;

	}

	public Employee deleteEmployeeById(long id) {
		Employee employeeResult = null;
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()){
			employeeResult = employee.get();
		}
		employeeRepository.deleteById(id);
		return employeeResult;


	}

//	public void updateRegistrationById(EmployeePayload employeePayload) {
//
//		Employee employee = new Employee();
//		BeanUtils.copyProperties(employeePayload, employee);
//		employeeRepository.save(employee);
//
//	}

	public int updateRegisterById(Long id , String name , String email , String mobile){
		System.out.print("service : "+id);
		int status = employeeRepository.updateRegistrationById(id , name , email  , mobile);
		return  status;
	}

	public Employee getREgistrationById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		return employee.get();
		
	}

}
