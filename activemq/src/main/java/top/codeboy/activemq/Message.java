package top.codeboy.activemq;

import java.io.Serializable;
import java.util.Date;

/**
 * @author AlexChen
 * @version 1.0.1
 * Description: The First ActiveMQ Demo of Java Project
 * @date 2019/12/24 1:53
 */
public class Message implements Serializable {

    private String content;
    private Date sendDate;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                ", sendDate=" + sendDate +
                '}';
    }
}
