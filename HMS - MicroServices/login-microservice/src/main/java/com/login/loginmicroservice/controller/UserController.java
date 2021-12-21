package com.login.loginmicroservice.controller;


import com.login.loginmicroservice.exception.UserFoundException;
import com.login.loginmicroservice.model.Role;
import com.login.loginmicroservice.model.User;
import com.login.loginmicroservice.model.UserRole;
import com.login.loginmicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //create user
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception {

        user.setProfile("default.png");

        //encode password with bcrypt passwordencoder
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

        Set<UserRole> roles = new HashSet<>();

        Role role = new Role();
        role.setRoleId(3);
        role.setRoleName("RECEPTION");

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        roles.add(userRole);

        return this.userService.createUser(user, roles);
    }

    //get user by id
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    //delete user by id
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }

    //update api

    @ExceptionHandler(UserFoundException.class)
    public UserFoundException exceptionHandler(UserFoundException ex){
        return ex;
    }

}
