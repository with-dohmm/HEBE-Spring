package com.hebe.jwt.controller;

import com.hebe.jwt.entity.AuthRequest;
import com.hebe.jwt.util.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/api/user/login")
    public ResponseEntity<AuthRequest> login(@RequestBody AuthRequest param) {
        System.out.println("email : " + param.getEmail() + ", upw : " + param.getUpw());

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(param.getEmail(), param.getUpw()));

        // SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        param.setUpw("");
        param.setToken(jwt);
        return ResponseEntity.ok(param);
    }
}