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
    private String name;
    private String email;
    private String password;
    private String providerId;
    private ProviderType provider;
    private RoleType role;
    private Integer age;
    private GenderType gender;
    private MbtiType mbti;

    public User(String name, String email, String password, String providerId){
        this.name = name;
        this.email = email;
        this.password = password;
        this.providerId = providerId;
    }

    public User(GeneralSignUpInfo signUpInfo){
        this.name=signUpInfo.getName();
        this.email = signUpInfo.getEmail();
        this.password = signUpInfo.getPassword();
    }











}
