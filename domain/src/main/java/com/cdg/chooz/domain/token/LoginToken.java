package com.cdg.chooz.domain.token;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginToken {
    private String accessToken;
    private String refreshToken;
    private boolean isNewUser;
}
