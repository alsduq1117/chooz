package com.cdg.chooz.controller.user.request;

import com.cdg.chooz.domain.user.GeneralSignUpInfo;
import lombok.Data;

@Data
public class GeneralSignUpRequest {
    private String name;
    private String email;
    private String password;

    public GeneralSignUpInfo toDomain() {
        return new GeneralSignUpInfo(name,email,password);
    }
}
