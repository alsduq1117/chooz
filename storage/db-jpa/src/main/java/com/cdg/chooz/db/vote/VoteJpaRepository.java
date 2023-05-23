package com.cdg.chooz.db.vote;

import com.cdg.chooz.domain.vote.VoteCategoryType;
import com.cdg.chooz.domain.vote.VoteListData;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteJpaRepository extends JpaRepository<VoteEntity, Long> {

    @Query("SELECT new com.cdg.chooz..dto.FindVoteListData(v,(SELECT count(vr.vote) FROM VoteResult vr WHERE vr.vote = v))" +
            "FROM VoteEntity v WHERE (:category is null or v.category = :category)")
    List<VoteListData> findSliceBy(@Param("category") VoteCategoryType category , Pageable pageable);


    @Query("SELECT v FROM VoteEntity v " +
            "left join FETCH v.voteResultList vr " +
            "join FETCH v.postedUser pu " +
            "WHERE :category IS NULL OR v.category = :category " +
            "GROUP BY v.id, vr.id " +
            "order by count(vr.vote.id) DESC")
    Slice<VoteEntity> findWithVoteResult(@Param("category") VoteCategoryType category, PageRequest pageRequest);

}
