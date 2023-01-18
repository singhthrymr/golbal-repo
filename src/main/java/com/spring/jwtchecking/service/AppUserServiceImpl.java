package com.spring.jwtchecking.service;

import com.nimbusds.jose.JOSEException;
import com.spring.jwtchecking.dto.ApiResponse;
import com.spring.jwtchecking.dto.AppUserDto;
import com.spring.jwtchecking.dto.LoginInDto;
import com.spring.jwtchecking.entity.AppUser;
import com.spring.jwtchecking.repository.AppUserRepository;
import com.spring.jwtchecking.securityconfiguration.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    JwtTokenUtils jwtTokenUtils;
    @Override
    public ApiResponse signIn(LoginInDto dto) throws JOSEException {
        AppUser user = userRepository.findByEmail(dto.getEmail());

        if (user == null) {
            return new ApiResponse(HttpStatus.UNAUTHORIZED.value(), "Email id is wrong", "FAILED");
        }

        if (bCryptPasswordEncoder.matches(dto.getPassword(), user.getPassword())) {
            AppUserDto response = new AppUserDto(user);
            response.setToken(jwtTokenUtils.getToken(user));
            return new ApiResponse(HttpStatus.OK.value(), response);
        } else {
            return new ApiResponse(HttpStatus.UNAUTHORIZED.value(), "Password is wrong", "FAILED");
        }
    }

    @Override
    public ApiResponse signUp(LoginInDto dto) throws JOSEException {

        AppUser user = new AppUser();

        user.setEmail(dto.getEmail());
        user.setUserName(dto.getUserName());
        user.setRoleType(dto.getRoleType());
        user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));

        userRepository.save(user);

        return new ApiResponse(HttpStatus.OK.value(), "Registration is done", "SUCCESS");
    }


        @Override
    public AppUser verifyUser(LoginInDto dto) {
        AppUser user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            return null;
        }
        if (bCryptPasswordEncoder.matches(dto.getPassword(), user.getPassword())) {
            AppUserDto response = new AppUserDto(user);
            response.setToken(dto.getEmail()+":"+dto.getPassword());
            return user;
        } else {
            return null;
        }
    }

    @Override
    public ApiResponse getAllUser() {
        return new ApiResponse(HttpStatus.OK.value(), userRepository.findAll().stream().map(AppUserDto :: new).toList());
    }
}


