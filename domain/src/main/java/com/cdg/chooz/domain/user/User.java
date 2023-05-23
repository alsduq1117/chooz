package com.cdg.chooz.domain.user;

import com.cdg.chooz.domain.vote.AgeType;
import com.cdg.chooz.domain.vote.GenderType;
import com.cdg.chooz.domain.vote.MbtiType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Getter
@Builder
@NoArgsConstructor
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

    private String imageUrl;

    public User(String name, String email, String password, String providerId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.providerId = providerId;
    }

    public User(GeneralSignupInfo signupInfo) {
        this.name = signupInfo.getName();
        this.email = signupInfo.getEmail();
        this.password = signupInfo.getPassword();
    }

    public User(String providerId, ProviderType providerType) {
        this.providerId = providerId;
        this.provider = providerType;
    }

    public AgeType classifyAge(Integer age){
        AgeType ageGroup;
        switch (age/10){
            case 1:
                ageGroup = AgeType.teenager;
                break;
            case 2:
                ageGroup = AgeType.twenties;
                break;
            case 3:
                ageGroup = AgeType.thirties;
                break;
            case 4:
                ageGroup = AgeType.fourties;
                break;
            case 5:
                ageGroup = AgeType.fifties;
                break;
            default:
                ageGroup = AgeType.NULL;
                break;
        }
        return ageGroup;
    }
}
