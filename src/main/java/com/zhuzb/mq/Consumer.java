package com.zhuzb.mq;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer implements MessageListener {

    public void onMessage(Message message) {
        System.out.println("===========mq:开始消费==========");
        System.out.println(new String(message.getBody()));
        System.out.println("===========mq:消费完成==========");
    }
}
