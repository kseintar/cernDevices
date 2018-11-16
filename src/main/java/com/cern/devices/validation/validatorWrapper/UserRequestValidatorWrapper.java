package com.cern.devices.validation.validatorWrapper;

import com.cern.devices.dto.user.UserLogInRequestDto;
import com.cern.devices.exception.ValidationException;
import com.cern.devices.dto.user.UserSignUpRequestDto;

public interface UserRequestValidatorWrapper {

    void validate(UserLogInRequestDto userLogInRequestDto) throws ValidationException;

    void validate(UserSignUpRequestDto userSignUpRequestDto) throws ValidationException;

}
