package com.hebe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DetailDomain extends DiaryEntity {
    private String nickname;
    private String introduction;
    private String profileImg;
    private int isFav;
}
