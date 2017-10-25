package com.leshukov.disk.controller.error;

import com.leshukov.disk.exception.DiskPickException;
import com.leshukov.disk.exception.DiskReturnException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dleshukov@alvioneurope.ru
 */
@ControllerAdvice
@ResponseBody
public class ServiceErrorHandler {

    @ExceptionHandler(DiskPickException.class)
    public ResponseEntity handleDiskPickException(DiskPickException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(DiskReturnException.class)
    public ResponseEntity handleDiskReturnException(DiskReturnException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
