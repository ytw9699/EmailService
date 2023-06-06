package com.example.emailservice.controller;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.emailservice.service.MailService;

@RestController
public class MailController {
    @Autowired
    private MailService mailService;

    @PostMapping("/sendMail")
    public String doSend(String email, String title, String body) {

        Map<String, Object> sendRs = mailService.send(email, title, body);

        System.out.println((String) sendRs.get("msg"));

        return (String) sendRs.get("msg");
    }
}