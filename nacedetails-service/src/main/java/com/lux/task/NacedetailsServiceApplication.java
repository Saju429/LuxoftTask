package com.lux.task;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class NacedetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacedetailsServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/nace/*"))
				.apis(RequestHandlerSelectors.basePackage("com.lux"))
				.build()
				.apiInfo(apiDetails()); 
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo("NACE Details API", 
				"API to operate on NACE Details", 
				"1.0", "Free to use", 
				new springfox.documentation.service.Contact("Saju", "www.luxoft.com", "saju@luxoft.com"), 
				"API License", 
				"http://www.luxoft.com",
				Collections.emptyList());
	}

}
