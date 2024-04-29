package com.example.areyoup.member.dto;

import jakarta.persistence.Basic;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class MemberRequestDto {


    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberJoinDto  {
        private String memberId;
        private String memberPw;
        private String name;
        private String nickname;
        private MultipartFile image;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberOauth2JoinDto{
        private String email;
        private String nickname;
        private String profileImageUrl;
    }


    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    public static class MemberLoginDto {
        private String memberId;
        private String memberPw;
    }


}
