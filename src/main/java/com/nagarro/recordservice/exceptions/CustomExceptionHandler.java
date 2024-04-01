package com.nagarro.recordservice.exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler  {
    
    @ExceptionHandler(CustomizedException.class)
    public ResponseEntity<Object> handleCustomExceptions( CustomizedException ex)
    {
            Map<String,Object> body=new HashMap<>();
            body.put("status", HttpStatus.BAD_REQUEST);
            body.put("class",ex.getClass());
            body.put("error",ex.getMessage());
            Date timestamp=new Date();
            String timestampFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss")
                                            .format(timestamp);
            body.put("timestamp",timestampFormat);
            return new ResponseEntity<Object>(body,HttpStatus.BAD_REQUEST);
    }
}
