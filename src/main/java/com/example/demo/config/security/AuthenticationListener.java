package com.example.demo.config.security;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationFailureDisabledEvent;
import org.springframework.security.authentication.event.AuthenticationFailureLockedEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.web.authentication.session.SessionFixationProtectionEvent;
import org.springframework.security.web.authentication.switchuser.AuthenticationSwitchUserEvent;
import org.springframework.session.events.SessionCreatedEvent;
import org.springframework.session.events.SessionDeletedEvent;
import org.springframework.session.events.SessionExpiredEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationListener {

	@EventListener
	public void onAuthenticationFailureBadCredentialsEvent(AuthenticationFailureBadCredentialsEvent event) {
	}

	@EventListener
	public void onAuthenticationFailureDisabledEvent(AuthenticationFailureDisabledEvent event) {
	}

	@EventListener
	public void onAuthenticationFailureLockedEvent(AuthenticationFailureLockedEvent event) {
	}

	@EventListener
	public void onAuthenticationSuccessEvent(AuthenticationSuccessEvent event) {
		System.out.println("Login Success : " + event.getAuthentication().getName());
	}

	@EventListener
	public void onAuthenticationSwitchUserEvent(AuthenticationSwitchUserEvent event) {
	}

	@EventListener
	public void onInteractiveAuthenticationSuccessEvent(InteractiveAuthenticationSuccessEvent event) {
	}

	@EventListener
	public void onSessionCreatedEvent(SessionCreatedEvent event) {
	}

	@EventListener
	public void onSessionDeletedEvent(SessionDeletedEvent event) {
	}

	@EventListener
	public void onSessionExpiredEvent(SessionExpiredEvent event) {
	}

	@EventListener
	public void onSessionFixationProtectionEvent(SessionFixationProtectionEvent event) {
	}

}
