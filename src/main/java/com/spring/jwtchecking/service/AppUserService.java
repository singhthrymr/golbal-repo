package com.spring.jwtchecking.service;

import com.nimbusds.jose.JOSEException;
import com.spring.jwtchecking.dto.ApiResponse;
import com.spring.jwtchecking.dto.LoginInDto;
import com.spring.jwtchecking.entity.AppUser;

public interface AppUserService {
    ApiResponse signIn(LoginInDto dto) throws JOSEException;

    ApiResponse signUp(LoginInDto dto) throws JOSEException;
    AppUser verifyUser(LoginInDto dto);
    ApiResponse getAllUser();
}
