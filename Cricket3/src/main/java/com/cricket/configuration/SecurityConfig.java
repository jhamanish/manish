package com.cricket.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // API Security Configuration - Higher priority
    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfig extends WebSecurityConfigurerAdapter {
        
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/api/**")
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                    .antMatchers("/api/**").authenticated()
                .and()
                .httpBasic(); // Enable HTTP Basic Authentication for API endpoints
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("admin").password(passwordEncoder.encode("password")).roles("USER", "ADMIN")
                .and()
                .withUser("apiuser").password(passwordEncoder.encode("apipass")).roles("API_USER");
        }
    }

    // Web Security Configuration - Lower priority  
    @Configuration
    @Order(2)
    public static class FormLoginWebSecurityConfig extends WebSecurityConfigurerAdapter {
        
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .cors() // Important for CORS
                .and()
                .authorizeRequests()
                    .antMatchers("/", "/public/**").permitAll()
                    .antMatchers("/speed/**").authenticated()
                    .anyRequest().authenticated()
                .and()
                .formLogin() // Use form login instead of OAuth2 for Spring 4.x compatibility
                    .loginPage("/login").permitAll()
                    .defaultSuccessUrl("/dashboard", true)
                .and()
                .logout()
                    .logoutSuccessUrl("/");
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("admin").password(passwordEncoder.encode("password")).roles("USER", "ADMIN")
                .and()
                .withUser("webuser").password(passwordEncoder.encode("webpass")).roles("USER");
        }
    }
}