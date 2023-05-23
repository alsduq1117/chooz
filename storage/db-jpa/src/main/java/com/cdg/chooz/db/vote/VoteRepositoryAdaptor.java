package com.cdg.chooz.db.vote;

import com.cdg.chooz.db.user.UserEntity;
import com.cdg.chooz.db.user.UserJpaRepository;
import com.cdg.chooz.domain.user.User;
import com.cdg.chooz.domain.vote.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VoteRepositoryAdaptor implements VoteRepository {

    private final VoteJpaRepository voteJpaRepository;
    private final UserJpaRepository userJpaRepository;

    @Override
    public void save(Vote vote, Long id) {

        Optional<UserEntity> user = userJpaRepository.findById(id);
        UserEntity userEntity = user.get();
        VoteEntity voteEntity = new VoteEntity(vote,userEntity);
        voteJpaRepository.save(voteEntity);
    }

    @Override
    public Vote findById(Long id) {
        return voteJpaRepository.findById(id)
                .map(VoteEntity::toDomain)
                .orElse(null);
    }

    @Override
    public List<VoteListData> getVoteSortByTime(VoteCategoryType category, int page, int size, SortByType sortBy) {     //보완 필요
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, sortBy.getValue()));
        List<VoteListData> sliceBy = voteJpaRepository.findSliceBy(category, pageRequest);

        return sliceBy;
    }

    @Override
    public List<VoteListData> getVoteByPopularity(VoteCategoryType category, int page, int size, SortByType sortBy) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, sortBy.getValue()));

    }

    @Override
    public void deleteById(Long voteId) {
        voteJpaRepository.deleteById(voteId);
    }


    @Override
    public VoteDto findVoteandPostedUserById(Long id) {
        VoteEntity voteEntity = voteJpaRepository.findById(id).get();
        UserEntity postedUser = voteEntity.getPostedUser();

        Vote vote = voteEntity.toDomain();
        User user = postedUser.toDomain();

        return new VoteDto(user,vote);
    }
}
