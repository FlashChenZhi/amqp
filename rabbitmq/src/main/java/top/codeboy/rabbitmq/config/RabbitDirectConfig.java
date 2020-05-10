package top.codeboy.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author AlexChen
 * @version 1.0.1
 * Description: The First RabbitMQ Demo of Java Project
 * @date 2019/12/28 23:10
 */
@Configuration
public class RabbitDirectConfig {
    public  final static String DIRECTNAME = "codeboy-direct";

    @Bean
    Queue queue(){
       return  new Queue("Hello.CodeBoy");
    }

    @Bean
    DirectExchange directExchange(){
        return new DirectExchange(DIRECTNAME,true,false);
    }

    /**
     * 将DirectExchange和Queue进行绑定
     * @return
     */
    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
}

