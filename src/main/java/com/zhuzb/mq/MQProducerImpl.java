package com.zhuzb.mq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class MQProducerImpl implements MQProducer {
/*    @Autowired
    private AmqpTemplate amqpTemplate;*/

    public void sendDataToQueue(String queueKey, Object object) {
        ApplicationContext app = new FileSystemXmlApplicationContext("classpath:xml/spring-mq.xml");
        AmqpTemplate amqpTemplate = (AmqpTemplate)app.getBean("amqpTemplate");
        for(int i=0;i<10;i++){
            String str = i+""+object;
            //amqpTemplate.convertAndSend(queueKey,i+""+object);
            //amqpTemplate.convertAndSend("topicExchange","test123.qwe",str);
            amqpTemplate.convertAndSend("fanoutExchange","",str);
        }
        //amqpTemplate.convertAndSend(queueKey,object);
        //amqpTemplate.convertAndSend("fanout",null,object);
    }
}
