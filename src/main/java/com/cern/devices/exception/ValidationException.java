package com.cern.devices.exception;

import com.cern.devices.error.DeviceError;
import com.cern.devices.error.UserError;

public class ValidationException extends Exception {


    public ValidationException(UserError error) {
        super(error.getDescription());
    }

    public ValidationException(DeviceError error) {
        super(error.getDescription());
    }


}