package com.example.seminar.module.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "멤버")
public class MemberDTO {

    @JsonProperty("memberId")
    @Schema(description = "멤버 아이디")
    private String memberId;

    @JsonProperty("pw")
    @Schema(description = "멤버 비밀번호")
    @JsonIgnore
    private String pw;

    @JsonProperty("nickname")
    @Schema(description = "별명")
    private String nickname;

    @Builder
    public MemberDTO(String memberId, String nickname) {
        this.memberId = memberId;
        this.nickname = nickname;
    }
}
