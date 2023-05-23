package com.cdg.chooz.domain.vote;

import com.cdg.chooz.domain.vote.AgeType;
import com.cdg.chooz.domain.vote.GenderType;
import com.cdg.chooz.domain.vote.MbtiType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetVoteUserResponse {
    private String userImage;

    private GenderType userGender;

    private AgeType userAge;

    private MbtiType userMbti;

    private String nickName;

    @Builder
    public GetVoteUserResponse(String userImage, GenderType userGender, AgeType userAge, MbtiType userMbti, String nickName) {
        this.userImage = userImage;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userMbti = userMbti;
        this.nickName = nickName;
    }

}
