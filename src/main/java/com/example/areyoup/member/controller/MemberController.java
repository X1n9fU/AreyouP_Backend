package com.example.areyoup.member.controller;

import com.example.areyoup.member.dto.MemberRequestDto;
import com.example.areyoup.member.dto.MemberResponseDto;
import com.example.areyoup.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class MemberController {
    private final MemberService memberService;

    /*
    회원가입
    - Image 존재 X -> 기본 이미지(로고) 세팅
     */
    @PostMapping("/join")
    public ResponseEntity<MemberResponseDto.MemberJoinDto> join(@ModelAttribute MemberRequestDto.MemberJoinDto memberDto) throws IOException {
        return ResponseEntity.ok()
                .body(memberService.join(memberDto));
    }

    /*
    IOS 회원가입
    - email, name, profileImageUrl
     */
    @PostMapping("/oauth2/join")
    public ResponseEntity<MemberResponseDto.MemberJoinDto> oAuth2Join(@RequestBody MemberRequestDto.MemberOauth2JoinDto memberDto) throws IOException {
        return ResponseEntity.ok()
                .body(memberService.oAuth2Join(memberDto));
    }

    /*
    회원 로그인
    -JWT AccessToken, RefreshToken 발급
        AccessToken - Header
        RefreshToken - DB
     */
    @PostMapping("/login")
    public ResponseEntity<MemberResponseDto.MemberLoginDto> login(HttpServletResponse response, @RequestBody MemberRequestDto.MemberLoginDto memberDto){
        return ResponseEntity.ok()
                .body(memberService.login(response, memberDto));
    }

    /*
    현재 로그인 중인 회원 정보
    - Id, Pw, name, nickname, everyTime id/pw, loginType, image
     */
    @GetMapping("/info")
    public ResponseEntity<MemberResponseDto.MemberInfoDto> info(HttpServletRequest request){
        return ResponseEntity.ok()
                .body(memberService.info(request));
    }

    /*
    회원 삭제
     */
    @DeleteMapping("/delete/{member_id}")
    public ResponseEntity<?> delete(@PathVariable(value = "member_id") Long id){
        return ResponseEntity.ok()
                .body(memberService.delete(id));
    }



}
