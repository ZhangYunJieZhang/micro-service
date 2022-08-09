package com.zyj.alldemo.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestObserver {

    @Autowired
    MsgSubject msgSubject;

    @GetMapping("/send")
    public String sendMsg(){
        msgSubject.notifyAllObserver();
        return "success";
    }
}
