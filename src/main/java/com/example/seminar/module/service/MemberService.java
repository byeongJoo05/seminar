package com.example.seminar.module.service;

import com.example.seminar.module.domain.Member;
import com.example.seminar.module.dto.MemberDTO;
import com.example.seminar.module.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void registerMember (MemberDTO memberDTO){
        Member member = Member.builder()
                .memberId(memberDTO.getMemberId())
                .pw(memberDTO.getPw())
                .nickname(memberDTO.getNickname())
                .build();
        memberRepository.save(member);
    }

    public List<MemberDTO> findAll () {
        return memberRepository.findAll()
                .stream()
                .map(member -> MemberDTO.builder()
                        .memberId(member.getMemberId())
                        .nickname(member.getNickname())
                        .build())
                .collect(Collectors.toList());
    }
}
