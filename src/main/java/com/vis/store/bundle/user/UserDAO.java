package com.vis.store.bundle.user;

import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {

    Iterable<User> findAll();

    User findByEmail(String email);

}
