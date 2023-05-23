package com.cdg.chooz.controller.vote.request;

import com.cdg.chooz.domain.user.UserId;
import com.cdg.chooz.domain.vote.ChoiceType;
import com.cdg.chooz.domain.vote.DoVoteInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DoVoteRequest {

    private ChoiceType choice;

    public DoVoteInfo toDomain(Long userId, Long voteId) {
        return DoVoteInfo.builder()
                .userId(userId)
                .voteId(voteId)
                .choice(choice)
                .build();
    }

    public DoVoteRequest(ChoiceType choice) {
        this.choice = choice;
    }
}
