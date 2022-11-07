package kr.co.chingubang.user.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.chingubang.error.exception.user.NoExistsUserException;
import kr.co.chingubang.user.domain.User;
import kr.co.chingubang.user.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	@Transactional(readOnly = true)
	public User findById(Long id) {
		return userRepository.findById(id)
			.orElseThrow(NoExistsUserException::new);
	}
}
