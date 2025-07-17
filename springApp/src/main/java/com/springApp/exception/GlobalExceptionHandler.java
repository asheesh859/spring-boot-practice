package com.springApp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeExceptionHandler.class)
    public String handleResourceNotFound(RuntimeExceptionHandler runtimeExceptionHandler){
        return "run time exception occure";
    }

}
