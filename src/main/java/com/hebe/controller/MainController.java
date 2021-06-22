package com.hebe.controller;

import com.hebe.service.MainService;
import com.hebe.vo.MainDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private MainService service;

    @RequestMapping("/main/popular")
    public List<MainDomain> selPopularList() {
        return service.selPopularList();
    }

    @RequestMapping("/main/recent")
    public List<MainDomain> selRecentList() {
        return service.selRecentList();
    }
}
