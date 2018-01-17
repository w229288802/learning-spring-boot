package com.example.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class NewTask {

    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] argv) throws java.io.IOException, Exception {

        /*<dev.rabbitmq.host>172.16.50.150</dev.rabbitmq.host>
        <dev.rabbitmq.port>5672</dev.rabbitmq.port>
        <dev.rabbitmq.username>rabbitmq-dev</dev.rabbitmq.username>
        <dev.rabbitmq.password>ahAZEbEJ#WN0nU5TrAvU4UDGaKN4FAvaNGN8a^NksLGeuxn$xDiyFZcqO8gJDoDsBVBpK3TGHnV*IxMMeeeyuT$U</dev.rabbitmq.password>
        <!-- 开发环境 -->
        <dev.rabbitmq.vhost>msyt-vhost-dev</dev.rabbitmq.vhost>*/

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.50.150");
        factory.setPort(5672);
        factory.setUsername("rabbitmq-dev");
        factory.setPassword("ahAZEbEJ#WN0nU5TrAvU4UDGaKN4FAvaNGN8a^NksLGeuxn$xDiyFZcqO8gJDoDsBVBpK3TGHnV*IxMMeeeyuT$U");
        factory.setVirtualHost("msyt-vhost-dev");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.confirmSelect();
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
//      分发消息
        for(int i = 0 ; i < 5000; i++){
            String message = "Hello World! " + i;
            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}
