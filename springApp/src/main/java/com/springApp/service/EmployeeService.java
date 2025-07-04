package com.springApp.service;

import com.springApp.entity.Address;
import com.springApp.entity.Employee;
import com.springApp.payload.EmployeePayload;
import com.springApp.repository.AddressRepository;
import com.springApp.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
   private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository addressRepository;

    public void saveRegistration(EmployeePayload employeePayload) {
        Employee emp = new Employee();
        BeanUtils.copyProperties(employeePayload , emp);
        employeeRepository.save(emp);
        Address add = new Address();
        BeanUtils.copyProperties(employeePayload , add);
        addressRepository.save(add);
    }
}
