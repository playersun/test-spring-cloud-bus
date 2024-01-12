package com.example.event;

import org.springframework.cloud.bus.event.RemoteApplicationEvent;

import java.io.Serial;


public class TestRemoteEvent extends RemoteApplicationEvent {
    @Serial
    private static final long serialVersionUID = 3942646985735881918L;

    public TestRemoteEvent() {
    }

    public TestRemoteEvent(Object source, String originService, String destinationService) {
        super(source, originService, DEFAULT_DESTINATION_FACTORY.getDestination(destinationService));
    }
}
