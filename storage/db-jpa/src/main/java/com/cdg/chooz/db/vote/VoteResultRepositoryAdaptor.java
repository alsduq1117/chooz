package com.cdg.chooz.db.vote;

import com.cdg.chooz.db.user.UserEntity;
import com.cdg.chooz.db.user.UserJpaRepository;
import com.cdg.chooz.domain.user.User;
import com.cdg.chooz.domain.vote.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoteResultRepositoryAdaptor implements VoteResultRepository {
    private VoteResultJpaRepository voteResultJpaRepository;
    private VoteJpaRepository voteJpaRepository;
    private UserJpaRepository userJpaRepository;

    @Override
    public void doVote(Long voteId, Long userId, ChoiceType choice) {
        VoteEntity voteEntity = voteJpaRepository.findById(voteId).get();
        UserEntity userEntity = userJpaRepository.findById(userId).get();

        VoteResultEntity voteResultEntity = new VoteResultEntity(voteEntity,userEntity,choice);
        voteResultJpaRepository.save(voteResultEntity);
    }

    @Override
    public void save(VoteResult voteResult) {

    }
}
