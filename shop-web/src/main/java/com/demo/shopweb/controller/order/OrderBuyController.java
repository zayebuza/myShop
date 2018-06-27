package com.demo.shopweb.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/27 16:51
 * 4
 */
@RestController
public class OrderBuyController {

    @Reference
    ShoppingCartService shoppingCartService;

    @PostMapping(value="/confim")
    @ResponseBody
    public Object confim(@Param("addressId") Long addressId){
        //根据收货地址ID获取收货地址

        return null;
    }

}
