package com.hebe.service;

import com.hebe.mapper.MainMapper;
import com.hebe.vo.MainDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private MainMapper mapper;

    public List<MainDomain> selPopularList() {
        return mapper.selPopularList();
    }

    public List<MainDomain> selRecentList() {
        return mapper.selRecentList();
    }
}
