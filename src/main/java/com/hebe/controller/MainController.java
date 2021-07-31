package com.hebe.controller;

import com.hebe.jwt.model.UserEntity;
import com.hebe.service.MainService;
import com.hebe.vo.CardDomain;
import com.hebe.vo.MainDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private MainService MainService;

    // 전체 글 인기순 정렬
    @PostMapping("/main/popular")
    public List<CardDomain> selPopularList() { return MainService.selPopularList(); }

    // 전체 글 최신순 정렬
    @PostMapping("/main/recent")
    public List<CardDomain> selRecentList() {
        return MainService.selRecentList();
    }

    // 유저 검색
//    @PostMapping("/search")
//    public UserEntity searchUser(UserEntity param) { return MainService.searchUser(param); }

    // 유저 검색(리스트)
    @PostMapping("/search")
    public List<UserEntity> searchUserList(UserEntity param) {
        return MainService.searchUserList(param);
    }
}
