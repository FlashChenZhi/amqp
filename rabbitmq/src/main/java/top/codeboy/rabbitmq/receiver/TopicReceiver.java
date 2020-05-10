package top.codeboy.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import sun.plugin2.message.Message;

/**
 * @author AlexChen
 * @version 1.0.1
 * Description: The First RabbitMQ Demo of Java Project
 * @date 2020/1/1 18:30
 */
@Component
public class TopicReceiver {

    @RabbitListener(queues = "xiaomi")
    public void handler1(String msg){
        System.out.println("handler1>>>"+msg);
    }

    @RabbitListener(queues = "huawei")
    public void handler2(String msg){
        System.out.println("handler2<<<"+msg);
    }

    @RabbitListener(queues = "phone")
    public void handler3(String msg){
        System.out.println("handler3<<<>>>"+msg);
    }


}
