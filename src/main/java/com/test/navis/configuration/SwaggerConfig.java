package com.test.navis.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.HashSet;
import java.util.Set; 


@EnableSwagger2
@Configuration
public class SwaggerConfig {

	
	@Bean
	public Docket productApi() {
		
		Set<String> protocols= new HashSet<String>();
		protocols.add("http");
		
		return new Docket(DocumentationType.SWAGGER_2)
				.protocols(protocols)
				.select()
		        .apis(RequestHandlerSelectors.basePackage("com.test.navis"))
                .paths(regex("/.*"))
                .build().apiInfo(metaInfo());
	}
	
	@SuppressWarnings("deprecation")
	private ApiInfo metaInfo() {
	
		ApiInfo apiInfo=new ApiInfo("Documentation testNavis V1", "", "1.0","", "", "", "");
		
	return apiInfo;
	}
	
	
}

