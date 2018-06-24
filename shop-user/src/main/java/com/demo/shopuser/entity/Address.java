package com.demo.shopuser.entity;

import java.util.Date;

/**
 * Created by miaodongbiao
 * Date:2018/6/24-12:48
 * Description:
 */
public class Address {
    /**
     * 收获地址ID
     */
    private Long addressId;
    /**
     * 用户ID
     */

    private Long userId;
    /**
     * 姓名
     */

    private String userName;
    /**
     * 地址标签
     */

    private String userTag;
    /**
     * 手机号码
     */

    private String userPhone;
    /**
     * 省份ID
     */

    private Integer provinceId;
    /**
     * 省份名字
     */

    private String provinceName;
    /**
     * 城市ID
     */

    private Integer cityId;
    /**
     * 城市名字
     */

    private String cityName;
    /**
     * 区域ID
     */

    private Integer districtId;
    /**
     * 区域名字
     */

    private String districtName;
    /**
     * 详细地址
     */

    private String userAdress;
    /**
     * 邮政编码
     */

    private Integer userZipcode;
    /**
     * 创建时间
     */

    private Date createTime;
    /**
     * 更新时间
     */

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
