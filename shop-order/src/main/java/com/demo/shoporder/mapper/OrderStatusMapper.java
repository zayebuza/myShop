package com.demo.shoporder.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demo.shoporder.entity.OrderStatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by miaodongbiao
 * Date:2018/6/26-22:31
 * Description:
 */
@Repository
@Mapper
public interface OrderStatusMapper extends BaseMapper<OrderStatus> {
}
