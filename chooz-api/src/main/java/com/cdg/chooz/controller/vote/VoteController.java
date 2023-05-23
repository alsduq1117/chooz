package com.cdg.chooz.controller.vote;


import com.cdg.chooz.controller.common.CommonResponse;
import com.cdg.chooz.controller.vote.request.DoVoteRequest;
import com.cdg.chooz.controller.vote.request.UpdateVoteRequest;
import com.cdg.chooz.controller.vote.request.CreateVoteRequest;
import com.cdg.chooz.controller.vote.response.CreateVoteResponse;
import com.cdg.chooz.controller.vote.response.GetVoteListResponse;
import com.cdg.chooz.domain.vote.*;
import com.cdg.chooz.domain.user.UserId;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/votes")
@RestController
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping("")
    public ResponseEntity<CreateVoteResponse> createVote(@Valid @RequestBody CreateVoteRequest request, UserId userId){

        Long voteId = voteService.createVote(request.toDomain(),userId.getId());
        CreateVoteResponse createVoteResponse = CreateVoteResponse.builder()
                .voteId(voteId)
                .message("투표 생성에 성공했습니다.")
                .build();
        return new ResponseEntity(createVoteResponse, HttpStatus.OK);
    }


    @GetMapping("")
    public ResponseEntity<GetVoteListResponse> getVoteList(@RequestParam SortByType sortBy, @RequestParam int page, @RequestParam int size, @RequestParam(required = false) VoteCategoryType category) {
        List<VoteListData> voteListData = voteService.getVoteList(sortBy, page, size, category);
        GetVoteListResponse voteResponse = GetVoteListResponse.builder()
                .voteSlice()
                .build();
        return new ResponseEntity(voteResponse, HttpStatus.OK);
    }

    @GetMapping("/{voteId}")
    public ResponseEntity<GetVoteDto> getVote(@PathVariable Long voteId) {
        GetVoteDto getVoteDto = voteService.getVote(voteId);

        return new ResponseEntity(getVoteDto,HttpStatus.OK);
    }

    //수정
    @PatchMapping("/{voteId}")
    public ResponseEntity<CommonResponse> updateVote(@PathVariable("voteId") Long voteId, @Valid @RequestBody UpdateVoteRequest updateVoteRequest, UserId userId) {

        voteService.updateVote(updateVoteRequest.toDomain(), userId, voteId);

        CommonResponse updateVoteResponse = CommonResponse.builder()
                .message("투표 수정에 성공했습니다")
                .build();
        return new ResponseEntity(updateVoteResponse, HttpStatus.OK);
    }

    //삭제
    @DeleteMapping("/{voteId}")
    public ResponseEntity<CommonResponse> deleteVote(@PathVariable("voteId") Long voteId, UserId userId) {

        voteService.deleteVote(voteId, userId);
        CommonResponse updateVoteResponse = CommonResponse.builder()
                .message("투표 삭제에 성공했습니다")
                .build();

        return new ResponseEntity(updateVoteResponse, HttpStatus.OK);
    }

    //투표
    @PostMapping("/{voteId}/vote")
    public ResponseEntity doVote(@RequestBody DoVoteRequest doVoteRequest, @PathVariable("voteId") Long voteId, UserId userId) {

        voteService.doVote(doVoteRequest.toDomain(userId.getId(),voteId));

        CommonResponse commonResponse = CommonResponse.builder()
                .message("투표 참여에 성공했습니다.")
                .build();

        return new ResponseEntity(commonResponse ,HttpStatus.OK);
    }
}
