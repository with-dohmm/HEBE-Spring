package com.hebe.mapper;

import com.hebe.vo.MainDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainMapper {
    List<MainDomain> selPopularList();
    List<MainDomain> selRecentList();
}
