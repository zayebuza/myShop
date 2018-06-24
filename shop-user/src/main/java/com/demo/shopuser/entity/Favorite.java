package com.demo.shopuser.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by miaodongbiao
 * Date:2018/6/24-12:56
 * Description:收藏夹
 */
public class Favorite {
    /**
     * 收藏表ID
     */

    private Long favoriteId;
    /**
     * 用户ID
     */

    private Long userId;
    /**
     * 商品ID
     */

    private Long productId;
    /**
     * 商品编号
     */

    private Long productNumber;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 展示图片
     */

    private String picImg;
    /**
     * 显示价格
     */

    private BigDecimal showPrice;
    /**
     * 商品状态：1,上架；2,下架
     */
    private Integer status;
    /**
     * 创建时间
     */

    private Date createTime;
    /**
     * 创建者
     */

    private String createBy;

    public Long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(Long productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg;
    }

    public BigDecimal getShowPrice() {
        return showPrice;
    }

    public void setShowPrice(BigDecimal showPrice) {
        this.showPrice = showPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
}
