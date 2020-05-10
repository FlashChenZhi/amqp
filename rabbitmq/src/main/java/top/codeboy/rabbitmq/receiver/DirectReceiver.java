package top.codeboy.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author AlexChen
 * @version 1.0.1
 * Description: The First RabbitMQ Demo of Java Project
 * @date 2019/12/28 23:19
 */
@Component
public class DirectReceiver {
    @RabbitListener(queues = "Hello.CodeBoy")
    public void handler(String msg){
        System.out.println("handler>>>"+msg);
    }
}
