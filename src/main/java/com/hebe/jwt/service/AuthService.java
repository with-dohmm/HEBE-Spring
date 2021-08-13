package com.hebe.jwt.service;

import com.hebe.jwt.mapper.UserMapper;
import com.hebe.jwt.model.UserDTO;
import com.hebe.jwt.model.UserEntity;
import com.hebe.jwt.repository.UserRepository;
import com.hebe.jwt.util.CookieUtil;
import com.hebe.jwt.util.JwtUtil;
import com.hebe.jwt.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CookieUtil cookieUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public int selUsername(String username) {
        int result = userMapper.selUsername(username);
        return result;
    }

    public int selNickname(String nickname) {
        int result = userMapper.selNickname(nickname);
        return result;
    }

    public void join(UserEntity user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setProfileimg("/img/common/basic_profile.png");
        user.setIntroduction("한 줄 소개");
        userRepository.save(user);
    }

    public UserEntity login(UserDTO user, HttpServletResponse res) {
        System.out.println("AuthService 진입!");

        UserEntity userEntity = userRepository.findByUsername(user.getUsername());

        String token = jwtUtil.generateToken(userEntity);

        String refreshJwt = jwtUtil.generateRefreshToken(userEntity);

        Cookie accessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, token);

        Cookie refreshToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);

        redisUtil.setDataExpire(refreshJwt, user.getUsername(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);

        res.addCookie(accessToken);
        res.addCookie(refreshToken);

        return userEntity;
    }
}