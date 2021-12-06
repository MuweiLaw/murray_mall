package com.murray.commons;

import java.io.Serializable;

/**
 * 返回信息包装类
 *
 * @author Murray Law
 * @date 2021/12/3 11:39
 */
public class ResponseInfo<T> implements Serializable {
    public static final String CODE_SUCCESS = "0000";
    public static final String CODE_ERROR = "9999";
    public static final String CODE_ERROR_BUSINESS = "7777";
    public static final String CODE_END = "1111";
    public static final String CODE_SUCCESS_MSG = "成功";
    public static final String CODE_ERROR_MSG = "系统异常，请稍后再试";

    private static final long serialVersionUID = -1684780611444450539L;

    private String code;
    private String msg;
    private T data;

    public ResponseInfo(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseInfo<T> success(T data) {
        return new ResponseInfo("0000", "成功", data);
    }

    public static <T> ResponseInfo<T> success(String msg, T data) {
        return new ResponseInfo("0000", msg, data);
    }

    public static <T> ResponseInfo<T> assertion(T data) {
        return data != null ? success(data) : new ResponseInfo("9404", "数据不存在", data);
    }

    public static <T> ResponseInfo<T> error(String msg) {
        return new ResponseInfo("9999", msg, (Object)null);
    }

    public static <T> ResponseInfo<T> error(String code, String msg, T data) {
        return new ResponseInfo(code, msg, data);
    }

    public boolean isSuccess() {
        return "0000".equals(this.code);
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseInfo() {
    }
}
