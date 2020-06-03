package com.vis.store.service.user;

import com.vis.store.dao.UserDAO;
import com.vis.store.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
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

    }

    @Override
    @Transactional
    public User save(User user) {
        User savedUser = userDAO.save(user);
        log.debug("Saved User id: " + savedUser.getId());
        return userDAO.save(user);
    }

    @Override
    public User findById(Long l) {
        return null;
    }


}





