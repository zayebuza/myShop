package com.demo.shopweb;

import com.demo.shoporder.entity.Order;
import com.demo.shopuser.entity.User;
import com.demo.shopweb.controller.order.OrderBuyController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopWebApplicationTests {
    @Autowired
    OrderBuyController orderBuyController;


    @Test
    public void contextLoadsss() {
        Order order = new Order();
        orderBuyController.confim(order,1L);
    }

}
