package com.vis.store.bundle.user;


import com.vis.store.bundle.user.User;

import java.util.Set;

public interface UserService {

    User save(User user);

    User findById(Long l);

    Set<User> findAll();

    void deleteById(Long idToDelete);
}
