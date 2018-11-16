package com.cern.devices.controller;

import com.cern.devices.dto.device.DeviceResponseDto;
import com.cern.devices.session.SessionInfo;
import com.cern.devices.authentication.Authenticator;
import com.cern.devices.dao.DeviceRepository;
import com.cern.devices.dao.UserRepository;
import com.cern.devices.dto.device.DeviceRegisterRequestDto;
import com.cern.devices.dto.device.DeviceRegisterResponseDto;
import com.cern.devices.entity.Device;
import com.cern.devices.entity.User;
import com.cern.devices.error.UserError;
import com.cern.devices.exception.NotAuthorizedException;
import com.cern.devices.validation.device.DeviceRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class DeviceControllerImpl implements DeviceController {
    @Autowired
    DeviceRepository repository;

    @Autowired
    private Authenticator authenticator;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeviceRequestValidator deviceRequestValidator;


    @Override
    public DeviceRegisterResponseDto updateDevice(@RequestHeader UUID authToken, @RequestBody DeviceRegisterRequestDto deviceRegisterRequestDto) throws Exception {

        //Get Active Session
        SessionInfo sessionInfo = authenticator.checkUpdateSession(authToken);
        User user = userRepository.findUsersById(deviceRegisterRequestDto.getUserId());
        //Validate Authorization
        if (!user.getId().equals(sessionInfo.getUserId()))
            throw new NotAuthorizedException(UserError.UNAUTHORIZED);

        deviceRequestValidator.validate(deviceRegisterRequestDto);

        Device deviceEntity;
        if (deviceRegisterRequestDto.getId()==null)
        {
            deviceEntity =new Device();
            deviceEntity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        }
        else
        {
            deviceEntity = repository.findDevicesById(deviceRegisterRequestDto.getId()).get(0);
        }

        deviceEntity.setOwner(deviceRegisterRequestDto.getOwner());
        deviceEntity.setName(deviceRegisterRequestDto.getName());
        deviceEntity.setDescription(deviceRegisterRequestDto.getDescription());
        deviceEntity.setWeight(deviceRegisterRequestDto.getWeight());
        repository.save(deviceEntity);
        DeviceRegisterResponseDto response = new DeviceRegisterResponseDto(HttpStatus.OK,"Device is registered succesfully");
        return response;


    }

    @Override
    public ArrayList<DeviceResponseDto> getDevices(@RequestHeader UUID authToken, @PathVariable Long userId) throws Exception {

        //Get Active Session
        SessionInfo sessionInfo = authenticator.checkUpdateSession(authToken);
        User user = userRepository.findUsersById(userId);
        //Validate Authorization
        if (!user.getId().equals(sessionInfo.getUserId()))
            throw new NotAuthorizedException(UserError.UNAUTHORIZED);

        ArrayList<DeviceResponseDto> deviceResponseDtos = new ArrayList<>();
        for(Device device : repository.findAll()){
            DeviceResponseDto deviceDto = new DeviceResponseDto();
            deviceDto.setName(device.getName());
            deviceDto.setDescription(device.getDescription());
            deviceDto.setCreateDate(device.getCreateDate());
            deviceDto.setWeight(device.getWeight());
            deviceDto.setId(device.getId());
            deviceDto.setOwner(device.getOwner());
            deviceResponseDtos.add(deviceDto);
        }
        return deviceResponseDtos;

    }

    @Override
    public DeviceResponseDto getDevice(@PathVariable Long deviceId) throws Exception {
      List<Device> devices =repository.findDevicesById(deviceId);
      Device deviceEntity = devices.get(0);
      DeviceResponseDto deviceDto = new DeviceResponseDto();
      deviceDto.setName(deviceEntity.getName());
      deviceDto.setDescription(deviceEntity.getDescription());
      deviceDto.setWeight(deviceEntity.getWeight());
      deviceDto.setId(deviceEntity.getId());
      deviceDto.setOwner(deviceEntity.getOwner());
      return deviceDto;
    }

    @Override
    public DeviceRegisterResponseDto deleteDevice(@RequestHeader UUID authToken, @PathVariable Long deviceId, @PathVariable Long userId) throws Exception {

        //Get Active Session
        SessionInfo sessionInfo = authenticator.checkUpdateSession(authToken);
        User user = userRepository.findUsersById(userId);
        //Validate Authorization
        if (!user.getId().equals(sessionInfo.getUserId()))
            throw new NotAuthorizedException(UserError.UNAUTHORIZED);

        repository.delete(deviceId);
        DeviceRegisterResponseDto response = new DeviceRegisterResponseDto(HttpStatus.OK,"Device is deleted succesfully");
        return  response;
    }


}
