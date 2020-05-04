package com.example.demo.config.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AuthenticationHandler {

	private final ObjectMapper objectMapper;

	public void success(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Authentication authentication) throws IOException, ServletException {
		Map<String, String> map = new HashMap<>();
		map.put("message", "Login Success");
		httpServletResponse.setStatus(HttpServletResponse.SC_OK);
		httpServletResponse.setCharacterEncoding("UTF-8");
		objectMapper.writeValue(httpServletResponse.getWriter(), map);
	}

	public void failure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {

		Map<String, String> map = new HashMap<>();
		String message = "";

		if (exception.getClass().isAssignableFrom(UsernameNotFoundException.class)) {
			message = "Username is not found.";
		} else if (exception.getClass().isAssignableFrom(DisabledException.class)) {
			message = "Your Account is Disabled.";
		} else if (exception.getClass().isAssignableFrom(LockedException.class)) {
			message = "Your account has been locked.";
		} else if (exception.getClass().isAssignableFrom(BadCredentialsException.class)) {
			message = "Bad Credentials : ";
		} else if (exception.getClass().isAssignableFrom(SessionAuthenticationException.class)) {
			message = "Maximum login limit Exceed.";
		}

		map.put("message", message);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.setCharacterEncoding("UTF-8");
		objectMapper.writeValue(response.getWriter(), map);
	}

	public void accessDenied(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AccessDeniedException e) throws IOException, ServletException {
		Map<String, String> map = new HashMap<>();
		map.put("message", "You are not Authorized User");
		httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		httpServletResponse.setCharacterEncoding("UTF-8");
		objectMapper.writeValue(httpServletResponse.getWriter(), map);
	}

}
