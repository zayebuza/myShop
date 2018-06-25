package com.demo.shopuser.service;

import com.demo.shopuser.ShopUserApplication;
import com.demo.shopuser.mapper.AddressMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class AddressServiceTest {
    AddressService addressService = new AddressService();
    @Test
    public void query(){

        List list =  addressService.listAddress(28l);
        System.out.println(list.get(0));
    }
}
