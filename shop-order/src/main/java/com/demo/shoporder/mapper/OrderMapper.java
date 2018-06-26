package com.demo.shoporder.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demo.shoporder.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/26 18:30
 * 4
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
