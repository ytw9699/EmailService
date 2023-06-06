package com.example.emailservice.service;

import java.util.HashMap;
import java.util.Map;

import com.example.emailservice.handler.MailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender sender;

    public Map<String, Object> send(String email, String title, String body) {

        MailHandler mail;

        try {

            mail = new MailHandler(sender);
            mail.setFrom("no-reply@norepy.com", "발신자 이름");//의미없음 프로퍼티스 값으로 대체됨
            mail.setTo(email);
            mail.setSubject(title);
            mail.setText(body);
            mail.send();

        } catch (Exception e) {
            e.printStackTrace();
        }

        String resultCode = "S-1";
        String msg = "메일이 발송되었습니다.";

        Map<String, Object> result = new HashMap<>();
        result.put("resultCode", resultCode);
        result.put("msg", msg);

        return result;
    }
}