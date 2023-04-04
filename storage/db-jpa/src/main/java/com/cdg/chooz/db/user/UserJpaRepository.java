package com.cdg.chooz.db.user;

import com.cdg.chooz.domain.user.User;
import com.cdg.chooz.domain.user.UserRepository;
import com.cdg.chooz.db.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findByProviderId(String providerId);

    Boolean existsByProviderId(String providerId);


}
