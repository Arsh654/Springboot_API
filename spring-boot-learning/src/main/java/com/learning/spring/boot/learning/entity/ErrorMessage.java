package com.learning.spring.boot.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    //Defining fields what i need to send when there an exception occured.
    //i am sending 2 things status and message;
    private HttpStatus status;
    private String message;

}
