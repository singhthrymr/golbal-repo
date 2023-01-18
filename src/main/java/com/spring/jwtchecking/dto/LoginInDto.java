package com.spring.jwtchecking.dto;

import com.spring.jwtchecking.roleType.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInDto {
    private String email;

    private String password;

    private String userName;

    private RoleType roleType;
}
