package com.xiao.controller;

import com.google.gson.GsonBuilder;
import com.xiao.entity.ApiResult;
import com.xiao.entity.MessageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/messaging")
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * kafka消息生产者
     */
    @RequestMapping("/kafka/producer")
    public ApiResult producer(){
        MessageBean<String> msg = new MessageBean<>();
        msg.setData("hello kafka");
        msg.setDate(new Date());
        msg.setUuid(UUID.randomUUID().toString());

        kafkaTemplate.send("kafka-topic",new GsonBuilder().create().toJson(msg));

        return new ApiResult(200,"success", null);
    }
}
