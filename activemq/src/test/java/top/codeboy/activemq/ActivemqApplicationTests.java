package top.codeboy.activemq;

import org.junit.jupiter.api.Test;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsMessagingTemplate;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @author CodeBoy
 * @version 1.0.1
 * Description: The First ActiveMq Demo of Java Project
 * @date 2019/12/24 23:46
 */

@SpringBootTest
class ActivemqApplicationTests {

    @Autowired
    JmsComponent jmsComponent;

    @Test
    void contextLoads() {
        Message message = new Message();
        message.setContent("Perfect");
        message.setSendDate(new Date());
        jmsComponent.send(message);

    }

}
