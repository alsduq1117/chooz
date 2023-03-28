package com.cdg.chooz.domain.user;

import com.cdg.chooz.domain.vote.GenderType;
import com.cdg.chooz.domain.vote.MbtiType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class User {

    private Long id;
    private String nickname;
    private String email;
    private String imageUrl;
    private String password;
    private Providers provider;    // oauth2를 이용할 경우 어떤 플랫폼을 이용하는지
    private String providerId;  // oauth2를 이용할 경우 아이디값
    private Role role;
    private Integer age;
    private GenderType gender;
    private MbtiType mbti;
    private LocalDateTime modifiedMBTIDate;










}
