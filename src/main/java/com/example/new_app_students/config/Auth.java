package com.example.new_app_students.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
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
                .antMatchers("/", "/persons") //mamy dostęp na ROLE_USER tylko do tych wymienionych URL
                .hasAnyAuthority("ROLE_USER") // definiujemy role dla powyższych URL
                .antMatchers("/tasks") //mamy dostęp na ROLE_ADMIN tylko do tych wymienionych URL
                .hasAnyAuthority("ROLE_ADMIN")// definiujemy role dla powyższych URL
                .and() // dopisujemy aby kontynuować konfiguracje kolejnych bloków
                .csrf().disable() // wyączamy csrf do testowania postmanem
                .headers().frameOptions().disable()
                .and()
                .formLogin()// rozpoczynamy konfiguracje formularza uwierzytelniania
                .loginPage("/login")//wskazujemy endpointa w którym będzie odbywać się uwierzytelnianie
                .usernameParameter("username")//nadajemy nazwę jaka będzie jako name w inpucie loginu formularza
                .passwordParameter("password")//nadajemy nazwę jaka będzie jako name w inpucie hasła formularza
                .loginProcessingUrl("/login")
                .failureForwardUrl("/login?error") // co się stanie jak będzie błąd logowania
                .defaultSuccessUrl("/persons") // co sięstanie w momencie prawidłowego wpisania loginu i hasła
                .and()
                .logout()
                .logoutSuccessUrl("/"); // wskazujemy na który endpoint ma nas przekierować jak się wyloghujmey
    }
}

