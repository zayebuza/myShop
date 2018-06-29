package com.demo.shoporder.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.demo.shopdubboapi.entity.order.Order;
import com.demo.shopdubboapi.entity.order.OrderShipment;
import com.demo.shopdubboapi.entity.order.OrderShoppingCartVO;
import com.demo.shopdubboapi.entity.order.OrderStatus;
import com.demo.shopdubboapi.service.OrderService;
import com.demo.shoporder.common.enums.OrderCreateStatusEnum;
import com.demo.shoporder.common.enums.OrderStatusEnum;
import com.demo.shoporder.common.utils.OrderUtils;

import com.demo.shoporder.mapper.OrderMapper;
import com.demo.shoporder.mapper.OrderProductMapper;
import com.demo.shoporder.mapper.OrderShipmentMapper;
import com.demo.shoporder.mapper.OrderStatusMapper;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/26 18:27
 * 4
 */
@Service(interfaceClass = OrderServiceImpl.class,
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderShipmentMapper orderShipmentMapper;
    @Autowired
    OrderProductMapper orderProductMapper;
    @Autowired
    OrderStatusMapper orderStatusMapper;

    /**
     *
     * @param order  订单信息
     * @param orderShipment  订单配送信息
     * @param OrderShoppingCartVO
     * @param userId    用户ID
     * @return  返回订单号
     */
    @Transactional
    @Override
    public Long insertOrder(Order order, OrderShipment orderShipment, List<OrderShoppingCartVO> OrderShoppingCartVO, Long userId) {
        //创建订单
        Long orderNumber = OrderUtils.getOrderNumber();
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setUserId(userId);
        order.setOrderNumber(orderNumber);
        order.setPayAmount(OrderUtils.getPayAmount(order.getShipmentAmount(),order.getOrderAmount()));
        order.setOrderStatus(OrderStatusEnum.SUBMIT_ORDERS.getStatus());
        orderMapper.insert(order);

        //创建订单配送类表
        orderShipment.setOrderId(order.getOrderId());
        orderShipment.setUpdateTime(new Date());
        orderShipmentMapper.insert(orderShipment);

        //添加订单详情表
        //orderProductMapper.insertProduct(OrderShoppingCartVO,order.getOrderId());
        
        //添加订单状态记录表
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setCreateBy(userId.toString());
        orderStatus.setCreateTime(new Date());
        orderStatus.setRemarks(OrderStatusEnum.SUBMIT_ORDERS.getStateInfo());
        orderStatus.setOrderStatus(OrderStatusEnum.SUBMIT_ORDERS.getStatus());
        orderStatus.setOrderId(order.getOrderId());
        orderStatus.setCreateStatus(OrderCreateStatusEnum.MEMBER.getStatus());
        orderStatusMapper.insert(orderStatus);

        return order.getOrderNumber();
    }

    @Override
    public void say() {
        System.out.println("helloa");
    }
}
