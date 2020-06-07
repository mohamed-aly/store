package com.vis.store.bundle.user;

import com.vis.store.bundle.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {

    Iterable<User> findAll();

}
