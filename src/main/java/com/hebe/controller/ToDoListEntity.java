package com.hebe.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.SecondaryTable;

@Getter
@Setter
@ToString
public class ToDoListEntity {

    private int id;
    private String todo;
    private boolean check;
}
