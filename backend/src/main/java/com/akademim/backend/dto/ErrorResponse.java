package com.akademim.backend.dto;

public class ErrorResponse {
    private int status;
    private String message;

    public ErrorResponse(int status, String message){
        this.status = status;
        this.message = message;
    }

    //getter

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
