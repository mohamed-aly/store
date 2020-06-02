package com.vis.store.service.user;

import stationary.store.model.User;

import java.util.List;


public interface UserService {

    List<User> getUsers();

    void saveUser(User theUser);

    User getUser(int theId);

    void deleteUser(int theId);

}
