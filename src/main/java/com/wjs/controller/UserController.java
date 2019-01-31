package com.wjs.controller;

import com.wjs.entity.User;
import com.wjs.result.Result;
import com.wjs.result.ResultUtil;
import com.wjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unchecked")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    public Result<User> getUser(@PathVariable("id") Integer id){
        return ResultUtil.success(userService.findUser(id));
    }

    @PostMapping("/user")
    public Result<User> insetUser(@RequestBody User user){
        return ResultUtil.success(userService.saveUser(user));
    }

    @GetMapping("/getAll")
    public Result<List<User>> getUsers(){
        return ResultUtil.success(userService.findAllUser());
    }

    @GetMapping("/delete/{id}")
    public Result<Boolean>  deleteUser(@PathVariable("id") String id){
        return ResultUtil.success(userService.deleteUser(Integer.valueOf(id)));
    }

    @PostMapping("/update")
    public Result<User> updateUser(Integer id,String lastName,String email){
        User user = userService.findUser(id);
        user.setLastName(lastName);
        user.setEmail(email);
        userService.updateUser(user);
        return ResultUtil.success(user);
    }
}

