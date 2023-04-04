package com.cdg.chooz.domain.user;

import java.util.Optional;

public interface UserRepository {
    boolean existsByProviderId(String providerId);

    void register(User user);

}
