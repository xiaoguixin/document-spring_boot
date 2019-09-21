package com.xiao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 自定义业务异常
 * GlobalExceptionHandler自动增加time
 */
@Data
@AllArgsConstructor
public class CustomizeException extends RuntimeException {

    private long code;
    private String msg;
}
