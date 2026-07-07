package com.utma.tams.travel_agency_management_system_api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>>handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();   
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );
        
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String,String>> handleMissingParams(MissingServletRequestParameterException ex){
        Map<String, String> error = new HashMap<>();
        error.put("message: ", "Parameter '" + ex.getParameterName() + "' is missing");
        
        return ResponseEntity.badRequest().body(error);
    }
}
