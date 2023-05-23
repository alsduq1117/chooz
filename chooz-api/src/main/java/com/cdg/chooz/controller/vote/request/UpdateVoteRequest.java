package com.cdg.chooz.controller.vote.request;

import com.cdg.chooz.domain.vote.UpdateVoteInfo;
import com.cdg.chooz.domain.vote.VoteCategoryType;
import lombok.Builder;

public class UpdateVoteRequest {
    private String title;

    private String detail;

    private VoteCategoryType category;

    private String titleA;

    private String titleB;

    @Builder
    public UpdateVoteRequest(String title, String detail, VoteCategoryType category, String titleA, String titleB) {
        this.title = title;
        this.detail = detail;
        this.category = category;
        this.titleA = titleA;
        this.titleB = titleB;
    }


    public UpdateVoteInfo toDomain() {
        return new UpdateVoteInfo(title, detail, category, titleA, titleB);
    }
}
