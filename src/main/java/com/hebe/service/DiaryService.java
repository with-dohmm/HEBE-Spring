package com.hebe.service;

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

    // 특정 유저 게시글 조회
    public List<CardDomain> selUserDiary(UserEntity param) { return DiaryMapper.selUserDiary(param); }

    // 특정 유저 게시글 조회 (페이징)
    public List<CardDomain> selUserDiaryPaging(UserEntity param) { return DiaryMapper.selUserDiaryPaging(param); }

    // 검색한 유저 정보 가져오기
    public UserEntity selUserInfo(UserEntity param) { return DiaryMapper.selUserInfo(param); }

    // 글쓰기 버튼 클릭 시 임의의 글 생성 (이미지 폴더 담아두기용)
    public int preWriteDiary(DiaryEntity param) {
        // 임의의 글 생성, 결과 담아둠
        int result = DiaryMapper.preWriteDiary(param);
        System.out.println("result : " + result);

        // 유저 - iboard 이미지 폴더 생성
        int recentIboard = DiaryMapper.getMostRecent().getIboard();

        final String PATH = "C:/Users/82109/Desktop/project/hebe-react/public/img/" + param.getIuser() + "/" + recentIboard;
        File folder = new File(PATH);
        folder.mkdirs();

        return result;
    }

    // 최신 글 iboard 가져오기
    public int getRecentIboard() { return DiaryMapper.getMostRecent().getIboard(); }

    // 이미지 업로드 - 글쓰기 (write)
    public String uploadImage(MultipartFile img, int iboard, int iuser) {
        String ext = FilenameUtils.getExtension(img.getOriginalFilename());
        String fileNm = UUID.randomUUID().toString() + "." + ext;

        int temp = iboard;  // 기존 글에 새로 이미지를 추가할 경우 => 기존 폴더(iboard)에 추가
        if (iboard == 0) {  // 수정이 아닌 새로 글 작성할 경우
            temp = DiaryMapper.getMostRecent().getIboard();
        }

        // 나중에 로그인, 회원가입 완성하면 1 대신에 유저 토큰으로 iuser 값을 가지고 와야 함
        File target = new File("C:/Users/82109/Desktop/project/hebe-react/public/img/" + iuser + "/" + temp + "/" + fileNm);
        try { img.transferTo(target); } catch (Exception e) { e.printStackTrace(); }

        return fileNm;
    }

    // 글 작성
    public int writeDiary(DiaryEntity param) { return DiaryMapper.writeDiary(param); }

    // 글 작성 취소
    public int cancelDiary(DiaryEntity param) {
        File target = new File("C:/Users/82109/Desktop/project/hebe-react/public/img/" + param.getIuser() + "/" + param.getIboard());
        if (target.exists()) {
            File[] imgList = target.listFiles();
            for (int i = 0; i< imgList.length; i++) {
                imgList[i].delete();
            }
            if (target.delete()) {
                System.out.println("폴더 삭제 성공");
            } else {
                System.out.println("폴더 삭제 실패");
            }
        } else {
            System.out.println("폴더가 존재하지 않습니다.");
        }

        return DiaryMapper.deleteDiary(param);
    }

    // detail 조회
    public DetailDomain detailDiary(DiaryEntity param) { return DiaryMapper.detailDiary(param); }

    // 글 삭제
    public int deleteDiary(DiaryEntity param) { return DiaryMapper.deleteDiary(param); }

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
