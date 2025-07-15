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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	public List<Employee> getAllReistration(int pageNo , int pageSize , String sortBy , String sortDir) {

		Sort sort = sortDir.equalsIgnoreCase("asc")?Sort.by(Sort.Direction.ASC , sortBy):Sort.by(Sort.Direction.DESC , sortBy);

		Pageable pageable = PageRequest.of(pageNo , pageSize,sort);
        Page<Employee> page = employeeRepository.findAll(pageable);
		List<Employee> employees = page.getContent();
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
		if(employee.isPresent()){
			return employee.get();
		}
		return null;

	}

	public Employee updateEmployeeData(EmployeePayload employeePayload) {
		Employee emp = new Employee();
		BeanUtils.copyProperties(employeePayload, emp);
		Employee result = employeeRepository.save(emp);
		return result;
	}
}
