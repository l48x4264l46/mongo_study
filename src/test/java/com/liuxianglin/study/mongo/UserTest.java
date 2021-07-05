package com.liuxianglin.study.mongo;

import com.liuxianglin.study.mongo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @date 2021/6/6 12:18
 */
@SpringBootTest
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void insertTest() {
        userService.saveOne();
    }

    @Test
    public void queryAll() {
        userService.queryAll();
    }

    @Test
    public void saveAndQueryByParam(){
        userService.saveAndQueryByParam();
    }
}
