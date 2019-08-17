package com.xiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 演示消息队列
 */
@SpringBootApplication
public class MessagingProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessagingProducerApplication.class, args);
    }
}
