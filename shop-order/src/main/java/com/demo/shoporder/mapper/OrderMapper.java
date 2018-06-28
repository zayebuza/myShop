package com.demo.shoporder.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demo.shopdubboapi.entity.order.Order;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/26 18:30
 * 4
 */
@Repository
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
