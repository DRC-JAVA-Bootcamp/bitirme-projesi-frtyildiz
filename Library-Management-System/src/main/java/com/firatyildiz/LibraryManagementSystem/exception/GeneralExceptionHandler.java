package com.firatyildiz.LibraryManagementSystem.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

import javax.persistence.EntityNotFoundException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> methodNullPointerExceptionHandler (NullPointerException e)
    {
        String message = "Exception: " + e.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> methodNotFoundExceptionHandler (ChangeSetPersister.NotFoundException e)
    {
        String message = "Exception: " + e.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> noSuchElementFoundHandler (NoSuchElementException e)
    {
        String message = "Exception: " + e.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidHandler (MethodArgumentNotValidException e)
    {
        String message = "Exception: " + e.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundHandler (EntityNotFoundException e)
    {
        String message = "Exception: " + e.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalArgumantExceptionHandler (IllegalArgumentException e)
    {
        String message = "Exception: " + e.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public String methodNotSupportedHandler ()
    {
        return "Ups! HTTP Method not Supported.";
    }

    @ExceptionHandler(MultipartException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String multipartExceptionHandler ()
    {
        return "Ups! Invalid Upload Request.";
    }




}
