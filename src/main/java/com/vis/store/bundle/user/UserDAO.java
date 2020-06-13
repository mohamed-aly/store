package com.vis.store.bundle.user;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long> {

    @Query("Select u from User u where u.email=:email")
    User findByEmail(String email);

    @Query("Select max(u.id) from User u")
    Long getMaxId();

}
