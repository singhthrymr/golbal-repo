/**
 * Created By Sunil Verma
 * Date: 07/01/23
 * Time: 5:13 PM
 * Project Name: security
 */

package com.security.dto;

import com.security.entity.AppUser;
import com.security.enums.RoleType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SignInResponseDto {

	private String id;

	private String email;

	private RoleType roleType;

	private String name;

	private String token;

	public SignInResponseDto(AppUser user) {

		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.roleType = user.getRoleType();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public SignInResponseDto() {
		super();

	}

}
