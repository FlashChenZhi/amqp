package top.codeboy.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author AlexChen
 * @version 1.0.1
 * Description: The First RabbitMQ Demo of Java Project
 * @date 2020/1/1 18:09
 */
@Component
public class FanoutReceiver {

    @RabbitListener(queues = "fanout-one")
    public void handler1(String msg){
        System.out.println("handler1->->->"+msg);
    }

    @RabbitListener(queues = "fanout-two")
    public void handler2(String msg){
        System.out.println("handler2->->->"+msg);
    }

}
