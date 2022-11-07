package kr.co.chingubang.community.facade;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import kr.co.chingubang.community.application.CategoryService;
import kr.co.chingubang.community.application.CommunityService;
import kr.co.chingubang.community.domain.Category;
import kr.co.chingubang.community.dto.request.CommunityCreateRequest;
import kr.co.chingubang.community.dto.response.CommunityCreateResponse;
import kr.co.chingubang.user.application.UserService;
import kr.co.chingubang.user.domain.User;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CommunityFacade {
	private final CommunityService communityService;
	private final CategoryService categoryService;
	private final UserService userService;

	@Transactional
	public CommunityCreateResponse register(Long userId, Long categoryId, CommunityCreateRequest request) {
		Category category = categoryService.findById(categoryId);
		User user = userService.findById(userId);

		var community = communityService.save(
			user,
			category,
			request.content()
		);

		return new CommunityCreateResponse(
			community.getId(),
			request.content(),
			userId
		);
	}
}
