package com.hebe.jwt.service;

import com.hebe.jwt.auth.PrincipalDetails;
import com.hebe.jwt.model.UserEntity;
import com.hebe.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// login 요청이 올 때 실행
@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("PrincipalDetailService의 loadUserByUsername 실행");
        UserEntity userEntity = userRepository.findByUsername(username);
        System.out.println("userEntity : " + userEntity);
        return new PrincipalDetails(userEntity);
    }
}