package com.demo.shoporder.common.enums;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/26 18:51
 * 4  订单状态枚举表述常用数据字段
 */
public enum OrderStatusEnum {


    SUBMIT_ORDERS(1, "订单提交"),
    PAY_TO_COMPLETE(2, "支付完成"),
    PICKING(3, "拣取配货"),
    OUTBOUND_GOODS(4, "商品出库"),
    WAITS_FOR_DELIVERY(5,"等待收货"),
    TAKE_DELIVERY(6, "确认收货"),

    AUTOMATICALLY_CANCEL_THE_ORDER(11, "自动取消订单"),
    MANUALLY_CANCEL_THE_ORDER(12, "手动取消订单");


    private Integer status;

    private String stateInfo;

    OrderStatusEnum(Integer status, String stateInfo) {
        this.status = status;
        this.stateInfo = stateInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
