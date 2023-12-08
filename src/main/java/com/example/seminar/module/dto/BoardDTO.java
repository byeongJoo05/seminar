package com.example.seminar.module.dto;

import com.example.seminar.module.domain.Board;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Schema(description = "게시판")
public class BoardDTO {

	@JsonProperty("title")
	@Schema(description = "게시판 타이틀")
	private String title;

	@JsonProperty("content")
	@Schema(description = "게시판 내용")
	private String content;

	@JsonProperty("memberId")
	@Schema(description = "멤버 아이디")
	private String memberId;

	@Builder
	public BoardDTO(String title, String content, String memberId) {
		this.title = title;
		this.content = content;
		this.memberId = memberId;
	}

	public static BoardDTO of (Board board) {
		return BoardDTO.builder()
			.title(board.getTitle())
			.content(board.getContent())
			.memberId(board.getMember().getMemberId())
			.build();
	}
}
