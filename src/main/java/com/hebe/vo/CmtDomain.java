package com.hebe.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CmtDomain extends CmtEntity {
    private String profileimg;
    private String nickname;
    private String introduction;
}
