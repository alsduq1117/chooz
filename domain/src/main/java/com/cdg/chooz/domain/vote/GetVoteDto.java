package com.cdg.chooz.domain.vote;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class GetVoteDto {

    private GetVoteUserResponse writer;

    private LocalDateTime voteCreatedDate;

    private VoteCategoryType category;

    private String title;

    private String imageA;

    private String imageB;

    private GenderType filteredGender;

    private AgeType filteredAge;

    private MbtiType filteredMbti;

    private String titleA;

    private String titleB;

    private String description;


    @Builder
    public GetVoteDto(GetVoteUserResponse writer, String nickName, LocalDateTime voteCreatedDate, VoteCategoryType category, String title, String imageA
            , String imageB, GenderType filteredGender, AgeType filteredAge, MbtiType filteredMbti, String titleA, String titleB, String description){
        this.writer = writer;
        this.voteCreatedDate = voteCreatedDate;
        this.category = category;
        this.title = title;
        this.imageA = imageA;
        this.imageB = imageB;
        this.filteredGender = filteredGender;
        this.filteredAge = filteredAge;
        this.filteredMbti = filteredMbti;
        this.titleA = titleA;
        this.titleB = titleB;
        this.description = description;
    }

}