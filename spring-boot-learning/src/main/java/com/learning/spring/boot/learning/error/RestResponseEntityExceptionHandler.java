package com.learning.spring.boot.learning.error;

import com.learning.spring.boot.learning.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
/*
- this class will handle the response against the generated exception
if so any in the controller.
- Spring will acknowledge this via @ControllerAdvice annotaion
* */

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {
//now need to create a method that will send out the response
//against the Exception

    @ExceptionHandler(departmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(departmentNotFoundException Exception, WebRequest req){
        ErrorMessage exceptionResonse = new ErrorMessage(HttpStatus.NOT_FOUND,Exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResonse);
    }

}




