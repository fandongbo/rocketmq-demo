package com.example.demo;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By fandongbo on 2019-12-24
 */
@RestController
public class DemoController {

    @Autowired
    private DemoProducer demoProducer;

    @GetMapping("/test/sendMQMessage")
    public void sendMQMessagetest()  throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        demoProducer.send();
    }
}
