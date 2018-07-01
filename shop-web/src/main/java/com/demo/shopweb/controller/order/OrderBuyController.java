package com.demo.shopweb.controller.order;


import com.alibaba.dubbo.config.annotation.Reference;

import com.demo.shopcommon.base.BaseController;
import com.demo.shopdubboapi.entity.order.Order;
import com.demo.shopdubboapi.entity.order.OrderShipment;
import com.demo.shopdubboapi.entity.order.OrderShoppingCartVO;
import com.demo.shopdubboapi.entity.product.CartVO;
import com.demo.shopdubboapi.entity.product.ShoppingCartVO;
import com.demo.shopdubboapi.entity.user.Address;
import com.demo.shopdubboapi.service.order.OrderService;
import com.demo.shopdubboapi.service.product.ShoppingCartService;
import com.demo.shopdubboapi.service.user.AddressService;
import com.demo.shopuser.common.CommonReturnCode;
import com.demo.shopuser.common.OsResult;
import com.demo.shopuser.enums.StatusEnum;
import com.demo.shopweb.common.utils.SingletonLoginUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

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
    AddressService addressService;
    @Reference(application = "${dubbo.application.id}")
    ShoppingCartService shoppingCartService;
    @Reference(application = "${dubbo.application.id}")
    OrderService orderService;

    @PostMapping(value = "/confirm")
    @ResponseBody
    public Object confirm( @RequestParam(value = "addressId", required = true) Long addressId) {
        Order order = new Order();
        // 收货地址
        //Address address = addressService.getAddress(addressId, SingletonLoginUtils.getUserId());
        CartVO cartVO = shoppingCartService.list(1L, StatusEnum.CHECKED.getStatus());
        Address address = addressService.getAddress(addressId, 1L);
        System.out.println(address);
        if (address != null) {
            OrderShipment orderShipment = new OrderShipment();
            BeanUtils.copyProperties(address, orderShipment);

            // 购物车选中商品
          //  CartVO cartVO = shoppingCartService.list(SingletonLoginUtils.getUserId(), StatusEnum.CHECKED.getStatus());
           // CartVO cartVO = shoppingCartService.list(1L, StatusEnum.CHECKED.getStatus());
            System.out.println("购物车选中商品"+cartVO.toString());
            if (!cartVO.getShoppingCartVOs().isEmpty()) {
                order.setBuyNumber(cartVO.getTotalNumber());// 订单总数量
                order.setOrderAmount(cartVO.getTotalPrice());// 订单总价格
                order.setOrderScore(cartVO.getTotalScore());// 订单总积分

                // 遍历购物车选中商品列表
                List<OrderShoppingCartVO> orderShoppingCartVOs = new ArrayList<OrderShoppingCartVO>();
                for (ShoppingCartVO vo : cartVO.getShoppingCartVOs()) {
                    OrderShoppingCartVO orderShoppingCartVO = new OrderShoppingCartVO();
                    BeanUtils.copyProperties(vo, orderShoppingCartVO);
                    orderShoppingCartVOs.add(orderShoppingCartVO);
                }
                Long orderNumber = orderService.insertOrder(order, orderShipment, orderShoppingCartVOs,
                        SingletonLoginUtils.getUserId());

                if (orderNumber != null) {
                    shoppingCartService.deleteCheckStatus(SingletonLoginUtils.getUserId());
                    return new OsResult(CommonReturnCode.SUCCESS, orderNumber.toString());
                    // TODO Long
                    // 17位传送末尾精读损失,例14944366378872495前台接收变成14944366378872494,解决方法toString,原因未知
                } else {
                    return new OsResult(CommonReturnCode.UNKNOWN_ERROR.getCode(),
                            CommonReturnCode.UNKNOWN_ERROR.getMessage());
                }
            } else {
                return new OsResult(CommonReturnCode.BAD_REQUEST.getCode(), "请选择想要购买的商品!");
            }
        } else {
            return new OsResult(CommonReturnCode.BAD_REQUEST.getCode(), "请选择正确的收货地址!");
        }
    }

}
