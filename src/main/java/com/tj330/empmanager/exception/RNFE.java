package com.tj330.empmanager.exception;
//eda ResourceNotFoundException.java
public class RNFE extends RuntimeException {

    public RNFE(String message) {
        super(message);
    }

    public RNFE(String message, Throwable cause) {
        super(message, cause);
    }
}