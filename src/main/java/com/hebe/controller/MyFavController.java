package com.hebe.controller;

import com.hebe.jwt.model.UserEntity;
import com.hebe.service.MyFavService;
import com.hebe.vo.CardDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyFavController {

    @Autowired
    public MyFavService MyFavService;

    @PostMapping("/myFav")
    public List<CardDomain> getMyFav(UserEntity param) { return MyFavService.getMyFav(param); }
}
