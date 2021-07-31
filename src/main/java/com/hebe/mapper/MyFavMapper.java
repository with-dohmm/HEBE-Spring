package com.hebe.mapper;

import com.hebe.jwt.model.UserEntity;
import com.hebe.vo.CardDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyFavMapper {

    List<CardDomain> getMyFav(UserEntity param);
}
