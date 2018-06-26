package com.demo.shoporder;

import com.demo.shoporder.bean.OrderShoppingCartVO;
import com.demo.shoporder.entity.Order;
import com.demo.shoporder.entity.OrderShipment;
import com.demo.shoporder.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopOrderApplicationTests {

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
		orderShoppingCartVO.setBuyNumber(1);
		orderShoppingCartVO.setName("lisi");
		orderShoppingCartVO.setPrice(BigDecimal.valueOf(1));
		List list = new ArrayList();
		list.add(orderShoppingCartVO);

		orderService.insertOrder(order,orderShipment,list, Long.valueOf(1));

	}

}
