package com.hebe.mapper;

import com.hebe.vo.CardDomain;
import com.hebe.vo.DiaryEntity;
import com.hebe.vo.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {

    // 특정 유저 게시글 조회
    List<CardDomain> selUserDiary(UserEntity param);

    // 글 작성
    int writeDiary(DiaryEntity param);

    // detail 조회
    DiaryEntity detailDiary(DiaryEntity param);
}
