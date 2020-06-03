package com.vis.store.service.user;


import com.vis.store.model.User;

import java.util.Set;

public interface UserService {

    User save(User user);

    User findById(Long l);

    Set<User> findAll();

    void deleteById(Long idToDelete);
}
