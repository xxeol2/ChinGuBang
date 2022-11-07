package kr.co.chingubang.comment.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.co.chingubang.comment.dto.request.CommentCreateRequest;
import kr.co.chingubang.comment.dto.response.CommentCreateResponse;
import kr.co.chingubang.comment.facade.CommentFacade;
import kr.co.chingubang.common.dto.ResponseDto;
import lombok.RequiredArgsConstructor;

@Api(tags = "댓글 API")
@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {
	private final CommentFacade commentFacade;

	@ApiOperation(value = "커뮤니티 댓글 작성 API")
	@PostMapping("/{communityId}")
	public ResponseEntity<CommentCreateResponse> create(
		@PathVariable Long communityId,
		@Validated @RequestBody CommentCreateRequest request
	) {
		Long userId = 1L; // TODO: Auth로 id 받기
		return ResponseDto.created(commentFacade.register(userId, communityId, request));
	}
}
