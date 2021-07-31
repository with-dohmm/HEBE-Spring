package com.hebe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CmtEntity {
    private int icmt;
    private String comment;
    private int iboard;
    private int iuser;
    private String regdt;
}
