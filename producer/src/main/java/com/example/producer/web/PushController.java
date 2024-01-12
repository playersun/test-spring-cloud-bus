package com.example.producer.web;

import com.example.event.TestRemoteEvent;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/push")
public class PushController {

    @Autowired
    private ApplicationEventPublisher publisher;

    @RequestMapping("/test")
    public String test() {
        publisher.publishEvent(new TestRemoteEvent("source", "producer:8080", "customer"));
        return "success";
    }

}
