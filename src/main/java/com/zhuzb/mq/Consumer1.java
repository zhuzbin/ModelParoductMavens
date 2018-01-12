package com.zhuzb.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class Consumer1 implements MessageListener  {
    public void onMessage(Message message){
        System.out.println("==========第二个mq:开始消费========");
        System.out.println(new String(message.getBody()));
        System.out.println("==========第二个mq:消费完毕========");
    }
}
