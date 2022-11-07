package kr.co.chingubang.community.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kr.co.chingubang.common.dto.ResponseDto;
import kr.co.chingubang.community.dto.request.CommunityCreateRequest;
import kr.co.chingubang.community.dto.response.CommunityCreateResponse;
import kr.co.chingubang.community.facade.CommunityFacade;
import lombok.RequiredArgsConstructor;

@Api(tags = "커뮤니티 API")
@RestController
@RequestMapping("/api/v1/community")
@RequiredArgsConstructor
public class CommunityController {
	private final CommunityFacade communityFacade;

	@ApiOperation(value = "커뮤니티 글 작성 API")
	@PostMapping("/{categoryId}")
	public ResponseEntity<CommunityCreateResponse> create(
		@PathVariable Long categoryId,
		@Validated @RequestBody CommunityCreateRequest request
	) {
		Long userId = 1L; // TODO: Auth로 id 받기
		return ResponseDto.created(communityFacade.register(userId, categoryId, request));
	}
}
