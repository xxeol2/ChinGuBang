package kr.co.chingubang.community.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.chingubang.community.domain.Category;
import kr.co.chingubang.community.domain.Community;
import kr.co.chingubang.community.infrastructure.CommunityRepository;
import kr.co.chingubang.error.exception.community.NoExistsCommunityException;
import kr.co.chingubang.user.domain.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunityService {
	private final CommunityRepository communityRepository;

	@Transactional
	public Community save(User user, Category category, String content) {
		return communityRepository.save(
			Community.builder()
				.user(user)
				.category(category)
				.content(content)
				.build()
		);
	}

	@Transactional
	public Community findById(Long categoryId) {
		return communityRepository.findById(categoryId)
			.orElseThrow(NoExistsCommunityException::new);
	}
}
