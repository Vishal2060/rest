package com.example.demo.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.context.request.RequestContextListener;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
    private final AuthenticationProvider authenticationProvider;
    private final AuthenticationHandler authenticationHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/ignore");
        web.ignoring().antMatchers("/v3/api-docs/**");
        web.ignoring().antMatchers("/swagger.json");
        web.ignoring().antMatchers("/swagger-ui.html");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable();

        http.authorizeRequests()
                .antMatchers("/contact/**", "/student/**")
                .authenticated()
                .anyRequest()
                .permitAll();

        http.formLogin()
                .loginProcessingUrl("/login")
                .successHandler(authenticationHandler::success)
                .failureHandler(authenticationHandler::failure)
                .permitAll();

        http.exceptionHandling()
                .accessDeniedHandler(authenticationHandler::accessDenied);

        http.headers()
                .frameOptions()
                .disable();

        http.rememberMe()
                .rememberMeCookieName("JREMEMBER")
                .rememberMeParameter("remember")
                .key("!m$X*n*+")
                .tokenValiditySeconds(36000)
                .useSecureCookie(true);

        http.sessionManagement()
                .sessionFixation()
                .migrateSession()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(true);

        http.logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "JREMEMBER")
                .permitAll();
    }

    @Bean
    public HttpSessionEventPublisher getHttpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

    @Bean
    public RequestContextListener getRequestContextListener() {
        return new RequestContextListener();
    }
}
