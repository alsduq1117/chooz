package com.cdg.chooz.domain.vote;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vote {

    private Long id;

    private String title;

    private String imageA;

    private String imageB;

    private String titleA;

    private String titleB;

    private String detail;

    private VoteCategoryType category;

    private GenderType filteredGender;

    private AgeType filteredAge;

    private MbtiType filteredMbti;

    public void  update(UpdateVoteInfo updateVoteInfo) {
        this.title = updateVoteInfo.getTitle();
        this.titleA = updateVoteInfo.getTitleA();
        this.titleB = updateVoteInfo.getTitleB();
        this.detail = updateVoteInfo.getDetail();
        this.category = updateVoteInfo.getCategory();
    }

}
