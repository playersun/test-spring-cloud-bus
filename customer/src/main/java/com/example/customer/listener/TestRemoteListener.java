package com.example.customer.listener;

import com.example.event.TestRemoteEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class TestRemoteListener implements ApplicationListener<TestRemoteEvent> {
    @Override
    public void onApplicationEvent(TestRemoteEvent event) {
        log.debug("!!!!!!!!!!!!!!!!!!!!!!!");
        log.debug("receive TestRemoteEvent");
        log.debug("!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
