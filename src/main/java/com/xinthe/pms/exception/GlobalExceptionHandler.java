package com.xinthe.pms.exception;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.concurrent.TimeoutException;

@RestControllerAdvice
@DefaultProperties(defaultFallback = "defaultFallbackMethod")
public class GlobalExceptionHandler {

    @ExceptionHandler(TimeoutException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public ResponseEntity<String> handleTimeoutException(TimeoutException ex) {
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Request timed out");
    }

    // Hystrix fallback method
    public ResponseEntity<String> defaultFallbackMethod() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request failed. Please try again later.");
    }
}
