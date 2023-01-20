package com.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.security.enums.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Setter
@Getter

@Entity
@Table(name = "app_user")
@NoArgsConstructor
public class AppUser extends BaseEntity {
    private static final Logger logger = LoggerFactory.getLogger(AppUser.class);

    @Column(name = "email", unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private RoleType roleType;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Logger getLogger() {
		return logger;
	}

	public AppUser(String email, RoleType roleType, String name, String password) {
		super();
		this.email = email;
		this.roleType = roleType;
		this.name = name;
		this.password = password;
	}





}
