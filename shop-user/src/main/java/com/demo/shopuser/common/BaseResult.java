package com.demo.shopuser.common;

import java.io.Serializable;

/**
 * Created by miaodongbiao
 * Date:2018/6/24-15:02
 * Description:
 */

public class BaseResult implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 返回状态码 */
    private Integer code;

    /** 返回信息 */
    private String message;

    /** 返回数据 */
    private Object data;

    public BaseResult(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public BaseResult(Integer code, String message, Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
