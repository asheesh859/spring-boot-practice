package com.springApp.controller;

import com.springApp.entity.Employee;
import com.springApp.payload.ApiResponse;
import com.springApp.payload.EmployeePayload;
import com.springApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/getAllEmployee")
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployee(@RequestParam(value = "pageNo" , defaultValue = "0" , required = false) int pageNo ,
                                                                      @RequestParam(value = "pageSize" , defaultValue = "5" , required = false) int pageSize
                                                                      ){

        List<Employee> allReistration = employeeService.getAllReistration(pageNo , pageSize);
        ApiResponse<List<Employee>> response = new ApiResponse<>();
        response.setStatusCode(200);
        response.setMessage("All employees ");
        response.setData(allReistration);
        ResponseEntity<ApiResponse<List<Employee>>> apiResponseResponseEntity = new ResponseEntity<>(response , HttpStatus.OK);
        return apiResponseResponseEntity;
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<ApiResponse<Employee>> getRegisterById(@PathVariable long id){
        ApiResponse<Employee> response = new ApiResponse<>();
        try{
            Employee employeeResult = employeeService.getREgistrationById(id);
            if(employeeResult!=null){
                response.setMessage("Employee fetched successfully");
                response.setStatusCode(200);
                response.setData(employeeResult);
                ResponseEntity<ApiResponse<Employee>> responseResponseEntity = new ResponseEntity<>(response , HttpStatus.OK);
                return responseResponseEntity;
            }
            response.setMessage("employee does not exist!");
            response.setStatusCode(400);
            response.setData(employeeResult);
            ResponseEntity<ApiResponse<Employee>> responseResponseEntity = new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
            return responseResponseEntity;
        }catch (Exception e){
            String message = e.getMessage();
            response.setMessage(message);
            response.setStatusCode(500);
            ResponseEntity<ApiResponse<Employee>> responseResponseEntity = new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
            return responseResponseEntity;
        }

    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<ApiResponse<Employee>> deleteEmployeeById(@PathVariable long id){
        ApiResponse<Employee> response = new ApiResponse<>();
        Employee employee = employeeService.deleteEmployeeById(id);
        if(employee!=null){
            response.setMessage("this employee has been deleted");
            response.setStatusCode(200);
            response.setData(employee);
            ResponseEntity<ApiResponse<Employee>> responseResponseEntity = new ResponseEntity<>(response , HttpStatus.OK);
            return responseResponseEntity;
        }
        response.setMessage("Id does not exist in database");
        response.setStatusCode(404);
        ResponseEntity<ApiResponse<Employee>> responseResponseEntity = new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
        return responseResponseEntity;

    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<ApiResponse<Employee>> updateRecord(@RequestBody EmployeePayload employeePayload){
        Employee updateEmployeeResult = employeeService.updateEmployeeData(employeePayload);

        ApiResponse<Employee> response = new ApiResponse<>();
        response.setStatusCode(200);
        response.setMessage("Data has been updated..");
        response.setData(updateEmployeeResult);

        ResponseEntity<ApiResponse<Employee>> responseResponseEntity = new ResponseEntity<>(response , HttpStatus.OK);
        return  responseResponseEntity;




    }


}
