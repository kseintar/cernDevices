package com.cern.devices.controller;


import com.cern.devices.dto.device.DeviceRegisterRequestDto;
import com.cern.devices.dto.device.DeviceRegisterResponseDto;
import com.cern.devices.dto.device.DeviceResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;


@RestController
@RequestMapping(path = "/api")
public interface DeviceController {

    @RequestMapping(path = "/update_device", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    DeviceRegisterResponseDto updateDevice(@RequestHeader UUID authToken, DeviceRegisterRequestDto deviceRegisterRequestDto) throws Exception;

    @RequestMapping(path = "/get_devices/{userId}", method = RequestMethod.GET,  produces = "application/json")
    ArrayList<DeviceResponseDto> getDevices(@RequestHeader UUID authToken, @PathVariable Long userId) throws Exception;


    @RequestMapping(path = "/get_device/{deviceId}", method = RequestMethod.GET, produces = "application/json")
    DeviceResponseDto getDevice(@PathVariable Long deviceId) throws Exception;

    @RequestMapping(path = "/delete_device/{deviceId}/{userId}", method = RequestMethod.DELETE, produces = "application/json")
    DeviceRegisterResponseDto deleteDevice(@RequestHeader UUID authToken, @PathVariable Long deviceId, @PathVariable Long userId) throws Exception;

}
