package com.springstudy.config;

import com.springstudy.domain.POJO.Receiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;

/**
 * rabbitMq配置类
 */
@Configuration
public class RabbitMQConfig {

    /**
     * 交换机名
     */
    public static final String topicExchangeName = "spring-boot-exchange";

    /**
     * 队列名
     */
    public static final String queueName = "spring-boot";

    /**
     * 队列
     *
     * @return Queue
     */
    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    /**
     * 交换机
     *
     * @return TopicExchange
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    /**
     * 绑定交换机和队列
     *
     * @param queue    queue
     * @param exchange exchange
     * @return Binding
     */
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }
}
