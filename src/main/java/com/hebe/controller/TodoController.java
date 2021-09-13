package com.hebe.controller;

import com.hebe.service.TodoService;
import com.hebe.vo.CalendarDTO;
import com.hebe.vo.TodoDTO;
import com.hebe.vo.TodoDTOList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService TodoService;

    // 접속유저의 전체 todolist 조회
    // RequestBody는 post형식으로 json 받을 때 사용
    @PostMapping("/todo")
    public List<TodoDTO> selTodoList(TodoDTO param) {
        List<TodoDTO> list = TodoService.selTodoList(param);
        System.out.println("TodoList select : " + list);
        return list;
    }

    // 접속유저의  날짜별 todolist 조회
    @GetMapping("/todo")
    public List<TodoDTO> dayTodoList(TodoDTO param) {
        List<TodoDTO> list = TodoService.dayTodoList(param);
        System.out.println("day : " + param.getRegdt());
        for(int i = 0; i < list.toArray().length; i++) {
            if (param.getRegdt().equals(list.get(i).getRegdt())) {
                System.out.println("iuser : " + param.getIuser());
                System.out.println(param.getRegdt() + "  :  " + list.get(i));
            } else {
                list.remove(i);
            }
        }
        System.out.println(param.getRegdt() + "[list] : "+ list);
        return list;
    }

    @PostMapping("/todo/regdt")
    public List<CalendarDTO> monthData(CalendarDTO param) {
        System.out.println(param.getMonth());
        return TodoService.monthData(param);
    }

//    @PostMapping("/todo/cal") // 안쓰는ㄷ...듯?
//    public String[] calAllList(TodoDTO param){
//        List<TodoDTO> list = TodoService.calAllList(param);
//        String[] strArr = new String[20];
//        for(int i=0; i < TodoService.calAllList(param).toArray().length; i++){
//            strArr[i] = list.get(i).getRegdt();
//           System.out.println(list.get(i).getRegdt());
//        };
//        return strArr;
//    }

    // 접속유저의 todoList 작성
    @PostMapping("/todo/insert")
    public void insTodoList(@RequestBody TodoDTOList param) {
        System.out.println(param);
        TodoService.insTodoList(param);
    }

    // 접속유저의 todoList 수정
    @PostMapping("/todo/update")
    public void update(@RequestBody TodoDTO param) {
        TodoService.updTodoList(param);
    }

    // 접속유저의 todoList 삭제
    @PostMapping("/todo/delete")
    public void delTodoList(@RequestBody TodoDTOList param) {
        TodoService.delTodoList(param);
    }
}