package com.example.web.api;

import com.example.web.event.MemberEventPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/event")
@RequiredArgsConstructor
public class EventController {

    private final MemberEventPublisher memberEventPublisher;

    @PostMapping(value = "/member")
    public String sendMessage(@RequestParam("name") String name) {
        memberEventPublisher.publish(name);
        return "success";
    }
}
