package com.vis.store.config;


import com.vis.store.bundle.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.security.SecureRandom;


@EnableWebSecurity
@Configuration
public class LssSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;


    public LssSecurityConfig(@Qualifier("lssUserDetailsService") UserDetailsService userDetailsService, UserDAO userDAO) {
        this.userDetailsService = userDetailsService;
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {// @formatter:off
        auth.authenticationProvider(runAsAuthenticationProvider());
        auth.authenticationProvider(daoAuthenticationProvider());
    } // @formatter:on

    @Override
    protected void configure(HttpSecurity http) throws Exception {// @formatter:off
        http
                .authorizeRequests()
                .antMatchers("/product/**").authenticated()
                .anyRequest().permitAll()

                .and()
                .formLogin().permitAll()

                .and()
                .logout().permitAll()

                .and()
                .rememberMe()
                .tokenValiditySeconds(7)
                .key("lssAppKey")
                .rememberMeCookieName("rody")


                .and()
                .csrf().disable()
                .httpBasic()
        ;
    } // @formatter:on

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10, new SecureRandom());
    }

    @Bean
    public AuthenticationProvider runAsAuthenticationProvider(){
        RunAsImplAuthenticationProvider authenticationProvider = new RunAsImplAuthenticationProvider();
        authenticationProvider.setKey("MyRunAsKey");
        return authenticationProvider;
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider(){
        final DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

}
