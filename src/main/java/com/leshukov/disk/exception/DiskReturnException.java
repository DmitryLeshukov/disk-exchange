package com.leshukov.disk.exception;

public class DiskReturnException extends RuntimeException {
    public DiskReturnException() {
    }

    public DiskReturnException(String message) {
        super(message);
    }
}
