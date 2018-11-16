package com.cern.devices.validation.device;

import com.cern.devices.exception.ValidationException;
import com.cern.devices.validation.Validator;
import com.cern.devices.dto.device.DeviceRegisterRequestDto;
import com.cern.devices.error.DeviceError;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeviceRegisterUpdateValidator implements Validator<DeviceRegisterRequestDto> {
    @Override
    public void validate(DeviceRegisterRequestDto request) throws ValidationException {
        Optional.ofNullable(request).orElseThrow(() -> new ValidationException(DeviceError.MISSING_DATA));
        Optional.ofNullable(request.getName()).orElseThrow(() -> new ValidationException(DeviceError.MISSING_NAME));
        Optional.ofNullable(request.getDescription()).orElseThrow(() -> new ValidationException(DeviceError.MISSING_DESCRIPTION));
        Optional.ofNullable(request.getOwner()).orElseThrow(() -> new ValidationException(DeviceError.MISSING_OWNER));
        Optional.ofNullable(request.getWeight()).orElseThrow(() -> new ValidationException(DeviceError.MISSING_WEIGHT));
    }
}
