package com.localdev.springsecurityjwt.service;

import java.util.List;

import com.localdev.springsecurityjwt.entity.Role;
import com.localdev.springsecurityjwt.entity.User;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String userName, String roleName);

    User getUser(String userName);

    List<User> getUsers();
}
