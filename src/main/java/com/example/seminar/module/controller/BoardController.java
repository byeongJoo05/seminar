package com.example.seminar.module.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.seminar.module.dto.BoardDTO;
import com.example.seminar.module.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/board")
public class BoardController {
	private final BoardService boardService;

	@PostMapping("/upload")
	public ResponseEntity<Map<Object, Object>> uploadBoard(@RequestBody BoardDTO boardDTO) {
		boardService.uploadBoard(boardDTO);

		Map<Object, Object> resultMap = new HashMap<>();
		resultMap.put("code", "200");
		resultMap.put("msg", "ok");
		return ResponseEntity.status(HttpStatus.OK)
			.body(resultMap);
	}

	@GetMapping("/findBoards")
	public ResponseEntity<Map<Object, Object>> uploadBoard() {
		List<BoardDTO> boards = boardService.findBoards();

		Map<Object, Object> resultMap = new HashMap<>();
		resultMap.put("code", "200");
		resultMap.put("msg", "ok");
		resultMap.put("data", boards);
		return ResponseEntity.status(HttpStatus.OK)
			.body(resultMap);
	}
}
