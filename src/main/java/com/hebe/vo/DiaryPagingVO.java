package com.hebe.vo;

import com.hebe.jwt.model.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DiaryPagingVO extends UserEntity {
    private int offsetNum;
}
