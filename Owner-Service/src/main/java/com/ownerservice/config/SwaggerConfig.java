package com.ownerservice.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final String AUTHORIZATION_HEADER="Authorization";
	 @Bean
	    public Docket empApi() {
	        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
	        		 .securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey())).select()
	                 .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	    }
	 private ApiKey apiKey() {
	        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	    }
	 private SecurityContext securityContext() {
	        return SecurityContext.builder().securityReferences(defaultAuth()).build();
	    }



	   private List<SecurityReference> defaultAuth() {
	        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
	        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	        authorizationScopes[0] = authorizationScope;
	        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	    }

	    private ApiInfo apiInfo() {
	    
	            return new ApiInfo("My REST API", "Some custom description of API.", "1.0", "Terms of service",
	                    new Contact("sahithya", "www.ownerservice.com", "sahithyasahiparnapalli@gmail.com"), "License of API",
	                    "API license URL", Collections.emptyList());
	    }

}

