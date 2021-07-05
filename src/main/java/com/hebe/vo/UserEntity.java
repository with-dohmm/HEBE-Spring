package com.hebe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserEntity {

    private int iuser;
    private String uid;
    private String upw;
    private String unm;
    private String profileImg;
    private String introduction;
}
