package com.cdg.chooz.controller.user;

import com.cdg.chooz.controller.common.CommonResponse;
import com.cdg.chooz.controller.user.request.GeneralSignUpRequest;
import com.cdg.chooz.controller.user.request.GetKakaoTokenRequest;
import com.cdg.chooz.controller.user.request.GetNaverTokenRequest;
import com.cdg.chooz.controller.user.response.GetLoginTokenResponse;
import com.cdg.chooz.domain.token.LoginToken;
import com.cdg.chooz.domain.user.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 회원가입을 담당하는 컨트롤러
 */
@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class SignupController {

    private final SignupService signupService;

    @PostMapping("/signup")
    public ResponseEntity<CommonResponse> signup(@Valid @RequestBody GeneralSignUpRequest request) {
        signupService.signup(request.toDomain());
        return new ResponseEntity(new CommonResponse("회원가입에 성공했습니다."), HttpStatus.OK);
    }

    /**
     * 카카오 서버에서 유저정보 조희
     *
     * @param request
     * @return 엑세스 토큰
     */
    @PostMapping("/signup/kakao")
    public ResponseEntity<GetLoginTokenResponse> signupByKakao(@Valid @RequestBody GetKakaoTokenRequest request) {
        LoginToken loginToken = signupService.signupByThirdParty(request.toDomain());
        return new ResponseEntity(new GetLoginTokenResponse(loginToken), HttpStatus.OK);
    }

    @PostMapping("/signup/naver")
    public ResponseEntity<GetLoginTokenResponse> signupByNaver(@Valid @RequestBody GetNaverTokenRequest request) {
        LoginToken loginToken = signupService.signupByThirdParty(request.toDomain());
        return new ResponseEntity(new GetLoginTokenResponse(loginToken), HttpStatus.OK);
    }
}
