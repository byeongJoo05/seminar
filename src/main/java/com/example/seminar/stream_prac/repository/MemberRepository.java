package com.example.seminar.stream_prac.repository;

import com.example.seminar.stream_prac.domain.Member;
import com.example.seminar.stream_prac.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
