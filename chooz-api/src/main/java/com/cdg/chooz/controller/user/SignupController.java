package com.cdg.chooz.controller.user;


import com.cdg.chooz.controller.common.CommonResponse;
import com.cdg.chooz.controller.user.request.GeneralSignUpRequest;
import com.cdg.chooz.domain.user.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class SignupController {

    private final SignupService signupService;


    @PostMapping("/signup")
    public ResponseEntity<CommonResponse> registerUser(@Valid @RequestBody GeneralSignUpRequest request){
        signupService.signup(request.toDomain());



        return new ResponseEntity(new CommonResponse("회원가입에 성공했습니다."), HttpStatus.OK);
    }
}
