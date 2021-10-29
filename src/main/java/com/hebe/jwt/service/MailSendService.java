package com.hebe.jwt.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MailSendService {

    @Autowired
    final private JavaMailSender mailSender;

    public String createAuth() {
        String uuid = UUID.randomUUID().toString().toUpperCase();
        return uuid.substring(uuid.length() - 6);
    }

    public String mailText(String authKey) {
        return "<h1 style=\"\n" +
                "        display: inline;\n" +
                "        background: #867ec7;\n" +
                "        background: -webkit-linear-gradient(left, #867ec7, #d57272);\n" +
                "        background:    -moz-linear-gradient(right, #867ec7, #d57272);\n" +
                "        background:      -o-linear-gradient(right, #867ec7, #d57272);\n" +
                "        background:         linear-gradient(to right, #867ec7, #d57272);\n" +
                "        -webkit-background-clip: text;\n" +
                "                background-clip: text;\n" +
                "        color: transparent;\n" +
                "    \">\n" +
                "        [HEBE] 이메일 인증 코드\n" +
                "    </h1>\n" +
                "    <br>\n" +
                "    <br>\n" +
                "    <div style=\"\n" +
                "        width: 500px;\n" +
                "        height: 2px;\n" +
                "        background: linear-gradient(to right, #867ec7, #d57272);\n" +
                "    \"></div>\n" +
                "    <br>\n" +
                "    <div style=\"\n" +
                "        color: #333;\n" +
                "    \">하단 인증 코드를 입력란에 입력해 주세요.\n" +
                "    </div>\n" +
                "    <br>\n" +
                "    <h4 style=\"\n" +
                "        display: inline;\n" +
                "        padding: 5px 15px;\n" +
                "        color: #fff;\n" +
                "        background: -webkit-linear-gradient(left, #867ec7, #d57272);\n" +
                "    \">\n" +
                authKey +
                "    </h4>";
    }

    public String sendMail(String username) {
        String authKey = createAuth();

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
            helper.setFrom("hebenote.com@gmail.com");
            helper.setTo(username);
            helper.setSubject("[HEBE] 이메일 인증 메일입니다.");
            helper.setText(mailText(authKey), true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return authKey;
    }
}
