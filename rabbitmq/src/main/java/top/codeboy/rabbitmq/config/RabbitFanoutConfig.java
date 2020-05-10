package top.codeboy.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author AlexChen
 * @version 1.0.1
 * Description: The First RabbitMQ Demo of Java Project
 * @date 2020/1/1 17:56
 */
@Configuration
public class RabbitFanoutConfig {

    public static final String FANOUTNAME="CodeBoy-Fanout";

    @Bean
    Queue queueOne(){
        return new Queue("fanout-one");
    }

    @Bean
    Queue queueTwo(){
        return new Queue("fanout-two");
    }

    @Bean
    FanoutExchange fanoutExchange(){
        return new FanoutExchange(FANOUTNAME,true,false);
    }

    @Bean
    Binding bindOne(){
        return BindingBuilder.bind(queueOne()).to(fanoutExchange());
    }
    @Bean
    Binding bindTwo(){
        return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
    }


}
