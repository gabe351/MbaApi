package com.gabea.mbaapi.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoUsersFoundException extends ResponseStatusException {

    public NoUsersFoundException(String message){
        super(HttpStatus.NO_CONTENT, message);
    }
}