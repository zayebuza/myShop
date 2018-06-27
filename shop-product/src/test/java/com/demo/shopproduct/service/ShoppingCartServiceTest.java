package com.demo.shopproduct.service;

import com.demo.shopproduct.service.impl.ShoppingCartServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/27 15:54
 * 4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceTest {
    @Autowired
    ShoppingCartServiceImpl shoppingCartService;
    @Test
    public void tt(){
        shoppingCartService.insertShoppingCart(1472581245880l, Long.valueOf(1));
    }

}
