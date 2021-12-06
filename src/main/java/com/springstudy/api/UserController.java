package com.springstudy.api;

import com.springstudy.domain.User;
import com.springstudy.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户接口")
@Log4j2
public class UserController {
    /**
     * 用户服务service
     */
    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户信息
     *
     * @param id id
     * @return user
     */
    @GetMapping("/getUserById")
    @ApiOperation(value = "根据id查询用户信息")
    public User getUserById(@RequestParam Integer id) {
        return userService.getUserById(id);
    }




}
