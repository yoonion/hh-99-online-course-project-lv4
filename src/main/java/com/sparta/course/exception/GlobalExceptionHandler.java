package com.sparta.course.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j(topic = "GlobalExceptionHandler 예외 전역 처리")
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleNoSuchElementExceptions(NoSuchElementException ex) {
        log.info("NoSuchElementException = {}", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleIllegalArgumentExceptions(IllegalArgumentException ex) {
        log.info("IllegalArgumentExceptionHandler = {}", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleExceptions(Exception ex) {
        log.info("Exception = {}", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse("INTERNAL-SERVER-ERROR"));
    }
}
