package com.cern.devices.validation.validatorWrapper;

import com.cern.devices.exception.ValidationException;
import com.cern.devices.dto.device.DeviceRegisterRequestDto;

public interface DeviceRequestValidatorWrapper {
    void validate(DeviceRegisterRequestDto deviceRegisterRequestDto) throws ValidationException;

}
