package com.bci.users.infraestructure.controller.exceptions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bci.users.domain.model.exception.UserException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
    private Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    
    private static final String MESSAGE_BODY ="mensaje";
    
    @Override
    protected ResponseEntity<Object>
    handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                 HttpHeaders headers,
                                 HttpStatus status, WebRequest request) {
    	Map<String, Object> body = new LinkedHashMap<>();
    	
    	//TODO JAVA 8
        String errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.joining(","));

        body.put(MESSAGE_BODY, errors);
        
       logger.error(ex.getMessage(),ex);
       
       return new ResponseEntity<>(body, headers, status);
    }
    
    @ExceptionHandler(UserException.class)
    public ResponseEntity<Object> handleUSerException(UserException e) {
        
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(MESSAGE_BODY, e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    
}