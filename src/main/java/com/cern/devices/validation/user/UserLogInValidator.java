package com.cern.devices.validation.user;

import com.cern.devices.dto.user.UserLogInRequestDto;
import com.cern.devices.error.UserError;
import com.cern.devices.exception.ValidationException;
import com.cern.devices.validation.Validator;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class UserLogInValidator implements Validator<UserLogInRequestDto> {

    @Override
    public void validate(UserLogInRequestDto request) throws ValidationException {
        Optional.ofNullable(request).orElseThrow(() -> new ValidationException(UserError.MISSING_DATA));
        Optional.ofNullable(request.getPassword()).orElseThrow(() -> new ValidationException(UserError.MISSING_PASSWORD));
        Optional.ofNullable(request.getUsername()).orElseThrow(() -> new ValidationException(UserError.MISSING_USERNAME));

        if (Stream.of(request.getUsername(), request.getPassword()).filter(Objects::nonNull).anyMatch(String::isEmpty))
            throw new ValidationException(UserError.INVALID_DATA);


    }

}