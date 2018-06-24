package com.demo.shopuser.common;

/**
 * Created by miaodongbiao
 * Date:2018/6/24-22:15
 * Description:
 */
public class OsResult extends BaseResult {
    public OsResult(ReturnCode returnCode) {
        super(returnCode.getCode(), returnCode.getMessage());
    }

    public OsResult(ReturnCode returnCode, Object data) {
        super(returnCode.getCode(), returnCode.getMessage(), data);
    }

    public OsResult(Integer code, String message) {
        super(code, message);
    }
}
