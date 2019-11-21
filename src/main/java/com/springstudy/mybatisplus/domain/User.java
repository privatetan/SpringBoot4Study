package com.springstudy.mybatisplus.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 用户实体
 */
@Data
@TableName(value = "user")
public class User {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 名字
     */
    @TableField(value = "name")
    private String name;
    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;
    /**
     * 邮件
     */
    @TableField(value = "email")
    private String email;
}
