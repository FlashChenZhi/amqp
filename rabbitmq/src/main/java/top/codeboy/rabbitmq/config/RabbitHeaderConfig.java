package top.codeboy.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AlexChen
 * @version 1.0.1
 * Description: The First RabbitMQ Demo of Java Project
 * @date 2020/1/1 18:51
 */
@Configuration
public class RabbitHeaderConfig {

    public static final String HEADERNAME="CodeBoy-Header";

    @Bean
    HeadersExchange headersExchange(){
        return new HeadersExchange(HEADERNAME,true,false);
    }

    @Bean
    Queue queueName(){
        return new Queue("name-queue");
    }

    @Bean
    Queue queueAge(){
        return new Queue("age-queue");
    }

    @Bean
    Binding bindingName(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","CodeBoy");
        //whereAny表示：只要匹配一个即可 (whereAll则表示需要匹配所有)
        return BindingBuilder.bind(queueName()).to(headersExchange()).whereAny(map).match();
    }

    @Bean
    Binding bindingAge(){
//        Map<String,Object> map = new HashMap<>();
//        map.put("age","28");
        //exists表示：存在这个字段值即可
        return BindingBuilder.bind(queueAge()).to(headersExchange()).where("age").exists();
    }

}
