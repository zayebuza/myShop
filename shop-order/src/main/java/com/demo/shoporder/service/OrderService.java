package com.demo.shoporder.service;

import com.baomidou.mybatisplus.service.IService;
import com.demo.shoporder.bean.OrderShoppingCartVO;
import com.demo.shoporder.entity.Order;
import com.demo.shoporder.entity.OrderShipment;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/26 18:19
 * 4
 */
public interface OrderService extends IService<Order> {
    /**
     * 根据订单信息创建订单
     * @param order  订单信息
     * @param orderShipment  订单配送信息
     * @param list  购物车商品列表
     * @param userId    用户ID
     * @return
     */
    Long insertOrder(Order order, OrderShipment orderShipment, List<OrderShoppingCartVO> list,Long userId);

}
