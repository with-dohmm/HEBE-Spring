package com.hebe.jwt.service;

import java.util.UUID;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AmazonSESSample {
    static final String FROM = "hebenote.com@gmail.com";
    static final String SUBJECT = "[HEBE] 이메일 인증 메일입니다.";

    public String setText(String authKey) {
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

    public String createAuth() {
        String uuid = UUID.randomUUID().toString().toUpperCase();
        return uuid.substring(uuid.length() - 6);
    }

    public String sesMail(String username) {
        String authKey = createAuth();
        try {
            AmazonSimpleEmailService client =
                    AmazonSimpleEmailServiceClientBuilder.standard()
                            .withRegion(Regions.AP_NORTHEAST_2).build();
            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(
                            new Destination().withToAddresses(username))
                    .withMessage(new Message()
                            .withBody(new Body()
                                    .withHtml(new Content()
                                            .withCharset("UTF-8").withData(setText(authKey))))
                            .withSubject(new Content()
                                    .withCharset("UTF-8").withData(SUBJECT)))
                    .withSource(FROM);
            client.sendEmail(request);
            System.out.println("Email sent!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authKey;
    }
}