package com.example.seminar.module.controller;

import com.example.seminar.module.dto.MemberDTO;
import com.example.seminar.module.service.MemberService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<Map<Object, Object>> registerMember (@RequestBody MemberDTO memberDTO) {
        memberService.registerMember(memberDTO);

        Map<Object, Object> resultMap = new HashMap<>();

        resultMap.put("code", "201");
        resultMap.put("msg", "등록성공");

        return ResponseEntity.ok(resultMap);
    }

    @GetMapping("/findMembers")
    public ResponseEntity<Map<Object, Object>> findMembers() {
        List<MemberDTO> members = memberService.findAll();

        Map<Object, Object> resultMap = new HashMap<>();

        resultMap.put("code", "200");
        resultMap.put("msg", "등록성공");
        resultMap.put("data", members);
        return ResponseEntity.ok(resultMap);
    }
}
