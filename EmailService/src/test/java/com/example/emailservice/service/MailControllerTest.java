package com.example.emailservice.service;

import com.example.emailservice.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailControllerTest {

    @Autowired
    private MailService mailService;

    @Test
    public void mailSendTest(){

        String email ="ytw9699@naver.com";
        String title = "test title";
        String body = "test body";
        mailService.send(email, title, body);
    }

}