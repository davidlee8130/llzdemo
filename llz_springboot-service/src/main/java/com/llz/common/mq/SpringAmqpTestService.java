package com.llz.common.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SpringAmqpTestService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void testSimpleQueue() {
        //队列名, 传输的数据
        log.info("传输mq消息");
        rabbitTemplate.convertAndSend("test1.simpleQueue","哈哈哈!");
    }
}
