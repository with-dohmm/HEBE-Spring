package com.hebe.service;

import com.hebe.imgUpload.UploadImageS3;
import com.hebe.jwt.model.UserEntity;
import com.hebe.mapper.DiaryMapper;
import com.hebe.vo.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class DiaryService {

    @Autowired
    private DiaryMapper DiaryMapper;

    @Autowired
    private UploadImageS3 UploadImageS3;

    // 특정 유저 게시글 조회
    public List<CardDomain> selUserDiary(UserEntity param) { return DiaryMapper.selUserDiary(param); }

    // 특정 유저 게시글 조회 (페이징)
    public List<CardDomain> selUserDiaryPaging(UserEntity param) { return DiaryMapper.selUserDiaryPaging(param); }

    // 검색한 유저 정보 가져오기
    public UserEntity selUserInfo(UserEntity param) { return DiaryMapper.selUserInfo(param); }

    // 최신 글 iboard 가져오기
    public int getRecentIboard() { return DiaryMapper.getMostRecent().getIboard(); }

    // 글 작성
    public int writeDiary(DiaryEntity param) { return DiaryMapper.writeDiary(param); }

    // 글 수정
    public int updateDiary(DiaryEntity param) { return DiaryMapper.updateDiary(param); }

    // 글 작성 취소
    public int cancelDiary(DiaryEntity param) {
        String dirPath = "img/" + param.getIuser() + "/" + param.getIboard();
        // 작성 취소 시 업로드한 이미지 삭제시키기

        return DiaryMapper.deleteDiary(param);
    }

    // detail 조회
    public DetailDomain detailDiary(DiaryEntity param) { return DiaryMapper.detailDiary(param); }

    // 글 삭제
    public int deleteDiary(DiaryEntity param) {
        return DiaryMapper.deleteDiary(param);
    }

    // 댓글 리스트 조회
    public List<CmtDomain> cmtList(DiaryEntity param) { return DiaryMapper.cmtList(param); }

    // 댓글 작성
    public int cmtWrite(CmtEntity param) { return DiaryMapper.cmtWrite(param); }

    // 댓글 삭제
    public int cmtDelete(CmtEntity param) { return DiaryMapper.cmtDelete(param); }

    // 댓글 수정
    public int cmtUpdate(CmtEntity param) { return DiaryMapper.cmtUpdate(param); }

    // 좋아요
    public int handleCmt(DiaryEntity param) {
        int isFav = DiaryMapper.detailDiary(param).getIsFav();
        if (isFav == 0) {
            DiaryMapper.addFav(param);
            isFav = 1;
        } else if (isFav == 1) {
            DiaryMapper.removeFav(param);
            isFav = 0;
        }
        return isFav;
    }
}
