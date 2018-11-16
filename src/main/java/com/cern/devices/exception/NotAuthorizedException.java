package com.cern.devices.exception;

import com.cern.devices.error.UserError;

public class NotAuthorizedException extends Exception {

    public NotAuthorizedException(UserError error) {
        super(error.getDescription());
    }

}