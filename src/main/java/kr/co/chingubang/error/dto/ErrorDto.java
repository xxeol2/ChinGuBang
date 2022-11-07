package kr.co.chingubang.error.dto;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class ErrorDto implements Serializable {
	private final String message;
	private final String reason;

	public ErrorDto(String message, String reason) {
		this.message = message;
		this.reason = reason;
	}

	public ErrorDto(ErrorMessage message) {
		this.message = message.name();
		this.reason = message.getDescription();
	}
}