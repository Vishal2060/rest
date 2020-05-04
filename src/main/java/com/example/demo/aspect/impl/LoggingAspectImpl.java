package com.example.demo.aspect.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.demo.aspect.LoggingAspect;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggingAspectImpl implements LoggingAspect {

	@Override
	public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
		log.error("Exception in {}.{}() with cause = \'{}\' and exception = \'{}\'",
				joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
				e.getCause() != null ? e.getCause() : "NULL", e.getMessage(), e);
	}

	@Override
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		log.debug("Enter: {}.{}() with argument[s] = {}", joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
		try {
			Object result = joinPoint.proceed();
			log.debug("Exit: {}.{}() with result = {}", joinPoint.getSignature().getDeclaringTypeName(),
					joinPoint.getSignature().getName(), result);
			return result;
		} catch (IllegalArgumentException e) {
			log.error("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
					joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
			throw e;
		}
	}

}
