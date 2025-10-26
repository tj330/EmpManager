package com.tj330.empmanager.exception;
//eda this is global exception handler
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GEH {

    @ExceptionHandler(RNFE.class)
    public ResponseEntity<ER> handleRNFE(RNFE ex, WebRequest request) {
        ER errorResponse = new ER(
                HttpStatus.NOT_FOUND.value(),
                "Not Found line 16 breaks",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }




    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ER> handleIllegalArgument(IllegalArgumentException ex, WebRequest request) {
        ER errorResponse = new ER(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request line 30 breaks",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ER> handleGlobal(Exception ex, WebRequest request) {
        ER errorResponse = new ER(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Internal Server Error line 43 breaks",
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}