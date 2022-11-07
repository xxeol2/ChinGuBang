package kr.co.chingubang.error.exception.community;

import kr.co.chingubang.error.dto.ErrorMessage;
import kr.co.chingubang.error.exception.BusinessException;

public class NoExistsCommunityException extends BusinessException {
	public NoExistsCommunityException() {
		super(ErrorMessage.NO_EXISTS_COMMUNITY_ERROR);
	}
}
