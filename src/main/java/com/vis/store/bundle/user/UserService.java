package com.vis.store.bundle.user;


import java.util.Set;

public interface UserService {

    User save(User user);

    User findById(Long l);

    User getUserByEmail(String email);

    Set<User> findAll();

    void deleteById(Long idToDelete);
}
