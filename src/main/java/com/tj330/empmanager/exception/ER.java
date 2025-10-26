package com.tj330.empmanager.exception;
//eda ethu ErrorResponse.java
import java.time.LocalDateTime;

public class ER {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ER() {
        this.timestamp = LocalDateTime.now();
    }



    public ER(int status, String error, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }


    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }



    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

//നമ്മുടെ app-ൽ error വന്നാൽ, client-ന് ഇത് എങ്ങനെ explain ചെയ്യാമെന്ന് കാണിക്കുന്ന ചെറിയ box പോലെ ഇത്.
//Error ന്റെ type, സമയം, message, request path എല്ലാം കാണിക്കും.
//ഇത് ഉപയോഗിച്ച് debugging എളുപ്പം ആകും, user-നും clear info കിട്ടും.
