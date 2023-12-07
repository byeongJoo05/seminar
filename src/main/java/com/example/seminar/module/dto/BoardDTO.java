package com.example.seminar.module.dto;

import com.example.seminar.module.domain.Board;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDTO {

	@JsonProperty("title")
	private String title;

	@JsonProperty("content")
	private String content;

	@JsonProperty("memberId")
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
