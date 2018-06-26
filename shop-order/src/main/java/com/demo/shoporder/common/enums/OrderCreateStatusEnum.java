package com.demo.shoporder.common.enums;

/**
 * Created by miaodongbiao
 * Date:2018/6/26-22:29
 * Description:
 */
public enum OrderCreateStatusEnum {

    MEMBER(0, "会员"),
    ADMINISTRATOR(1, "管理员"),
    EXCEPTION_NOTIFICATION(2, "管理员");

    private Integer status;

    private String stateInfo;

    OrderCreateStatusEnum(Integer status, String stateInfo) {
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
