package com.hebe.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiaryEntity {
    private int iboard;
    private String title;
    private String content;
    private int iuser;
    private String regdt;
    private String thumbnail;
}
