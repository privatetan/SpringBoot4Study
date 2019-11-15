package com.springstudy.mybatisplus.api;

import com.springstudy.mybatisplus.domain.User;
import com.springstudy.mybatisplus.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户信息
     * @param id id
     * @return user
     */
    @GetMapping("/getUserById")
    @ApiOperation(value = "根据id查询用户信息")
    public User getUserById(@RequestParam Integer id){
        List<User> list =  new ArrayList<User>();
        list.add(userService.getUserById(id));

        User[] users = list.toArray(new User[0]);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(users[i].getName());
            System.out.println(list.get(i).getName());
        }


        return userService.getUserById(id);
    }
}
