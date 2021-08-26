package com.hebe.jwt.controller;

import com.hebe.jwt.model.UserEntity;
import com.hebe.jwt.service.OauthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/oauth")
public class OauthController {
    @Autowired private OauthService oauthService;

    @PostMapping(value = "/google")
    public ResponseEntity<?> google(@RequestBody UserEntity param, HttpServletResponse res) {
        System.out.println("google controller");

        UserEntity user = oauthService.googleLogin(param, res);

        user.setPassword(null);

        System.out.println("user info : " + user);

        return ResponseEntity.ok(user);
    }

    @PostMapping(value = "/kakao")
    public void kakao() {
        System.out.println("kakao controller");
    }
}