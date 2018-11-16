package com.cern.devices.controller;

import com.cern.devices.dto.user.GeneralResponseDto;
import com.cern.devices.dto.user.UserLogInRequestDto;
import com.cern.devices.dto.user.UserSignUpRequestDto;
import com.cern.devices.dto.user.UserLogInResponseDto;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping(path = "/api")
public interface UserController {

    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    UserLogInResponseDto login(UserLogInRequestDto userLogInRequestDto) throws Exception;

    @RequestMapping(path = "/signup", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    GeneralResponseDto signUp(UserSignUpRequestDto userSignUpRequestDto) throws Exception;


    @RequestMapping(path = "/validate_user/{userId}", method = RequestMethod.GET, produces = "application/json")
    GeneralResponseDto validateUser(@RequestHeader UUID authToken, @PathVariable Long userId) throws Exception;

}
