package top.codeboy.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageBuilderSupport;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.codeboy.rabbitmq.config.RabbitFanoutConfig;
import top.codeboy.rabbitmq.config.RabbitHeaderConfig;
import top.codeboy.rabbitmq.config.RabbitTopicConfig;

@SpringBootTest
class RabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        rabbitTemplate.convertAndSend("Hello.CodeBoy","hello,javaboy@hahahaha");
    }

    @Test
    public void fanout(){
        rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUTNAME,null,"Hello,Fanout!!!");
    }

    @Test
    public void topic(){
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"xiaomi.news","小米新闻");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"huawei.phone","华为品牌");
        rabbitTemplate.convertAndSend(RabbitTopicConfig.TOPICNAME,"vivo.phone","Vivo手机");
    }

    @Test
    public void header(){
        //setHeader()方法需要设置属性名称和值，并且与绑定的map对象匹配
        Message nameMsg = MessageBuilder.withBody("Hello,Eveyone!".getBytes()).setHeader("name", "CodeBoy").build();
        Message ageMsg = MessageBuilder.withBody("28 years old...".getBytes()).setHeader("age", "28").build();
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME,null,nameMsg);
        rabbitTemplate.send(RabbitHeaderConfig.HEADERNAME,null,ageMsg);
    }
}
