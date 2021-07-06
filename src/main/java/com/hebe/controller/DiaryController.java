package com.hebe.controller;

import com.hebe.service.DiaryService;
import com.hebe.vo.CardDomain;
import com.hebe.vo.DiaryEntity;
import com.hebe.vo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    // 특정 유저 게시글 조회
    @PostMapping("/diary")
    public List<CardDomain> selUserDiary(UserEntity param) { return diaryService.selUserDiary(param); }

    // 글 작성
    @PostMapping("/write")
    public int writeDiary(DiaryEntity param) { return diaryService.writeDiary(param); }

    // detail 조회
    @PostMapping("/detail")
    public DiaryEntity detailDiary(DiaryEntity param) { return diaryService.detailDiary(param); }
}