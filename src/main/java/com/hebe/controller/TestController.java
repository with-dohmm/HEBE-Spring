package com.hebe.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    @PostMapping("/todo")
    public List<ToDoListEntity> selList(HttpServletRequest request) {
        ToDoListEntity item1 = new ToDoListEntity();
        item1.setId(1);
        item1.setTodo("밥먹기");
        item1.setCheck(false);

        ToDoListEntity item2 = new ToDoListEntity();
        item2.setId(2);
        item2.setTodo("청소하기");
        item2.setCheck(false); 

        List<ToDoListEntity> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);

        return list;
    }
}
