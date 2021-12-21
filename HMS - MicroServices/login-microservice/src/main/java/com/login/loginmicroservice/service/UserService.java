package com.login.loginmicroservice.service;

import com.login.loginmicroservice.model.User;
import com.login.loginmicroservice.model.UserRole;

import java.util.Set;

public interface UserService {

    //creating User
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    // get user by username
    public  User getUser(String username);

    //delete user
    public  void deleteUser(Long userId);


}
