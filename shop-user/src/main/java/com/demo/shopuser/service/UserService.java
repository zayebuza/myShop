package com.demo.shopuser.service;

import com.baomidou.mybatisplus.service.IService;
import com.demo.shopuser.entity.User;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/27 17:35
 * 4
 */
public interface UserService extends IService<User> {

    /**
     * 根据username查找用户
     * @param username
     * @return
     */
    public User getUserByLoginName(String username);


    /**
     * 插入用户
     * @param user
     * @return
     */
    public Integer insertUser(User user);



}
