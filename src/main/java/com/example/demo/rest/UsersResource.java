package com.example.demo.rest;


import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersResource {

    @Autowired
    UserServices userServices;

    @GetMapping(path = "/users")
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }
    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        userServices.createUser(user);
    }
    @PostMapping("/role")
    public void createRole(@RequestBody Role role){
         userServices.createRole(role);
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return userServices.getAllRoles();
    }
    @PostMapping("/AddRoleToUser")
    public void AddRoleToUser(@RequestBody RoleUserForm R){
        userServices.addRoleToUser(R.getRoleName(),R.getUserName());
    }
}
class RoleUserForm{
    private String userName;
    private String roleName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
