package com.demo.shopuser.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demo.shopuser.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/25 11:11
 * 4
 */
@Repository
@Mapper
public interface AddressMapper extends BaseMapper<Address> {

}
