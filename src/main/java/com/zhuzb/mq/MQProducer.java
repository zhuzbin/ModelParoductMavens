package com.zhuzb.mq;

public interface MQProducer {

    /**
     * 发送消息到指定队列
     */
    public void sendDataToQueue(String queueKey,Object object);
}
