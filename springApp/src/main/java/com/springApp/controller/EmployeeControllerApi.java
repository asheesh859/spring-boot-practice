package com.springApp.controller;

import com.springApp.entity.Employee;
import com.springApp.payload.ApiResponse;
import com.springApp.payload.EmployeePayload;
import com.springApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/emp")
public class EmployeeControllerApi {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<EmployeePayload>> registerEmployee(@RequestBody EmployeePayload employeePayload){
        EmployeePayload saveEmployees = employeeService.saveRegistration(employeePayload);

        System.out.println(saveEmployees);
        System.out.println(saveEmployees.getName());
        System.out.println(saveEmployees.getEmail());
        System.out.println(saveEmployees.getMobile());

        ApiResponse<EmployeePayload> response = new ApiResponse<>();
        response.setMessage("Data save successfully");
        response.setStatusCode(201);
        response.setData(saveEmployees);
        ResponseEntity<ApiResponse<EmployeePayload>> apiResponseResponseEntity = new ResponseEntity<>(response, HttpStatus.CREATED);
        return apiResponseResponseEntity;

    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<ApiResponse<Employee>> getAllEmployee(){

        Employee allReistration = employeeService.getAllReistration();
        ApiResponse<Employee> response = new ApiResponse<>();

        response.setStatusCode(200);
        response.setMessage("All employees ");
        response.setData(allReistration);
        ResponseEntity<ApiResponse<Employee>> apiResponseResponseEntity = new ResponseEntity<>(response , HttpStatus.OK);
        return apiResponseResponseEntity;
    }

    @GetMapping("/getEmployeeById/{id}")
    public void getRegisterById(@PathVariable long id){

    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<ApiResponse<Employee>> deleteEmployeeById(@PathVariable long id){

        Employee employee = employeeService.deleteEmployeeById(id);

        ApiResponse<Employee> response = new ApiResponse<>();
        response.setMessage("this employee has been deleted");
        response.setStatusCode(200);

        response.setData(employee);
        ResponseEntity<ApiResponse<Employee>> responseResponseEntity = new ResponseEntity<>(response , HttpStatus.OK);

        return responseResponseEntity;
    }


}
