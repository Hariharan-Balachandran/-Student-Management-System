package com.example.sms.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error"; // create error.html template
    }

    @ExceptionHandler(DataAccessException.class)
    public String handleDBException(DataAccessException ex, Model model) {
        model.addAttribute("errorMessage", "Database error: " + ex.getMessage());
        return "error";
    }

}