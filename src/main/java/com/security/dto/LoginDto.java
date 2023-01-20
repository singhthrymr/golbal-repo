/**
 * Created By Sunil Verma
 * Date: 07/01/23
 * Time: 4:13 PM
 * Project Name: security
 */

package com.security.dto;

import com.security.enums.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class LoginDto {

	private String email;

	private String password;

	private String name;

	private RoleType roleType;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}



}
