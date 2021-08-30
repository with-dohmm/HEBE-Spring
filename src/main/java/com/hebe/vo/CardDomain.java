package com.hebe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CardDomain extends DiaryEntity {
    private int favCnt;
    private String nickname;
    private String username;
    private String profileimg;
    private String introduction;
}
