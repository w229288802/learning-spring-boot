package com.example.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Worker2 {
    private static final String TASK_QUEUE_NAME = "task_queue";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.50.150");
        factory.setPort(5672);
        factory.setUsername("rabbitmq-dev");
        factory.setPassword("ahAZEbEJ#WN0nU5TrAvU4UDGaKN4FAvaNGN8a^NksLGeuxn$xDiyFZcqO8gJDoDsBVBpK3TGHnV*IxMMeeeyuT$U");
        factory.setVirtualHost("msyt-vhost-dev");
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
        System.out.println("Worker2 [*] Waiting for messages. To exit press CTRL+C");
        // 每次从队列中获取数量
        channel.basicQos(10);
        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + ":Worker2-1 [x] Received '" + message + "'");
                try {
                    doWork(message);
                } finally {
                    System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + "Worker2-1 [x] Done");
                    // 消息处理完成确认
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        final Consumer consumer2 = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + ":Worker2-2 [x] Received '" + message + "'");
                try {
                    doWork(message);
                } finally {
                    System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + "Worker2-2 [x] Done");
                    // 消息处理完成确认
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };
        // 消息消费完成确认
        channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
        channel.basicConsume(TASK_QUEUE_NAME, false, consumer2);
    }

    /**
     * 任务处理
     * 
     * @param task
     *            void
     */
    private static void doWork(String task) {
        try {
            Thread.sleep(3000); // 暂停1秒钟
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
