package com.wjs.controller;

import com.wjs.entity.User;
import com.wjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.findUser(id);
    }

    @PostMapping("/user")
    public User insetUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getUsers(){
        return userService.findAllUser();
    }

    @GetMapping("/delete/{id}")
    public Boolean  deleteUser(@PathVariable("id") String id){
        return userService.deleteUser(Integer.valueOf(id));
    }

    @PostMapping("/update")
    public User updateUser(Integer id,String lastName,String email){
        User user = userService.findUser(id);
        user.setLastName(lastName);
        user.setEmail(email);
        userService.updateUser(user);
        return user;
    }
}

