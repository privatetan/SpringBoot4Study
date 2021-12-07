package com.springstudy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @PostMapping("/sendRedisMsg")
    public String sendRedisMsg(@RequestParam String redisKey, @RequestParam String redisValue) {

        redisTemplate.boundValueOps(redisKey).set(redisValue);

        return "消息发送成功！";
    }
}
