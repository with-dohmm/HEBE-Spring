package com.hebe.jwt.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int selUsername(String username);
    int selNickname(String nickname);
}