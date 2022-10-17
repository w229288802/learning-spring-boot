package com.example.demo.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

@Component
public class RabbitCallback implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("消息发送成功:"+correlationData);
        } else {
            System.out.println("消息发送失败:"+cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("replyCode: " + replyCode);
        System.out.println("replyText: " + replyText);
        System.out.println("exchange: " + exchange);
        System.out.println("routingKey: " + routingKey);
        System.out.println("message: " + message);
    }
}
