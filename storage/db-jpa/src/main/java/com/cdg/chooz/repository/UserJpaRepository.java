package com.cdg.chooz.repository;

import com.cdg.chooz.domain.user.User;
import com.cdg.chooz.domain.user.UserRepository;
import com.cdg.chooz.entity.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public abstract class UserJpaRepository implements UserRepository {

    private final EntityManager em;
    @Override
    public Optional<User> findById(Long Id) {
        UserEntity userEntity = em.find(UserEntity.class, Id);
        return Optional.ofNullable(userEntity.toDomain());
    }

    @Override
    public Boolean existsByProviderId(String providerId) {
        Long result = em.createQuery("SELECT count(u) FROM UserEntity u WHERE u.providerId = :providerId", Long.class)
                .setParameter("providerId", providerId)
                .getSingleResult();
        if (result > 0)
            return true;
        else{
            return false;
        }
    }

}
