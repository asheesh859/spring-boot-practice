package com.springApp.service;

import com.springApp.entity.Address;
import com.springApp.entity.Employee;
import com.springApp.payload.EmployeePayload;
import com.springApp.repository.AddressRepository;
import com.springApp.repository.EmployeeRepository;

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

		BeanUtils.copyProperties(employeeSave,employeePayload);
		BeanUtils.copyProperties(addressSave , employeePayLoad);

		return employeePayLoad;
	}

	public List<Employee> getAllReistration() {
		List<Employee> employee = employeeRepository.findAll();
		return employee;
	}

	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
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
