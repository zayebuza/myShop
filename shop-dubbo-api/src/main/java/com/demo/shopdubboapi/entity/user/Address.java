package com.demo.shopdubboapi.entity.user;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by miaodongbiao
 * Date:2018/6/24-12:48
 * Description:
 */
@TableName("os_address")
public class Address implements Serializable {
    /**
     * 收获地址ID
     * s
     */
    @TableId(value="address_id", type= IdType.AUTO)
    private Long addressId;
    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 姓名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 地址标签
     */
    @TableField("user_tag")
    private String userTag;
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
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTag() {
        return userTag;
    }

    public void setUserTag(String userTag) {
        this.userTag = userTag;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
