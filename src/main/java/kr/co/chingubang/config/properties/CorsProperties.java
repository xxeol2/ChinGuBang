package kr.co.chingubang.config.properties;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties(prefix = "cors")
public class CorsProperties {
	@NotBlank
	private String allowedOrigins;
	@NotBlank
	private String allowedMethods;
	@NotBlank
	private String allowedHeaders;
	@Getter
	@NotNull
	@Max(3600)
	private Long maxAge;
	@Getter
	@NotBlank
	private String applyUrlRange;
}