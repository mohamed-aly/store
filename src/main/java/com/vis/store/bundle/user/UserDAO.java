package com.vis.store.bundle.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {

    Iterable<User> findAll();

    @Query("Select new User(u.email, u.password) from User u where u.email=:email")
    User findByEmail(String email);

}
