package com.example.web.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MemberEventListener implements ApplicationListener<MemberEvent> {

    @Override
    public void onApplicationEvent(MemberEvent event) {
        System.out.println(String.format("Received Spring Member Event.. %s", event));
    }

}
