package top.codeboy.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author AlexChen
 * @version 1.0.1
 * Description: The First RabbitMQ Demo of Java Project
 * @date 2020/1/1 19:00
 */
@Component
public class HeaderReceiver {

    @RabbitListener(queues = "name-queue")
    public void nameHandler(byte[] msg){
        System.out.println("nameHandler>>>"+new String(msg,0,msg.length));
    }

    @RabbitListener(queues = "age-queue")
    public void ageHandler(byte[] msg){
        System.out.println("ageHandler>>>"+new String(msg,0,msg.length));
    }
}
