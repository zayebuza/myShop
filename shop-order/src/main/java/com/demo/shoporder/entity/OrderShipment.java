package com.demo.shoporder.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/26 17:33
 * 4
 */
@TableName("os_order_shipment")
public class OrderShipment extends Model<OrderShipment> {

    private static final long serialVersionUID = 1L;

    /**
     * 配送ID
     */
    @TableId(value="order_shipment_id", type= IdType.AUTO)
    private Long orderShipmentId;
    /**
     * 订单ID
     */
    @TableField("order_id")
    private Long orderId;
    /**
     * 姓名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 手机号码
     */
    @TableField("user_phone")
    private String userPhone;
    /**
     * 省份ID
     */
    @TableField("province_id")
    private Integer provinceId;
    /**
     * 省份名字
     */
    @TableField("province_name")
    private String provinceName;
    /**
     * 城市ID
     */
    @TableField("city_id")
    private Integer cityId;
    /**
     * 城市名字
     */
    @TableField("city_name")
    private String cityName;
    /**
     * 区域ID
     */
    @TableField("district_id")
    private Integer districtId;
    /**
     * 区域名字
     */
    @TableField("district_name")
    private String districtName;
    /**
     * 详细地址
     */
    @TableField("user_adress")
    private String userAdress;
    /**
     * 邮政编码
     */
    @TableField("user_zipcode")
    private Integer userZipcode;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;


    public Long getOrderShipmentId() {
        return orderShipmentId;
    }

    public void setOrderShipmentId(Long orderShipmentId) {
        this.orderShipmentId = orderShipmentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public Integer getUserZipcode() {
        return userZipcode;
    }

    public void setUserZipcode(Integer userZipcode) {
        this.userZipcode = userZipcode;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.orderShipmentId;
    }

}
