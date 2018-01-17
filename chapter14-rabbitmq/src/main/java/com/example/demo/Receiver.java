package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@RabbitListener(queues = "task_queue", containerFactory = "myListenContainer")
public class Receiver {

    @RabbitHandler
    public void process(String message) {
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + "Worker1 [x] Received '" + message + "'");
        try {
            doWork(message);
        } finally {
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + "Worker1 [x] Done");
            while (true);
            // 消息处理完成确认
            //channel.basicAck(envelope.getDeliveryTag(), false);
        }
    }

    private static void doWork(String task) {
        try {
            Thread.sleep(3000); // 暂停1秒钟
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        }
    }
}