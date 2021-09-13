package com.hebe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoDTO {
    private int iuser;
    private int t_num;
    private String t_text;
    private boolean done;
    private String regdt;
}
