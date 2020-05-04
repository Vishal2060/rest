package com.example.demo.config.security.utility;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;

import com.example.demo.config.security.model.Role;
import com.example.demo.config.security.model.User;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SecurityUtils {

	public User getCurrentUser() {
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public String getSessionId() {
		return RequestContextHolder.currentRequestAttributes().getSessionId();
	}

	public boolean isAdmin() {
		return getCurrentUser().getRoles().stream().anyMatch(SecurityUtils::checkIfAdmin);
	}

	public Boolean checkIfAdmin(Role role) {
		return role.getRoleName().equals("ADMIN");
	}

}