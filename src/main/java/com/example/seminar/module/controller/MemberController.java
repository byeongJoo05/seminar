package com.example.seminar.module.controller;

import com.example.seminar.module.dto.MemberDTO;
import com.example.seminar.module.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/member")
@Tag(name = "Member", description = "회원에 관련된 API 가이드 문서")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    @Operation(summary = "Register Member", description = "가입을 요청한 멤버를 가입시킨다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록성공",
            content = @Content(mediaType = "application/json"))
    })
    public ResponseEntity<Map<Object, Object>> registerMember (
            @RequestBody
            MemberDTO memberDTO) {
        memberService.registerMember(memberDTO);

        Map<Object, Object> resultMap = new HashMap<>();

        resultMap.put("code", "201");
        resultMap.put("msg", "등록성공");

        return ResponseEntity.ok(resultMap);
    }

    @GetMapping("/findMembers")
    @Operation(summary = "Find Members", description = "가입된 멤버들의 목록을 출력한다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "등록성공",
            content = {@Content(schema = @Schema(implementation = MemberDTO.class))})
    })
    public ResponseEntity<Map<Object, Object>> findMembers() {
        List<MemberDTO> members = memberService.findAll();

        Map<Object, Object> resultMap = new HashMap<>();

        resultMap.put("code", "200");
        resultMap.put("msg", "등록성공");
        resultMap.put("data", members);
        return ResponseEntity.ok(resultMap);
    }
}
