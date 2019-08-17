package com.xiao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息发送实体
 * @param <T>
 */
@Data
public class MessageBean<T> implements Serializable {

    private T data;

    private Date date;

    private String uuid;
}
