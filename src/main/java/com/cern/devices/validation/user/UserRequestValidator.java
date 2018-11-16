package com.cern.devices.validation.user;

import com.cern.devices.dto.user.UserLogInRequestDto;
import com.cern.devices.exception.ValidationException;
import com.cern.devices.validation.validatorWrapper.UserRequestValidatorWrapper;
import com.cern.devices.dto.user.UserSignUpRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRequestValidator implements UserRequestValidatorWrapper {

    @Autowired
    private UserLogInValidator userLogInValidator;

    @Autowired
    private UserSignUpValidator userSignUpValidator;

    @Override
    public void validate(UserLogInRequestDto userLogInRequestDto) throws ValidationException {
        userLogInValidator.validate(userLogInRequestDto);
    }

    @Override
    public void validate(UserSignUpRequestDto userSignUpRequestDto) throws ValidationException {
        userSignUpValidator.validate(userSignUpRequestDto);
    }
}
