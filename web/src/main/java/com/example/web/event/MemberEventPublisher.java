package com.example.web.event;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(final String name) {
        System.out.println("Publish event. "+name);
        MemberEvent memberSpringEvent = new MemberEvent(this, name);
        applicationEventPublisher.publishEvent(memberSpringEvent);
    }
}
