package com.cdg.chooz.domain.vote;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class VoteResult {
    private Long id;

    private ChoiceType choice;

}
