package kr.co.chingubang.common.dto;

import java.io.Serializable;
import org.springframework.http.ResponseEntity;

public record ResponseDto<T>(T date) implements Serializable {
    public static <T> ResponseEntity<T> success(T data) {
        return ResponseEntity.ok(data);
    }
}