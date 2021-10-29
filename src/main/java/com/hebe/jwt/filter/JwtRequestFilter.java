package com.hebe.jwt.filter;

import com.hebe.jwt.model.UserEntity;
import com.hebe.jwt.service.PrincipalDetailService;
import com.hebe.jwt.util.CookieUtil;
import com.hebe.jwt.util.JwtUtil;
import com.hebe.jwt.util.RedisUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired private PrincipalDetailService userDetailsService;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private CookieUtil cookieUtil;
    @Autowired private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        final Cookie jwtToken = cookieUtil.getCookie(httpServletRequest, JwtUtil.ACCESS_TOKEN_NAME);
        String username = null;
        String jwt = null;
        String reJwt = null;
        String reUname = null;

        try {
            if(jwtToken != null){
                jwt = jwtToken.getValue();
                username = jwtUtil.getUsername(jwt);
            }
            if(username != null){
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if(jwtUtil.validateToken(jwt,userDetails)){
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        } catch (ExpiredJwtException e){
            Cookie refreshToken = cookieUtil.getCookie(httpServletRequest,JwtUtil.REFRESH_TOKEN_NAME);
            if(refreshToken != null){
                reJwt = refreshToken.getValue();
            }
        }

        try {
            if(reJwt != null){
                reUname = redisUtil.getData(reJwt);
                if(reUname.equals(jwtUtil.getUsername(reJwt))){
                    UserDetails userDetails = userDetailsService.loadUserByUsername(reUname);
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUsername(reUname);
                    String newToken =jwtUtil.generateToken(userEntity);
                    Cookie newAccessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME, newToken);
                    httpServletResponse.addCookie(newAccessToken);
                }
            }
        } catch (ExpiredJwtException e){
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername(reUname);
            String refreshJwt = jwtUtil.generateRefreshToken(userEntity);
            Cookie newReToken = cookieUtil.createCookie(JwtUtil.REFRESH_TOKEN_NAME, refreshJwt);
            httpServletResponse.addCookie(newReToken);
            redisUtil.setDataExpire(refreshJwt, userEntity.getUsername(), JwtUtil.REFRESH_TOKEN_VALIDATION_SECOND);
        } catch (Exception e) {
            e.printStackTrace();
        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}