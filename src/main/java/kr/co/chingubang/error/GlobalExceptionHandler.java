package kr.co.chingubang.error;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kr.co.chingubang.error.dto.ErrorDto;
import kr.co.chingubang.error.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<ErrorDto> handleBusinessException(
		final BusinessException e,
		final HttpServletRequest request
	) {
		log.error("BusinessException -> {} {}", e.getErrorMessage(), e.getCause());
		log.error("Request url {}", request.getRequestURL());

		return ResponseEntity
			.status(e.getErrorMessage().getStatus())
			.body(
				new ErrorDto(
					e.getErrorMessage().name(),
					e.getErrorMessage().getDescription())
			);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorDto> handleException(
		final Exception e,
		final HttpServletRequest request
	) {
		var errorMessage =
			e.getCause().toString() + "\n" + e.getLocalizedMessage() + Arrays.toString(e.getStackTrace());

		log.error("Exception -> {} | {}", e.getMessage(), errorMessage);
		log.error("Request url {}", request.getRequestURL());

		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body(
				new ErrorDto(
					e.getMessage(),
					errorMessage
				)
			);
	}
}