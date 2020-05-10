package top.codeboy.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;


/**
 * @author CodeBoy
 * @version 1.0.1
 * Description: The First ActiveMq Demo of Java Project
 * @date 2019/12/24 1:46
 */
@Component
public class JmsComponent {

    @Autowired
    JmsMessagingTemplate jmsMessageTemplate;

    @Autowired
    Queue queue;

    /**
     * 发送消息
     * @param message
     */
    public void send(Message message){
        jmsMessageTemplate.convertAndSend(this.queue,message);
    }

    @JmsListener(destination = "Hello,CodeBoy!")
    public void receive(Message message){
        System.out.println("Message: "+message);
    }

}
