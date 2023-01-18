package com.spring.jwtchecking.controller;

import com.nimbusds.jose.JOSEException;
import com.spring.jwtchecking.dto.ApiResponse;
import com.spring.jwtchecking.dto.LoginInDto;
import com.spring.jwtchecking.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping(value = "/sign-in")
    public ApiResponse signIn(@RequestBody LoginInDto dto) throws JOSEException {
        return appUserService.signIn(dto);
    }

    @PostMapping(value = "/sign-up")
    public ApiResponse signUp( @RequestBody LoginInDto dto) throws JOSEException {
        return appUserService.signUp(dto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    @GetMapping(value = "/get-all")
    public ApiResponse getAllUser() {
        return appUserService.getAllUser();
    }
}
