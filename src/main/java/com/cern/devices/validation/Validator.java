package com.cern.devices.validation;

import com.cern.devices.exception.ValidationException;

public interface Validator<T> {

    void validate(T request) throws ValidationException;

}
