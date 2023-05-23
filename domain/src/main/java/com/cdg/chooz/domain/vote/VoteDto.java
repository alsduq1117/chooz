package com.cdg.chooz.domain.vote;

import com.cdg.chooz.domain.user.User;
import com.cdg.chooz.domain.vote.Vote;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteDto {

    private User user;

    private Vote vote;

    public VoteDto(User user, Vote vote) {
        this.user = user;
        this.vote = vote;
    }
}
