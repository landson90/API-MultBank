package com.example.app.multbanck.multbank.config.interceptador;

import com.example.app.multbanck.multbank.config.exceptionValidation.ObjectNotFoundException;
import com.example.app.multbanck.multbank.config.exceptionValidation.StandardError;
import com.example.app.multbanck.multbank.config.exceptionValidation.ValidationError;
import com.example.app.multbanck.multbank.dto.ClientDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,
                                                        HttpServletRequest request) {

        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

        ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),
                "Erro de validação",
                System.currentTimeMillis());

        System.out.println(e.getBindingResult().getRawFieldValue("cpf"));
        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            err.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
