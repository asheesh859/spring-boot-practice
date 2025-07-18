package com.springApp.exception;

import com.springApp.payload.ErrorDetailsPayload;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsPayload> handleResourceNotFound(Exception exception , WebRequest request){

       ErrorDetailsPayload errorDetailsPayload = new ErrorDetailsPayload(exception.getMessage() , new Date() , request.getDescription(true));
       return new ResponseEntity<>(errorDetailsPayload , HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
