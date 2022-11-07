package kr.co.chingubang.error.exception.community;

import kr.co.chingubang.error.dto.ErrorMessage;
import kr.co.chingubang.error.exception.BusinessException;

public class NoExistsCategoryException extends BusinessException {
	public NoExistsCategoryException() {
		super(ErrorMessage.NO_EXISTS_CATEGORY_ERROR);
	}
}
