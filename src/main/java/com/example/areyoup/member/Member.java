package com.example.areyoup.member;

import com.example.areyoup.global.entity.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberId; //이메일
    private String memberPw;
    private String name;

    //에브리타임 id pw
    private String everyTimeId;
    private String everyTimePw;
    private String refreshToken;

    @ElementCollection(fetch=FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private ProfileImage profileImg;

}