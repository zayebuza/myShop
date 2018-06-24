package com.demo.shopuser.service;

import com.demo.shopuser.entity.User;
import com.demo.shopuser.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by miaodongbiao
 * Date:2018/6/24-13:57
 * Description:
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User getUserByLoginName(String username) {
        return userMapper.getUserByLoginName(username);
    }
}
