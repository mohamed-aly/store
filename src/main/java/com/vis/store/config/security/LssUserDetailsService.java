package com.vis.store.config.security;


import com.vis.store.bundle.user.User;
import com.vis.store.bundle.user.UserDAO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class LssUserDetailsService implements UserDetailsService {

    private UserDAO userDAO;

    public LssUserDetailsService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final User user = userDAO.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + email);
        }
        return user;
    }



}