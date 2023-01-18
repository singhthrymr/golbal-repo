package com.spring.jwtchecking.dto;

import com.spring.jwtchecking.entity.AppUser;
import com.spring.jwtchecking.roleType.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {
    private Long userId;
    private String userName;
    private String email;
    private RoleType roleType;
    private String token;

    public AppUserDto(Long userId, String userName, String email, RoleType roleType) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.roleType = roleType;
    }

    public AppUserDto(AppUser user) {
      this.userId=user.getUserId();
      this.userName=user.getUserName();
      this.email=user.getEmail();
      this.roleType=getRoleType();
    }
}
