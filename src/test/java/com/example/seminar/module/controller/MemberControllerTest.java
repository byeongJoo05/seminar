package com.example.seminar.module.controller;

import com.example.seminar.module.service.BoardService;
import com.example.seminar.module.service.MemberService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@ExtendWith(RestDocumentationExtension.class)
@WebMvcTest(MemberController.class)
class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    MemberService memberService;

    @MockBean
    BoardService boardService;

    @Test
    @DisplayName("한 명의 회원이 회원가입을 시도한다.")
    public void register () throws Exception {
        Map<String, String> requestParams = Map.of("memberId", "son",
                "pw", "test123",
                "nickname", "sonny");
        mockMvc.perform(post("/v1/member/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestParams))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("register-member",
                        requestFields(
                                fieldWithPath("memberId").description("회원 ID"),
                                fieldWithPath("pw").description("회원 비밀번호"),
                                fieldWithPath("nickname").description("회원 별명")
                        ),
                        responseFields(
                                fieldWithPath("code").description("상태 코드"),
                                fieldWithPath("msg").description("상태 메세지")
                        )
                ));
    }

    @Test
    @DisplayName("서비스에 가입된 회원들의 목록을 출력한다.")
    public void findMembers() throws Exception {
        mockMvc.perform(get("/v1/member/findMembers")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("find-members",
                        responseFields(
                                fieldWithPath("code").description("상태 코드"),
                                fieldWithPath("msg").description("상태 메세지"),
                                subsectionWithPath("data").description("응답 데이터").type(JsonFieldType.ARRAY),
                                fieldWithPath("data[].memberId").description("회원 ID").type(JsonFieldType.STRING).optional(),
                                fieldWithPath("data[].nickname").description("회원 별명").type(JsonFieldType.STRING).optional()
                        )
                        ));
    }
}