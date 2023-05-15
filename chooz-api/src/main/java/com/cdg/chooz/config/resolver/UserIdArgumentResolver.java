package com.cdg.chooz.config.resolver;

import com.cdg.chooz.domain.token.JwtTokenProvider;
import com.cdg.chooz.domain.user.UserId;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserIdArgumentResolver implements HandlerMethodArgumentResolver {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType() == UserId.class;
    }

    @Override
    public UserId resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        try {
            String authorizationHeader = webRequest.getHeader(HttpHeaders.AUTHORIZATION);
            Map<String, Object> parseJwtTokenMap = jwtTokenProvider.parseJwtToken(authorizationHeader);
            Claims claims = (Claims)parseJwtTokenMap.get("claims");
            Long userId = (Long) claims.get("userId");
            return new UserId(userId);
        } catch (Exception e) {
            log.info("UserIdArgumentResolver.resolveArgument() : {}", e.getMessage());
            return null;
        }
    }
}
