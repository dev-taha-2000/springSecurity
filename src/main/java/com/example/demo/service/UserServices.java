package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {
    void createUser(User user);
    void createRole(Role role);
    void addRoleToUser(String RoleName , String username);
    List<User> getAllUsers();
    List<Role> getAllRoles();
    User loadUserByUsername(String username);

}
