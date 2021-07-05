package com.liuxianglin.study.mongo.entity;

import lombok.Data;

/**
 * <p>
 *    用户对象
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @date 2021/6/6 12:18
 */
@Data
public class User {
    /**主键*/
    private String id;

    /**姓名*/
    private String name;

    /**年龄*/
    private Integer age;
}
