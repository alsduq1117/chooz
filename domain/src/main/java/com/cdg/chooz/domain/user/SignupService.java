package com.cdg.chooz.domain.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;

    public void signup(GeneralSignUpInfo signUpInfo){



        User user = new User(signUpInfo);
        userRepository.register(user);
    }
}
