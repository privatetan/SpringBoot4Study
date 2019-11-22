package com.springstudy.mybatisplus.job.handler;

import com.springstudy.mybatisplus.domain.User;
import com.springstudy.mybatisplus.service.UserService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务插入数据库
 */
@JobHandler(value="userInsertHandler")
@Component
@Log4j2
public class UserInsertHandler  extends IJobHandler {
    @Autowired
    private UserService userService;
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        XxlJobLogger.log("定时任务开始。。。。。。。。。");
        User user = new User();
        user.setName("李四");
        user.setEmail("lisi@email.com");
        user.setAge(20);
        userService.insert(user);
        XxlJobLogger.log("定时任务结束。。。。。。。。。");

        return SUCCESS;
    }
}
