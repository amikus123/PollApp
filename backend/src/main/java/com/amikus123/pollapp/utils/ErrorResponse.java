package com.amikus123.pollapp.utils;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ErrorResponse {
    public String message;
    public HttpStatus status;
}
