package com.springApp.controller;

import com.springApp.payload.ApiResponse;
import com.springApp.payload.EmployeePayload;
import com.springApp.service.EmployeeService;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
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
        ApiResponse<EmployeePayload> response = new ApiResponse<>();
        response.setMessage("Data save successfully");
        response.setStatusCode(201);
        response.setData(saveEmployees);
        ResponseEntity<ApiResponse<EmployeePayload>> apiResponseResponseEntity = new ResponseEntity<>(response, HttpStatus.CREATED);
        return apiResponseResponseEntity;

    }

    @GetMapping("/getEmployee")
    public String getAllEmployee(){
        return "get employees";
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployeeById(){
        return "delete employee";
    }


}
