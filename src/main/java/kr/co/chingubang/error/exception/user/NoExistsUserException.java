package kr.co.chingubang.error.exception.user;

import kr.co.chingubang.error.dto.ErrorMessage;
import kr.co.chingubang.error.exception.BusinessException;

public class NoExistsUserException extends BusinessException {
	public NoExistsUserException() {
		super(ErrorMessage.NO_EXISTS_USER_ERROR);
	}
}
