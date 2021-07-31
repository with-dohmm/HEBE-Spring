package com.hebe.controller;

import com.hebe.jwt.model.UserEntity;
import com.hebe.service.DiaryService;
import com.hebe.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiaryController {

    @Autowired
    private DiaryService DiaryService;

    // 특정 유저 게시글 조회
    @PostMapping("/diary")
    public List<CardDomain> selUserDiary(UserEntity param) { return DiaryService.selUserDiary(param); }

    // 글쓰기 버튼 클릭 시 임의의 글 생성 (이미지 폴더 담아두기용)
    @PostMapping("/preWrite")
    public int preWriteDiary(DiaryEntity param) {
        return DiaryService.preWriteDiary(param);
    }

    // 최신 글 iboard 가져오기
    @PostMapping("/diary/recent")
    public int getRecentIboard() { return DiaryService.getRecentIboard(); }

    // 이미지 업로드
    @PostMapping("/diaryImg")
    public String uploadImage(MultipartFile img, int iboard, int iuser) {
        return DiaryService.uploadImage(img, iboard, iuser); }

    // 글 작성
    @PostMapping("/write")
    public int writeDiary(DiaryEntity param) { return DiaryService.writeDiary(param); }

    // 글 작성 취소
    @PostMapping("/cancel")
    public int cancelDiary(DiaryEntity param) { return DiaryService.cancelDiary(param); }

    // detail 조회
    @PostMapping("/detail")
    public DetailDomain detailDiary(DiaryEntity param) { return DiaryService.detailDiary(param); }

    // 글 삭제
    @PostMapping("/delete")
    public int deleteDiary(DiaryEntity param) { return DiaryService.deleteDiary(param); }

    // 댓글 리스트 조회
    @PostMapping("/cmt/list")
    public List<CmtDomain> cmtList(DiaryEntity param) { return DiaryService.cmtList(param); }

    // 댓글 작성
    @PostMapping("/cmt/write")
    public int cmtWrite(CmtEntity param) { return DiaryService.cmtWrite(param); }

    // 댓글 삭제
    @PostMapping("/cmt/delete")
    public int cmtDelete(CmtEntity param) { return DiaryService.cmtDelete(param); }

    // 댓글 수정
    @PostMapping("/cmt/update")
    public int cmtUpdate(CmtEntity param) { return DiaryService.cmtUpdate(param); }

    // 좋아요
    @PostMapping("/fav")
    public int handleFav(DiaryEntity param) { return DiaryService.handleCmt(param); }
}
