package com.cdg.chooz.domain.vote;

import com.cdg.chooz.domain.user.User;

public interface VoteResultRepository {
    void doVote(Long voteId, Long userId, ChoiceType choice);

    void save(VoteResult voteResult);
}
