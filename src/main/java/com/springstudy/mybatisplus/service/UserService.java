package com.springstudy.mybatisplus.service;


import com.springstudy.mybatisplus.domain.User;
import com.springstudy.mybatisplus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户service
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(Integer id)  {
       return userMapper.selectById(id);
    }
}
