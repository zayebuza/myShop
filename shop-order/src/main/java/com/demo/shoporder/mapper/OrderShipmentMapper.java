package com.demo.shoporder.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demo.shoporder.entity.OrderShipment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/26 19:05
 * 4
 */
@Repository
@Mapper
public interface OrderShipmentMapper extends BaseMapper<OrderShipment> {
}
