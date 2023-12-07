package com.example.seminar.stream_prac.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {

    @JsonProperty("memberId")
    private String memberId;

    @JsonProperty("pw")
    @JsonIgnore
    private String pw;

    @JsonProperty("nickname")
    private String nickname;

    @Builder
    public MemberDTO(String memberId, String nickname) {
        this.memberId = memberId;
        this.nickname = nickname;
    }
}
