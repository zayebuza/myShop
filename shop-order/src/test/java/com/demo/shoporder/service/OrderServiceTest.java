package com.demo.shoporder.service;

import com.demo.shoporder.bean.OrderShoppingCartVO;
import com.demo.shoporder.entity.Order;
import com.demo.shoporder.entity.OrderShipment;
import com.demo.shoporder.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miaodongbiao
 * Date:2018/6/26-22:41
 * Description:
 */
public class OrderServiceTest {
    @Autowired
    OrderServiceImpl orderService;
    @Test
    public void test(){
        Order order = new Order();
        order.setBuyNumber(1);
        order.setOrderAmount(BigDecimal.valueOf(1));
        order.setPayType(1);
        order.setShipmentAmount(BigDecimal.valueOf(1));

        OrderShipment orderShipment = new OrderShipment();
        orderShipment.setCityId(1);

        OrderShoppingCartVO orderShoppingCartVO = new OrderShoppingCartVO();
        orderShoppingCartVO.setProductNumber(Long.valueOf(1));
        List list = new ArrayList();
        list.add(orderShoppingCartVO);

        orderService.insertOrder(order,orderShipment,list, Long.valueOf(1));

    }
}
