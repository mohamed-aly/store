package com.vis.store.bundle.user;


import com.vis.store.exceptions.EmailExistsException;

import java.util.Set;

public interface UserService {

    User registerNewUser(User user) throws EmailExistsException;

    User updateExistingUser(User user) throws EmailExistsException;


    User findById(Long l);

    User getUserByEmail(String email);

    Set<User> findAll();

    void deleteById(Long idToDelete);
}
