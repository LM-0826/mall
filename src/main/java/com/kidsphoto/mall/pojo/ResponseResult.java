package com.kidsphoto.mall.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * @author 李明
 * @create 2019-11-08 13:49
 */
@JsonSerialize
@lombok.Data
public class ResponseResult implements Serializable {

    private static final long serialVersionUID = 5130528303254995228L;

    private Integer code;

    private String message;

    private String version;

    private Object data;

    public ResponseResult(Integer code, Object data, String message, String version) {
        super();
        this.code = code;
        this.data = data;
        this.message = message;
        this.version = version;
    }

    public ResponseResult(Integer code, String message, Object data) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static ResponseResult ok(Integer code, Object data, String message, String version) {
        return new ResponseResult(code,data,message,version);
    }

    public static ResponseResult ok() {
        return new ResponseResult(0, "请求成功",null);
    }

    public static ResponseResult ok(Object data) {
        return new ResponseResult(0, "请求成功！", data);
    }

    public static ResponseResult fail() {
        return new ResponseResult(-1, "请求失败！", null);
    }

    public static ResponseResult fail(String message) {
        return new ResponseResult(-1, message, null);
    }

    public static ResponseResult build(Integer code, String message) {
        return new ResponseResult(code, message, null);
    }

    public static ResponseResult build(Integer code, String message, Object data) {
        return new ResponseResult(code, message, data);
    }


}
