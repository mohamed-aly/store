package com.vis.store.bundle.user;

import com.vis.store.exceptions.EmailExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override

    public Set<User> findAll() {
        log.debug("I'm in the service");

        Set<User> userSet = new HashSet<>();
        userDAO.findAll().iterator().forEachRemaining(userSet::add);
        return userSet;
    }


    @Override
    public void deleteById(Long idToDelete) {
        userDAO.deleteById(idToDelete);
    }

    private boolean emailExist(final String email) {
        final User user = userDAO.findByEmail(email);
        return user != null;
    }

    @Override
    public User registerNewUser(final User insertedUser) throws EmailExistsException {
        if (emailExist(insertedUser.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " + insertedUser.getEmail());
        }

        insertedUser.setPassword(passwordEncoder.encode(insertedUser.getPassword()));
        return userDAO.save(insertedUser);
    }

    @Override
    public User updateExistingUser(User user) throws EmailExistsException {
        return null;
    }

    @Override
    public User findById(Long l) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }


}





