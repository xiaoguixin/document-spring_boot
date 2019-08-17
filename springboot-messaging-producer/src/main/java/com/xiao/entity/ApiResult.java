package com.xiao.entity;

import lombok.Data;

/**
 *
 * @param <T>
 */
@Data
public class ApiResult<T> {

    private T data;

    private int code;

    private String msg;

    public ApiResult(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
