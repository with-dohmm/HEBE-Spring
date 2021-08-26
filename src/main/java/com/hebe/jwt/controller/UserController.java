package com.hebe.jwt.controller;

import com.hebe.jwt.model.UserDTO;
import com.hebe.jwt.model.UserEntity;
import com.hebe.jwt.service.MailSendService;
import com.hebe.jwt.service.UserService;
import com.hebe.jwt.util.CookieUtil;
import com.hebe.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired private UserService userService;
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private CookieUtil cookieUtil;
    @Autowired private MailSendService mailSendService;

    @PostMapping("/joinAuth")
    public String joinAuth(@RequestBody UserDTO param) {
        String authKey = "1";

        System.out.println("username : " + param.getUsername());

        int result = userService.selUsername(param.getUsername());

        System.out.println("username result : " + result);

        if(result == 0) {
            authKey = mailSendService.sendMail(param.getUsername());
            return authKey;
        }
        return authKey;
    }

    @PostMapping("/nickname")
    public int nickname(@RequestBody UserEntity userEntity) {
        System.out.println("nickname : " + userEntity.getNickname());

        int result = userService.selNickname(userEntity.getNickname());

        System.out.println("nickname result : " + result);

        return result;
    }

    @PostMapping("/join")
    public void join(@RequestBody UserEntity userEntity){
        System.out.println(userEntity.getUsername());
        System.out.println(userEntity.getPassword());
        System.out.println(userEntity.getNickname());
        userService.join(userEntity);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO param, HttpServletResponse res) {
        System.out.println("로그인 컨트롤러 진입!");

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(param.getUsername(), param.getPassword()));

        UserEntity userEntity = userService.login(param, res);

        userEntity.setPassword(null);

        System.out.println("로그인 정보 : " + userEntity);

        return ResponseEntity.ok(userEntity);
    }

    @PostMapping("/logout")
    public void logout(HttpServletResponse res) {
        System.out.println("로그아웃 컨트롤러 진입!");

        Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, null);
        accessToken.setMaxAge(0);
        Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, null);
        refreshToken.setMaxAge(0);

        res.addCookie(accessToken);
        res.addCookie(refreshToken);
    }

    @PostMapping("/profileMod")
    public ResponseEntity<?> profileMod(@RequestParam(value="profileimg", required = false) MultipartFile file, String nickname, String introduction, int iuser) {
        UserEntity user = new UserEntity();
        user.setNickname(nickname);
        user.setIntroduction(introduction);
        user.setIuser(iuser);

        if(file != null) {
            String img = userService.fileToString(file, iuser);
            user.setProfileimg(img);
        }

        System.out.println(user);
        userService.profileMod(user);
        user.setPassword("");

        return ResponseEntity.ok(user);
    }
}