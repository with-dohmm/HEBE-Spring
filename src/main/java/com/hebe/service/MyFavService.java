package com.hebe.service;

import com.hebe.jwt.model.UserEntity;
import com.hebe.mapper.MyFavMapper;
import com.hebe.vo.CardDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyFavService {

    @Autowired
    private MyFavMapper MyFavMapper;

    public List<CardDomain> getMyFav(UserEntity param) { return MyFavMapper.getMyFav(param); }
}
