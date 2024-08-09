package com.example.chat_backend.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    // This class will handle all the exceptions that are thrown by the application
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        return e.getMessage();
    }
}
