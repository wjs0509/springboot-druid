package com.wjs.serviceImpl;

import com.wjs.entity.User;
import com.wjs.repository.UserRepository;
import com.wjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    //    增加user
    @Override
    public User saveUser(User user) {
        User save = userRepository.save(user);
        return save;
    }

//    删除user
    @Override
    public Boolean deleteUser(Integer id) {
        if (id == null) {
            return false;
        }
        User user = userRepository.findOne(id);
        if (user != null) {
            userRepository.delete(id);
            return true;
        } else {
            return false;
        }
    }

//    修改user
    @Override
    public Boolean updateUser(User user) {
        if(user.getId() != null){
            userRepository.save(user);
            return true;
        }else {
            return false;
        }
    }

//    查找user
    @Override
    public User findUser(Integer id) {
        User user = userRepository.findOne(id);
        return user;
    }

    @Override
    public List<User> findAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
