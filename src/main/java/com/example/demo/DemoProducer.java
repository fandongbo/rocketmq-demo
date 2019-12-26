package com.example.demo;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created By fandongbo on 2019-12-24
 */
@Component
public class DemoProducer {

    private static final Logger logger = LoggerFactory.getLogger(DemoProducer.class);

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    public void send() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        for (int i = 0; i < 50; i++) {
            String msg = "demo msg test: " + i;
            logger.info("---------------开始发送消息[" + i + "]：" + msg);
            Message sendMsg = new Message("DemoTopic","DemoTag",msg.getBytes());
            //默认3秒超时
            SendResult sendResult = defaultMQProducer.send(sendMsg);
            logger.info("---------------消息发送响应信息[" + i + "]：" + sendResult.toString());
            Thread.sleep(1000);
        }
    }
}
