package com.springstudy.service;

import com.springstudy.domain.User;
import com.springstudy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户service
 */
@Service
public class UserService {

    /**
     * mapper
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据id获取用户信息
     *
     * @param id id
     * @return 用户
     */
    public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }

    /**
     * 插入数据库
     *
     * @param user
     */
    public void insert(User user) {
        userMapper.insert(user);
    }
}
