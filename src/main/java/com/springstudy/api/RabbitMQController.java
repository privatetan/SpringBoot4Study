package com.springstudy.api;

import com.springstudy.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg")
    public String sendMsg(@RequestParam String msg, @RequestParam String key){

        rabbitTemplate.convertAndSend(RabbitMQConfig.topicExchangeName,key,msg);

        return "消息发送成功！";
    }
}
