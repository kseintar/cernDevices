package com.cern.devices.exception;

import com.cern.devices.error.UserError;

public class NotAuthenticatedException extends Exception {

    public NotAuthenticatedException(UserError error) {
        super(error.getDescription());
    }



}

