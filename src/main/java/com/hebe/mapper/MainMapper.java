package com.hebe.mapper;

import com.hebe.vo.CardDomain;
import com.hebe.vo.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {

    // 전체 글 인기순 정렬
    List<CardDomain> selPopularList();

    // 전체 글 최신순 정렬
    List<CardDomain> selRecentList();

    // 유저 검색
    UserEntity searchUser(UserEntity param);
}
