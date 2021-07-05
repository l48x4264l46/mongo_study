package com.liuxianglin.study.mongo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * MongoDB配置类
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @date 2021/6/6 12:18
 */
@Configuration
public class MongoDbConfig {
    /**
     * <p>
     * 创建一个mongoDBClient
     * </p>
     *
     * @return com.mongodb.client.MongoClient
     * @author LiuXiangLin
     * @date 2021/7/5 22:22
     **/
    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://root:root@192.168.228.130:27017");
    }
}
