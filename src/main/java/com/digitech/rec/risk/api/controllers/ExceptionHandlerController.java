package com.digitech.rec.risk.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import com.digitech.rec.risk.api.exception.ApiErrors;
import com.digitech.rec.risk.api.exception.ResourceNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors validationErrors(MethodArgumentNotValidException e) {
        return new ApiErrors(e.getBindingResult());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors resourceError(ResourceNotFoundException e) {
        return new ApiErrors(e);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiErrors> responseErrors(ResponseStatusException e) {
        return new ResponseEntity<>(new ApiErrors(e), e.getStatus());
    }

}
