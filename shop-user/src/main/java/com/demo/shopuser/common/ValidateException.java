package com.demo.shopuser.common;

/**
 * Created by miaodongbiao
 * Date:2018/6/24-23:29
 * Description:
 */
public class ValidateException extends  BaseException {
    /** 返回状态码 */
    private Integer code;

    public ValidateException() {
        super();
    }

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(Throwable cause) {
        super(cause);
    }

    public ValidateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ValidateException(ReturnCode returnCode) {
        super(returnCode.getMessage());
        this.code = returnCode.getCode();
    }

    public ValidateException(ReturnCode returnCode, Throwable cause) {
        super(returnCode.getMessage(), cause);
        this.code = returnCode.getCode();
    }

    public ValidateException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
