package com.wjs.service;

import com.wjs.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Boolean deleteUser(Integer id);
    User updateUser(User user);
    User findUser(Integer id);
    List<User> findAllUser();
}
