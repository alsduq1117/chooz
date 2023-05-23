package com.cdg.chooz.domain.vote;


import com.cdg.chooz.domain.user.User;
import com.cdg.chooz.domain.user.UserId;
import com.cdg.chooz.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;

    private final UserRepository userRepository;

    private final VoteResultRepository voteResultRepository;

    public Long createVote(CreateVoteInfo createVoteInfo, Long id) {
        Vote vote = Vote.builder()
                .category(VoteCategoryType.ETC)
                .title(createVoteInfo.getTitle())
                .imageA(createVoteInfo.getImageA())
                .imageB(createVoteInfo.getImageB())
                .titleA(createVoteInfo.getTitleA())
                .titleB(createVoteInfo.getTitleB())
                .build();

        voteRepository.save(vote, id);

        return vote.getId();
    }

    public List<VoteListData> getVoteList(SortByType sortBy, int page, int size, VoteCategoryType category) {

        if (sortBy.equals(SortByType.ByTime)) {
            voteRepository.getVoteSortByTime(category, page, size, sortBy);
        } else if (sortBy.equals(SortByType.ByPopularity)) {
            voteRepository.getVoteByPopularity(category, page, size, sortBy);
        } else {
            throw new RuntimeException("잘못된 요청입니다.");
        }
    }


    public GetVoteDto getVote(Long voteId) {

        VoteDto voteDto = voteRepository.findVoteandPostedUserById(voteId);
        Vote vote = voteDto.getVote();
        User user = voteDto.getUser();


        GetVoteUserResponse getVoteUserResponse = GetVoteUserResponse.builder()
                .userImage(user.getImageUrl())
                .userGender(user.getGender())
                .userAge(user.classifyAge(user.getAge()))
                .userMbti(user.getMbti())
                .nickName(user.getName())
                .build();


        GetVoteDto getVoteDto = GetVoteDto.builder()
                .writer(getVoteUserResponse)
                .category(vote.getCategory())
                .title(vote.getTitle())
                .imageA(vote.getImageA())
                .imageB(vote.getImageB())
                .filteredGender(vote.getFilteredGender())
                .filteredAge(vote.getFilteredAge())
                .filteredMbti(vote.getFilteredMbti())
                .titleA(vote.getTitleA())
                .titleB(vote.getTitleB())
                .description(vote.getDetail())
                .build();

        return getVoteDto;
    }


    public void updateVote(UpdateVoteInfo updateVoteInfo, UserId userId, Long voteId) {

        //유저 확인 코드
        Vote vote = voteRepository.findById(voteId);

        vote.update(updateVoteInfo);

    }

    public void deleteVote(Long voteId, UserId userId) {

        voteRepository.deleteById(voteId);

    }

    public void doVote(DoVoteInfo doVote) {

        voteResultRepository.doVote(doVote.getVoteId(), doVote.getUserId(), doVote.getChoice());

    }
}
