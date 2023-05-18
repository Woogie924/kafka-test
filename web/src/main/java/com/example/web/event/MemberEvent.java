package com.example.web.event;

import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@ToString
public class MemberEvent extends ApplicationEvent {
    private String message;

    public MemberEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
