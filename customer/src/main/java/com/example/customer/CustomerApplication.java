package com.example.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.*;

import java.util.HashSet;
import java.util.Set;


@Slf4j
@SpringBootApplication
@RemoteApplicationEventScan({"com.example.event"})
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean("com.alibaba.cloud.stream.binder.rocketmq.convert.RocketMQMessageConverter")
    @ConditionalOnClass(name = {"com.alibaba.cloud.bus.rocketmq.autoconfigurate.RocketMQBusAutoConfiguration"})
    public CompositeMessageConverter rocketMqMessageConvert() {
        Set<MessageConverter> messageConverters = new HashSet();
        ByteArrayMessageConverter byteArrayMessageConverter = new ByteArrayMessageConverter();
        byteArrayMessageConverter.setContentTypeResolver((ContentTypeResolver)null);
        messageConverters.add(byteArrayMessageConverter);
        messageConverters.add(new StringMessageConverter());
        return new CompositeMessageConverter(messageConverters);
    }
}
