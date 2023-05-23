package com.cdg.chooz.domain.vote;

import com.cdg.chooz.domain.vote.AgeType;
import com.cdg.chooz.domain.vote.GenderType;
import com.cdg.chooz.domain.vote.MbtiType;
import com.cdg.chooz.domain.vote.VoteCategoryType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class VoteListData {
    private final Long voteId;

    private final UserData writer;

    private final String title;

    private final VoteCategoryType category;

    private final GenderType filteredGender;

    private final AgeType filteredAge;

    private final MbtiType filteredMbti;

    private final String imageA;

    private final String imageB;

    private final String titleA;

    private final String titleB;

    private final String detail;

    private final LocalDateTime modifiedDate;

    private final Long countVoted;



}
