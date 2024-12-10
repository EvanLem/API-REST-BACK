package com.example.projet.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

public class ApiError {
    private int status;
    private String message;
    private String timestamp;

    public ApiError() {
    }

    public ApiError(int status, String message, String timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
