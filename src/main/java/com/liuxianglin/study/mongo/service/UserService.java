package com.liuxianglin.study.mongo.service;

/**
 * <p>
 *     用户service
 * </p>
 *
 * @author LiuXiangLin
 * @version 1.0
 * @date 2021/6/6 12:18
 */
public interface UserService {
    /**
     * <p>
     * 新增一条数据
     * </p>
     *
     * @return int
     * @author LiuXiangLin
     * @date 2021/7/3 14:43
     **/
    int saveOne();

    /**
     * <p>
     * 查询所有数据
     * </p>
     *
     * @author LiuXiangLin
     * @date 2021/7/4 20:50
     **/
    void queryAll();

    /**
     * <p>
     * 新增后通过条件查询部分数据
     * </p>
     *
     * @author LiuXiangLin
     * @date 2021/7/5 22:56
     **/
    void saveAndQueryByParam();
}
