package com.example.seminar.module.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.seminar.module.domain.Board;
import com.example.seminar.module.dto.BoardDTO;
import com.example.seminar.module.repository.BoardRepository;
import com.example.seminar.module.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	private final MemberRepository memberRepository;
	@Transactional
	public void uploadBoard (BoardDTO boardDTO) {
		Board board = Board.builder()
			.title(boardDTO.getTitle())
			.content(boardDTO.getContent())
			.member(memberRepository.findMemberByMemberId(boardDTO.getMemberId()))
			.build();

		boardRepository.save(board);
	}

	@Transactional(readOnly = true)
	public List<BoardDTO> findBoards() {
		List<Board> all = boardRepository.findAll();

		return all.stream()
			.map(BoardDTO::of)
			.toList();
	}
}
