package com.cdg.chooz.domain.vote;

import java.util.List;

public interface VoteRepository {
    void save(Vote vote, Long id);

    Vote findById(Long id);

    List<VoteListData> getVoteSortByTime(VoteCategoryType category, int page, int size, SortByType sortBy);

    List<VoteListData> getVoteByPopularity(VoteCategoryType category, int page, int size, SortByType sortBy);

    void deleteById(Long voteId);

    VoteDto findVoteandPostedUserById(Long id);

}
