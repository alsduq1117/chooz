package com.cdg.chooz.domain.user;

import java.util.Optional;

public interface UserRepository {

    void save(User user);
    Optional<User> findById(Long Id);

    Boolean existsByProviderId(String providerId);

}
