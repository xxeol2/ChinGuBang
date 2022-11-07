package kr.co.chingubang.error.dto;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
	CONFLICT_ERROR(HttpStatus.BAD_REQUEST, "예기치 못한 에러가 발생했습니다."),

	/**
	 * User Error Message
	 */
	NO_EXISTS_USER_ERROR(HttpStatus.NOT_FOUND, "존재하지 않는 유저입니다."),

	/**
	 * Community Error Message
	 */
	NO_EXISTS_CATEGORY_ERROR(HttpStatus.NOT_FOUND, "존재하지 않는 카테고리입니다."),
	NO_EXISTS_COMMUNITY_ERROR(HttpStatus.NOT_FOUND, "존재하지 않는 커뮤니티입니다.");

	private final HttpStatus status;
	private final String description;
}