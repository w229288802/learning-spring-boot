package com.example.demo.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.example.demo.Chapter14RabbitmqApplicationTests.*;

@Configuration
public class MqConfig {

    @Autowired
    private CachingConnectionFactory connectionFactory;
    @Autowired
    private RabbitCallback callback;

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setConfirmCallback(callback);
        template.setReturnCallback(callback);
        return template;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = TASK_QUEUE, durable = "true"),
            exchange = @Exchange(value = "direct", durable = "true"),
            key = TASK_QUEUE))
    public void listen(Message message) {
        System.out.println(TASK_QUEUE + "收到消息:" + new String(message.getBody()));
        countDownLatch.countDown();
    }


    @RabbitListener(bindings = @QueueBinding(
            value = @org.springframework.amqp.rabbit.annotation.Queue(value = TASK_QUEUE1, durable = "true"),
            exchange = @Exchange(value = "direct", durable = "true"),
            key = TASK_QUEUE1))
    public void listen2(Message message) {
        System.out.println(TASK_QUEUE1 + "收到消息:" + new String(message.getBody()));
        countDownLatch.countDown();
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @org.springframework.amqp.rabbit.annotation.Queue(value = TASK_QUEUE2, durable = "true"),
            exchange = @Exchange(value = "direct", durable = "true"),
            key = TASK_QUEUE2))
    public void listen3(Message message) throws InterruptedException {
        System.out.println(TASK_QUEUE1 + "收到消息:" + new String(message.getBody()));
        countDownLatch.countDown();
        Thread.sleep(2000);
    }



    // 通过注解自动创建 spring.work.queue 队列
    @RabbitListener(queues = "spring.work.queue")
    public void listen(String msg) {
        System.out.println("work模式 接收到消息：" + msg);
    }

    // 创建两个队列共同消费
    @RabbitListener(queues = "spring.work.queue")
    public void listen2(String msg) {
        System.out.println("work模式二 接收到消息：" + msg);
    }

    @Bean
    public org.springframework.amqp.core.Queue queue(){
        return new org.springframework.amqp.core.Queue("spring.work.queue");
    }

    /*@Bean
    public Queue queue(){
        return new Queue(TASK_QUEUE);
    }

    @Bean
    public Queue queue1(){
        return new Queue(TASK_QUEUE1);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout");
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange)
                .with(TASK_QUEUE1);
    }

    @Bean
    public Binding binding(Queue queue, FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }*/
}
