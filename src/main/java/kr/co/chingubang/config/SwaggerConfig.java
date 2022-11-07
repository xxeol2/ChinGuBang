package kr.co.chingubang.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebSession;

import lombok.RequiredArgsConstructor;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.enable(true)
			.useDefaultResponseMessages(false)
			.ignoredParameterTypes(
				WebSession.class,
				ServerHttpRequest.class,
				ServerHttpResponse.class,
				ServerWebExchange.class
			)
			.apiInfo(new ApiInfo(
					"CHINGUBANG TITLE",
					"CHINGUBANG CORE API",
					"v.1.0",
					"urn:tos",
					new Contact(
						"CHINGUBANG",
						"https://github.com/xxeol2/ChinGuBang",
						"jhj01177@naver.com"
					),
					"Apache2.0",
					"http://www.apache.org/licenses/LICENSE-2.0",
					new ArrayList<>()
				)
			)
			.produces(new HashSet<>(Arrays.asList("application/json", "application/xml")))
			.consumes(new HashSet<>(Arrays.asList("application/json", "application/xml")))
			.securitySchemes(List.of(new ApiKey(
				"CHINGUBANG-API",
				"Authorization",
				"header"
			)))
			.select()
			.paths(PathSelectors.regex("/api/.*"))
			.build();
	}
}