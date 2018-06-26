package com.demo.shoporder.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demo.shoporder.bean.OrderShoppingCartVO;
import com.demo.shoporder.entity.OrderProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/26 19:08
 * 4
 */
public interface OrderProductMapper extends BaseMapper<OrderProduct> {

    /**
     * 插入订单明细
     * @param shoppingCartVOs  购物车选中商品
     * @param orderId   订单ID
     * @return
     */
    Integer insertProduct(@Param("shoppingCartVOs") List<OrderShoppingCartVO> shoppingCartVOs,
                          @Param("orderId") Long orderId);
}
