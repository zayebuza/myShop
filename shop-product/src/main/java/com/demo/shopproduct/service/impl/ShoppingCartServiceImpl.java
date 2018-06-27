package com.demo.shopproduct.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.demo.shopproduct.bean.CartVO;
import com.demo.shopproduct.bean.ShoppingCartVO;
import com.demo.shopproduct.entity.ShoppingCart;
import com.demo.shopproduct.mapper.ShoppingCartMapper;
import com.demo.shopproduct.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Date;
import java.util.List;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/27 11:28
 * 4
 */
//注册为dubbo服务
@Service(version = "1.0.0")
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper,ShoppingCart> implements ShoppingCartService {
    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    /**
     * 加入购物车
     * @param productSpecNumber  商品规格编号
     * @param userId    用户ID
     * @return
     */
    @Override
    public Integer insertShoppingCart(Long productSpecNumber, Long userId) {
        //查找购物车是否存在该商品
        ShoppingCart queryShoppingCart = new ShoppingCart();
        queryShoppingCart.setProductSpecNumber(productSpecNumber);
        queryShoppingCart.setUserId(userId);
        ShoppingCart shoppingCart = shoppingCartMapper.selectOne(queryShoppingCart);

        //若数据库中购物车存在该商品,则增加该商品购买数量(在原基础上+1)
        if (shoppingCart != null){
            shoppingCart.setBuyNumber(shoppingCart.getBuyNumber()+1);
            return shoppingCartMapper.updateById(shoppingCart);

        }
        //如果不在购物车，将商品添加到购物车  若数据库中购物车不存在该商品,则添加该商品
        else{
            shoppingCart = new ShoppingCart();
            shoppingCart.setBuyNumber(1);
            shoppingCart.setUserId(userId);
            shoppingCart.setProductSpecNumber(productSpecNumber);
            shoppingCart.setCreateTime(new Date());
            return shoppingCartMapper.insert(shoppingCart);
        }

    }

    /**
     * 根据用户ID和购物车商品状态查找购物车列表
     * @param userId    用户ID
     * @param status    购物车商品状态（选中，未选中）
     * @return
     */
    @Override
    public CartVO list(Long userId, Integer status) {
        List<ShoppingCartVO> shoppingCartVOS = shoppingCartMapper.list(userId,status);
        CartVO cartVO = new CartVO();
        cartVO.setShoppingCartVOs(shoppingCartVOS);
        return cartVO;
    }

    /**
     * 更新购物车商品是否选中的状态
     * @param productSpecNumber 商品编号
     * @param userId    用户ID
     * @param status    购物车商品选中状态
     * @return
     */
    @Override
    public Integer updateStatus(Long productSpecNumber, Long userId, Integer status) {
        //查找用户购物车，判断该商品是否在购物车里
        ShoppingCart queryShoppingCart = new ShoppingCart();
        queryShoppingCart.setProductSpecNumber(productSpecNumber);
        queryShoppingCart.setUserId(userId);
        ShoppingCart shoppingCart = shoppingCartMapper.selectOne(queryShoppingCart);

        //如果购物车有数据并且数据状态不一致  才去数据库更新状态
        if (shoppingCart != null && !shoppingCart.getCheckStatus().equals(status)){
                shoppingCart.setCheckStatus(status);
                shoppingCart.setUpdateTime(new Date());
                return shoppingCartMapper.updateById(shoppingCart);
        }
        else{
            //todo 抛出一个商品不存在的异常
            return null;
        }

    }



}
