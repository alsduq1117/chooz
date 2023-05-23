package com.cdg.chooz.domain.user;

public interface UserRepository {
    boolean existsByProviderId(String providerId);

    void register(User user);

    User findByProviderId(String providerId);

    User findById(Long userId);
}
