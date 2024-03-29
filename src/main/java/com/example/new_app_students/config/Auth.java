package com.example.new_app_students.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Auth extends WebSecurityConfigurerAdapter {

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("test").password(passwordEncoder().encode("test")).roles("USER")
                        .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/persons")
                .hasAnyAuthority("ROLE_USER")
                .antMatchers("/", "/persons")
                .hasAnyAuthority("ROLE_ADMIN")
                .and()
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/login")
                .failureForwardUrl("/login?error")
                .defaultSuccessUrl("/persons")
                .and()
                .logout()
                .logoutSuccessUrl("/");
    }
}

