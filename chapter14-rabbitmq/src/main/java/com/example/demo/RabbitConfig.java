package com.example.demo;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("task_queue");
    }


    @Bean(name="myListenContainer")
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory aa) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConcurrentConsumers(10);
        factory.setConnectionFactory(aa);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        return factory;
    }


}