package com.digitech.rec.risk.api.exception;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

public class ApiErrors {
    private List<String> errors = new ArrayList<>();

    public ApiErrors(BindingResult validationErros) {
        validationErros.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage).forEach(errors::add);
    }

    public ApiErrors(ResourceNotFoundException e) {
        errors = List.of(e.getMessage());
    }

    public ApiErrors(ResponseStatusException e) {
        errors = List.of(e.getReason());
    }

    public List<String> getErrors() {
        return errors;
    }
}