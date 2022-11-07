package kr.co.chingubang.community.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.chingubang.community.domain.Category;
import kr.co.chingubang.community.infrastructure.CategoryRepository;
import kr.co.chingubang.error.exception.community.NoExistsCategoryException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	public Category findById(Long id) {
		return categoryRepository.findById(id)
			.orElseThrow(NoExistsCategoryException::new);
	}
}
