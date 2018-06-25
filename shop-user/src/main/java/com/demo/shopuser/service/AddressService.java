package com.demo.shopuser.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.demo.shopuser.entity.Address;
import com.demo.shopuser.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/25 11:09
 * 4
 */
public class AddressService extends ServiceImpl<AddressMapper,Address> {
    @Autowired
    AddressMapper addressMapper;

    /**
     * 创建收货地址
     * @param userId 用户ID
     * @param address 收获地址信息
     * @return
     */
    public Integer insertAddress(Long userId, Address address) {
        address.setCreateTime(new Date());
        address.setUserId(userId);
        return addressMapper.insert(address);
    }

    /**
     * 根据用户ID查找收货地址列表
     * @param userId 用户ID
     * @return
     */
    public List<Address> listAddress(Long userId){
        Address address = new Address();
        address.setUserId(userId);

        return addressMapper.selectList(new EntityWrapper<Address>(address));
    }





}
