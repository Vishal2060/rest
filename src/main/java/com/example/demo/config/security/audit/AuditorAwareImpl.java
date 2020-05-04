package com.example.demo.config.security.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.demo.config.security.model.User;

@Component("auditorAware")
public class AuditorAwareImpl implements AuditorAware<String> {
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional
				.of(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
	}
}