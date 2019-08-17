package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 演示消息队列消费消息
 */
@SpringBootApplication
public class MessagingConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessagingConsumerApplication.class, args);
    }
}
