package com.cdg.chooz.domain.vote;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateVoteInfo {

    private String title;

    private String detail;

    private VoteCategoryType category;

    private String titleA;

    private String titleB;

    @Builder
    public UpdateVoteInfo(String title, String detail, VoteCategoryType category, String titleA, String titleB) {
        this.title = title;
        this.detail = detail;
        this.category = category;
        this.titleA = titleA;
        this.titleB = titleB;
    }
}
