package com.hebe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DiaryEntity {
    private int iboard;
    private String title;
    private String content;
    private int iuser;
    private String regdt;
    private String thumbnail;
}
