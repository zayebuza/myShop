package com.demo.shoporder.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.demo.shoporder.bean.OrderShoppingCartVO;
import com.demo.shoporder.common.enums.OrderStatusEnum;
import com.demo.shoporder.common.utils.OrderUtils;
import com.demo.shoporder.entity.Order;
import com.demo.shoporder.entity.OrderShipment;
import com.demo.shoporder.entity.OrderStatus;
import com.demo.shoporder.mapper.OrderMapper;
import com.demo.shoporder.mapper.OrderProductMapper;
import com.demo.shoporder.mapper.OrderShipmentMapper;
import com.demo.shoporder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/26 18:27
 * 4
 */
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderShipmentMapper orderShipmentMapper;
    @Autowired
    OrderProductMapper orderProductMapper;

    @Override
    public Long insertOrder(Order order, OrderShipment orderShipment, List<OrderShoppingCartVO> shoppingCartVOs, Long userId) {
        //创建订单
        Long orderNumber = OrderUtils.getOrderNumber();
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setUserId(userId);
        order.setPayAmount(OrderUtils.getPayAmount(order.getShipmentAmount(),order.getOrderAmount()));
        order.setOrderStatus(OrderStatusEnum.SUBMIT_ORDERS.getStatus());
        orderMapper.insert(order);

        //创建订单配送类表
        orderShipment.setOrderId(order.getOrderId());
        orderShipment.setUpdateTime(new Date());
        orderShipmentMapper.insert(orderShipment);

        //添加订单详情表
        orderProductMapper.insertProduct(shoppingCartVOs,order.getUserId());
        
        //添加订单状态记录表
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setCreateBy(userId.toString());
        orderStatus.setCreateTime(new Date());
        // TODO: 2018/6/26  
        orderStatus.setRemarks();
    
        //


        return null;
    }
}
