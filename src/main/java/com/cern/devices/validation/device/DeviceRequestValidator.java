package com.cern.devices.validation.device;

import com.cern.devices.exception.ValidationException;
import com.cern.devices.dto.device.DeviceRegisterRequestDto;
import com.cern.devices.validation.validatorWrapper.DeviceRequestValidatorWrapper;
import org.springframework.stereotype.Component;

@Component
public class DeviceRequestValidator implements DeviceRequestValidatorWrapper {
    @Override
    public void validate(DeviceRegisterRequestDto deviceRegisterRequestDto) throws ValidationException {

    }

  
}
