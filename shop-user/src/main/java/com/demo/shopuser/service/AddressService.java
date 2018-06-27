package com.demo.shopuser.service;

import com.baomidou.mybatisplus.service.IService;
import com.demo.shopuser.entity.Address;

import java.util.List;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/27 17:35
 * 4
 */
public interface AddressService extends IService<Address> {


    /**
     * 创建收货地址
     * @param userId 用户ID
     * @param address 收获地址信息
     * @return
     */
    public Integer insertAddress(Long userId, Address address);

    /**
     * 根据用户ID查找收货地址列表
     * @param userId 用户ID
     * @return
     */
    public List<Address> listAddress(Long userId);

    /**
     * 根据用户ID和收货地址ID查找收货地址信息
     * @param addressId 收货地址ID
     * @param userId 用户ID
     * @return
     */
    Address getAddress(Long addressId, Long userId);


}
