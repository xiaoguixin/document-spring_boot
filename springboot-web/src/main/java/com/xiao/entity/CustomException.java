package com.xiao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自定义异常处理
 */
@Data
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private long code;
    private String msg;
}
