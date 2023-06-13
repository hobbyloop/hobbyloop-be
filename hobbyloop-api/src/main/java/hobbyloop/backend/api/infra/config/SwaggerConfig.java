package hobbyloop.backend.api.infra.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.HttpAuthenticationScheme;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	private static final String SWAGGER_BASE_PACKAGE = "hobbyloop.backend.api";
	private static final String SWAGGER_TOKEN_REFERENCE = "Bearer 토큰 값 (Bearer 입력 없이 토큰 값만 입력하면 자동 추가)";

	@Bean
	public Docket restAPI() {
		return new Docket(DocumentationType.OAS_30)
			.useDefaultResponseMessages(true)
			.apiInfo(apiInfo())
			.select()
			.apis(RequestHandlerSelectors.basePackage(SWAGGER_BASE_PACKAGE))
			.paths(PathSelectors.any())
			.build()
			.securityContexts(List.of(securityContext()))
			.securitySchemes(List.of(bearerAuthSecurityScheme()));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title("하비루프 API 명세서 입니다.")
			.version("1.0.0")
			.description("하비루프의 swagger api 입니다.")
			.build();
	}

	private SecurityContext securityContext() {
		return springfox.documentation.spi.service.contexts
			.SecurityContext
			.builder()
			.securityReferences(defaultAuth())
			.operationSelector(operationContext -> true)
			.build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = new AuthorizationScope("global", "accessEveryThing");
		return List.of(new SecurityReference(SWAGGER_TOKEN_REFERENCE, authorizationScopes));
	}

	private HttpAuthenticationScheme bearerAuthSecurityScheme() {
		return HttpAuthenticationScheme.JWT_BEARER_BUILDER
			.name(SWAGGER_TOKEN_REFERENCE).build();
	}
}
