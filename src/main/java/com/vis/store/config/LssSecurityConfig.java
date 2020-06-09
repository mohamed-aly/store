package com.vis.store.config;


import com.vis.store.bundle.user.User;
import com.vis.store.bundle.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class LssSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;
    private UserDAO userDAO;

    public LssSecurityConfig(@Qualifier("lssUserDetailsService") UserDetailsService userDetailsService, UserDAO userDAO) {
        this.userDetailsService = userDetailsService;
        this.userDAO = userDAO;
    }


//    @PostConstruct
//    private void saveTestUser() {
//        final User user = new User();
//        user.setEmail("test@email.com");
//        user.setPassword(passwordEncoder().encode("pass"));
//        userDAO.save(user);
//    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {// @formatter:off
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
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
                .tokenValiditySeconds(6)
                .key("lssAppKey")
                .rememberMeCookieName("rody")


                .and()
                .csrf().disable()
                .httpBasic()
        ;
    } // @formatter:on

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
