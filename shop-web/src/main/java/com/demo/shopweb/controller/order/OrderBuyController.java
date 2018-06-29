package com.demo.shopweb.controller.order;


import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.shopcommon.base.BaseController;
import com.demo.shopdubboapi.service.OrderService;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/27 16:51
 * 4
 */
@RestController
public class OrderBuyController extends BaseController {

    @Reference(application = "${dubbo.application.id}")
     private OrderService orderService;

    @RequestMapping(value = "/get")
    public void ha(){
        orderService.say();
    }


}
