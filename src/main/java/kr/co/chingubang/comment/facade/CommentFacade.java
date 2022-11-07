package kr.co.chingubang.comment.facade;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kr.co.chingubang.comment.application.CommentService;
import kr.co.chingubang.comment.domain.Comment;
import kr.co.chingubang.comment.dto.request.CommentCreateRequest;
import kr.co.chingubang.comment.dto.response.CommentCreateResponse;
import kr.co.chingubang.community.application.CommunityService;
import kr.co.chingubang.community.domain.Community;
import kr.co.chingubang.user.application.UserService;
import kr.co.chingubang.user.domain.User;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CommentFacade {
	private final CommentService commentService;
	private final UserService userService;
	private final CommunityService communityService;

	@Transactional
	public CommentCreateResponse register(Long userId, Long communityId, CommentCreateRequest request) {
		Community community = communityService.findById(communityId);
		User user = userService.findById(userId);

		Comment comment = commentService.save(
			user,
			community,
			request.content()
		);

		return new CommentCreateResponse(
			comment.getId(),
			communityId,
			request.content(),
			userId
		);
	}
}
