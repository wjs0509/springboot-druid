package com.wjs.controller;

import com.wjs.entity.User;
import com.wjs.result.Result;
import com.wjs.result.ResultUtil;
import com.wjs.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "用户接口")
@RestController
@SuppressWarnings("unchecked")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "根据主键id查询用户",notes = "根据主键id查询用户")
    @GetMapping("/user/{id}")
    public Result<User> getUser(@PathVariable("id") Integer id){
        return ResultUtil.success(userService.findUser(id));
    }

    @ApiOperation(value = "新增用户",notes = "新增用户")
    @PostMapping("/user")
    public Result<User> insetUser(@RequestBody User user){
        return ResultUtil.success(userService.saveUser(user));
    }

    @ApiOperation(value = "查询用户列表",notes = "查询用户列表")
    @GetMapping("/getAll")
    public Result<List<User>> getUsers(){
        return ResultUtil.success(userService.findAllUser());
    }

    @ApiOperation(value = "删除用户",notes = "删除用户")
    @GetMapping("/delete/{id}")
    public Result<Boolean>  deleteUser(@PathVariable("id") Integer id){
        Boolean deleteUser = userService.deleteUser(id);
        if(deleteUser){
            return ResultUtil.success(true);
        }else {
            return ResultUtil.nodata("无法查询到此用户");
        }
}
    @ApiOperation(value = "修改用户" ,  notes="修改用户")
    @PostMapping("/update")
    public Result<Boolean> updateUser(@RequestBody User user){
        Boolean has = userService.updateUser(user);
        if(has){
            return ResultUtil.success(true);
        }else {
            return ResultUtil.error(200,"请输入用户id");
        }

    }
}

