package com.springstudy.api;

import com.springstudy.config.RabbitMQConfig;
import groovy.util.logging.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQController.class);

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sendMsg")
    public String sendMsg(@RequestParam String key, @RequestParam String msg) {

        logger.info("msg:{},key:{}", msg, key);
        rabbitTemplate.convertAndSend(RabbitMQConfig.topicExchangeName, key, msg);

        return "消息发送成功！";
    }
}
