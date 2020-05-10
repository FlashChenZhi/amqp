package top.codeboy.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author AlexChen
 * @version 1.0.1
 * Description: The First RabbitMQ Demo of Java Project
 * @date 2020/1/1 18:24
 */
@Configuration
public class RabbitTopicConfig {

    public static final String TOPICNAME="AlexChen";

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(TOPICNAME,true,false);
    }

    @Bean
    Queue xiaomi(){
        return new Queue("xiaomi");
    }

    @Bean
    Queue huawei(){
        return new Queue("huawei");
    }

    @Bean
    Queue phone(){
        return new Queue("phone");
    }

    @Bean
    Binding xiaomiBinding(){
        return BindingBuilder.bind(xiaomi()).to(topicExchange()).with("xiaomi.#");
    }

    @Bean
    Binding huaweiBinding(){
        return BindingBuilder.bind(huawei()).to(topicExchange()).with("huawei.#");
    }

    @Bean
    Binding phoneBinding(){
        return BindingBuilder.bind(phone()).to(topicExchange()).with("#.phone.#");
    }

}
