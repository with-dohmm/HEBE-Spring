package com.hebe.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "userdb")
public class UserEntity {
    @Id
    @Column(length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int iuser;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 10, unique = true, nullable = false)
    private String nickname;

    @Column(length = 100, nullable = false)
    private String profileimg;

    @Column(length = 100, nullable = false)
    private String introduction;

    @Column(length = 10, nullable = false)
    private String provider;
}
