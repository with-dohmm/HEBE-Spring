package com.hebe.mapper;

import com.hebe.jwt.model.UserEntity;
import com.hebe.vo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiaryMapper {

    // 특정 유저 게시글 조회
    List<CardDomain> selUserDiary(UserEntity param);

    // 글 작성
    int writeDiary(DiaryEntity param);

    // 글쓰기 버튼 클릭 시 임의의 글 생성 (이미지 폴더 담아두기용)
    int preWriteDiary(DiaryEntity param);

    // 가장 최신 글 가져오기
    DiaryEntity getMostRecent();

    // 삭제
    int deleteDiary(DiaryEntity param);

    // detail 조회
    DetailDomain detailDiary(DiaryEntity param);

    // 댓글 리스트 조회
    List<CmtDomain> cmtList(DiaryEntity param);

    // 댓글 작성
    int cmtWrite(CmtEntity param);

    // 댓글 삭제
    int cmtDelete(CmtEntity param);

    // 댓글 수정
    int cmtUpdate(CmtEntity param);

    // 좋아요 추가
    int addFav(DiaryEntity param);

    // 좋아요 취소
    int removeFav(DiaryEntity param);
}
