package com.hebe.service;

import com.hebe.mapper.DiaryMapper;
import com.hebe.vo.CardDomain;
import com.hebe.vo.DiaryEntity;
import com.hebe.vo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryService {

    @Autowired
    private DiaryMapper DiaryMapper;

    // 특정 유저 게시글 조회
    public List<CardDomain> selUserDiary(UserEntity param) { return DiaryMapper.selUserDiary(param); }

    // 글 작성
    public int writeDiary(DiaryEntity param) { return DiaryMapper.writeDiary(param); }

    // detail 조회
    public DiaryEntity detailDiary(DiaryEntity param) { return DiaryMapper.detailDiary(param); }
}
