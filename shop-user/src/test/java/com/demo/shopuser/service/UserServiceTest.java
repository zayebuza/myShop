package com.demo.shopuser.service;


import com.demo.shopuser.ShopUserApplication;
import com.demo.shopuser.entity.User;
import com.demo.shopuser.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/25 12:25
 * 4
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopUserApplication.class)
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Test
    public void insertUser(){
        User user = new User();
        user.setEmail("2323266323@qq.com");
        user.setEmailIsActive(1);
        user.setSalt("111");
        user.setLoginPassword("111111");

        userService.insertUser(user);
    }

}
