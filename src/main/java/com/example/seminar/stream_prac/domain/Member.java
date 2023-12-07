package com.example.seminar.stream_prac.domain;

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
