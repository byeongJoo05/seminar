package com.example.seminar.module.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(name = "member_id", unique = true)
    private String memberId;

    private String pw;

    private String nickname;

    @Builder
    public Member(String memberId, String pw, String nickname) {
        this.memberId = memberId;
        this.pw = pw;
        this.nickname = nickname;
    }
}
