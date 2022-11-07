package kr.co.chingubang.comment.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.chingubang.comment.domain.Comment;
import kr.co.chingubang.comment.infrastructure.CommentRepository;
import kr.co.chingubang.community.domain.Community;
import kr.co.chingubang.user.domain.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final CommentRepository commentRepository;

	@Transactional(readOnly = true)
	public Comment save(User user, Community community, String content) {
		return commentRepository.save(
			Comment.builder()
				.user(user)
				.content(content)
				.community(community)
				.build()
		);
	}
}
