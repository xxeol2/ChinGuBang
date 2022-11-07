package kr.co.chingubang.error.exception;

import org.springframework.http.HttpStatus;

import kr.co.chingubang.error.dto.ErrorMessage;
import lombok.Getter;

@Getter
public abstract class BusinessException extends RuntimeException {
	private final HttpStatus status;

	public BusinessException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}

	public BusinessException(Throwable cause, HttpStatus status) {
		super(cause);
		this.status = status;
	}

	public BusinessException(String message, Throwable cause, HttpStatus status) {
		super(message, cause);
		this.status = status;
	}

	public BusinessException(ErrorMessage message, HttpStatus status) {
		super(message.getDescription());
		this.status = status;
	}
}