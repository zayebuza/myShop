package com.demo.shopuser.service;

import com.demo.shopuser.ShopUserApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/25 11:21
 * 4
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopUserApplication.class)
public class AddressServiceImplTest {
    @Autowired
    AddressServiceImpl addressService;
    @Test
    public void query(){

        List list =  addressService.listAddress(28l);
        System.out.println(list.get(0));
    }
    @Test
    public void getAddress(){

        System.out.println("地址"+addressService.getAddress(3L,1L).toString());
    }

}
