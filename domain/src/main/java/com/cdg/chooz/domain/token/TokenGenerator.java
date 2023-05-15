package com.cdg.chooz.domain.token;

import com.cdg.chooz.domain.user.User;
import com.cdg.chooz.domain.user.UserFinder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenGenerator {

    private final UserFinder userFinder;
    private final JwtTokenProvider jwtTokenProvider;

    private final int MONTH_TO_MINITES = 43200;
    private final int ACCESS_TOKEN_EXPIREDTIME = 30;

    public LoginToken generate(String providerId, boolean isNewUser) {
        User user = userFinder.findByProviderId(providerId);

        return new LoginToken(
                jwtTokenProvider.makeJwtToken(user.getId(), 1),
                jwtTokenProvider.makeJwtToken(user.getId(), MONTH_TO_MINITES), // TODO DB에 저장하는 로직 필요
                isNewUser
        );
    }
}
