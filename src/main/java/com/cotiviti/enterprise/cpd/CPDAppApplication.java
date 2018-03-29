package com.cotiviti.enterprise.cpd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cotiviti.enterprise.cpd.dao.OpportunityRepository;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableSwagger2
public class CPDAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CPDAppApplication.class, args);
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("cpd")
				.apiInfo(apiInfo())
				.select()
				.paths(regex("/opportunity.*"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Spring REST Sample with Swagger")
				.description("Simple CPD Distributed Application using kafka")
				.contact("pranathi pulimamidy")
				.license("APL V2")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("2.0")
				.build();
	}
}
