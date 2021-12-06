package com.murray.commons.exception;

import com.murray.commons.ResponseInfo;

/**
 * 服务异常
 *
 * @author Murray Law
 * @date 2021/12/3 11:36
 */
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -2178723429138789298L;
    private String message;
    private String code;

    public ServiceException(String message) {
        this("7777", message);
    }

    public ServiceException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }

    public ResponseInfo<Object> getResponse() {
        return !"9999".equals(this.code) ? ResponseInfo.error(this.code + "1111", this.message, (Object)null) : ResponseInfo.error(this.code, this.message, (Object)null);
    }
}