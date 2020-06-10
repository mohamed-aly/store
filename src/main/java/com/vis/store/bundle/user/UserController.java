package com.vis.store.bundle.user;

import com.vis.store.exceptions.EmailExistsException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@Validated
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public Set<User> getUsers(){
        return userService.findAll();
    }

    @PostMapping("/save")
    User newEmployee(@RequestBody User user) throws EmailExistsException {
        return userService.registerNewUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }

    @PatchMapping("/update")
    public User updateUser(@RequestBody User user) throws EmailExistsException {
        User updatedUser = userService.updateExistingUser(user);
        updatedUser.setPassword(null);
        return updatedUser;
    }

    @GetMapping("/currentUser")
    @Secured({"ROLE_ADMIN", "RUN_AS_REPORTER"})
    public Object currentUser(){
        return userService.getCurrentUser().getPrincipal();
    }




}
	

	

















