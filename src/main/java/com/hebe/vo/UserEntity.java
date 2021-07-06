package com.hebe.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userdb") // 맵핑할 테이블 지정
public class UserEntity {
    @Id
    private int iuser;
    private String email;
    private String upw;
    private String unm;
    private String profile;
    private String Introduction;
}
