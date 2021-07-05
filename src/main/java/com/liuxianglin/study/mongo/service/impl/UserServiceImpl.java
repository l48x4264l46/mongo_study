package com.liuxianglin.study.mongo.service.impl;

import com.liuxianglin.study.mongo.service.UserService;
import com.mongodb.client.*;
import lombok.extern.log4j.Log4j2;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author LiuXiangLin
 * @version 1.0
 * @date 2021/6/6 12:18
 * @see com.liuxianglin.study.mongo.service.UserService
 */
@Service
@Log4j2
public class UserServiceImpl implements UserService {
    @Autowired
    private MongoClient mongoDbClient;

    @Override
    public int saveOne() {
        // 创建文档对象
        var document = new Document("name", "zhaoliu");
        document.append("age", 18);

        // 新建一个兄弟文档
        var brotherDoc = new Document("name", "zhouqi");
        brotherDoc.append("age", 15);

        // 添加兄弟文档
        document.put("brother", brotherDoc);

        // 获取数据库对象
        MongoDatabase usersDb = mongoDbClient.getDatabase("study");

        // 获取相应的集合
        MongoCollection<Document> users = usersDb.getCollection("users");

        // 将新的记录插入到集合中
        users.insertOne(document);

        // 关闭客户端
        mongoDbClient.close();

        return 1;
    }

    @Override
    public void queryAll() {
        // 获取数据库对象
        MongoDatabase usersDb = mongoDbClient.getDatabase("study");

        // 获取相应的集合
        MongoCollection<Document> users = usersDb.getCollection("users");

        // 查询所有的数据
        FindIterable<Document> documents = users.find(new Document());

        // 便利输出数据
        documents.forEach(System.out::println);

        // 关闭连接
        mongoDbClient.close();
    }

    @Override
    public void saveAndQueryByParam() {
        // 获取数据库对象
        MongoDatabase studyDb = mongoDbClient.getDatabase("study");

        // 通过数据库获取表数据
        MongoCollection<Document> items = studyDb.getCollection("items");

        // 新增多条数据
        items.insertMany(Arrays.asList(
                Document.parse("{name: 'apple', qty: 10, size: {h: 10, w: 5}, status: 'A'}"),
                Document.parse("{name: 'orange', qty: 8, size: {h: 8, w: 3}, status: 'B'}"),
                Document.parse("{name: 'banana', qty: 12, size: {h: 15, w: 2}, status: 'B'}"),
                Document.parse("{name: 'pear', qty: 3, size: {h: 10, w: 10}, status: 'C'}"),
                Document.parse("{name: 'watermelon', qty:1, size: {h: 30, w: 30}, status: 'A'}"),
                Document.parse("{name:' strawberry', qty: 20, size: {h: 2, w: 3}, status: 'C'}")
        ));

        // 通过条件查询数据
        FindIterable<Document> documents = items.find(new Document("status", "A"));

        // 遍历输出数据
        documents.forEach(System.out::println);

        // 关闭客户端
        mongoDbClient.close();
    }

}