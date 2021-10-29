package com.hebe.mapper;

import com.hebe.vo.CalendarDTO;
import com.hebe.vo.TodoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    // 접속유저의 전체 todolist 조회
    List<TodoDTO> selTodoList(TodoDTO param);

    // 접속유저의  날짜별 todolist 조회
    List<TodoDTO> dayTodoList(TodoDTO param);

    List<CalendarDTO> monthData(CalendarDTO param);

    List<TodoDTO> calAllList(TodoDTO param);

    // 접속유저의 todoList 작성
    void insTodoList(TodoDTO param);

    // 접속유저의 todoList 수정
    void updTodoList(TodoDTO param);

    // 접속유저의 todoList 삭제
    void delTodoList(TodoDTO param);

}