package com.demo.shopproduct.service;

import com.baomidou.mybatisplus.service.IService;
import com.demo.shopproduct.bean.CartVO;
import com.demo.shopproduct.entity.ShoppingCart;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/27 11:15
 * 4
 */
public interface ShoppingCartService extends IService<ShoppingCart> {

    /**
     * 添加到购物车
     * @param productSpecNumber  商品规格编号
     * @param userId    用户ID
     * @return
     */
    Integer insertShoppingCart(Long productSpecNumber,Long userId);

    /**
     * 根据用户ID、购物车商品状态查找购物车列表
     * @param userId    用户ID
     * @param status    购物车商品状态（选中，未选中）
     * @return
     */
    CartVO list(Long userId,Integer status);

    /**
     * 根据商品编号，用户ID 跟新购物车的是否选中状态
     * @param productSpecNumber 商品编号
     * @param userId    用户ID
     * @param status    购物车商品选中状态
     * @return
     */
    Integer updateStatus(Long productSpecNumber,Long userId,Integer status);

    /**
     * 根据用户ID删除购物车中选中的商品
     * @param userId 用户ID
     * @return
     */
    Integer deleteCheckStatus(Long userId);
}
