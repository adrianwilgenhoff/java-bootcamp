/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.exercise3.Topic6.configuration;

import springfox.documentation.service.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiInfo;

/**
 *
 * @author Adrian
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
 
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.regex("/.*"))
            .build()
            .pathMapping("/")
            .genericModelSubstitutes(ResponseEntity.class)
            .useDefaultResponseMessages(false)
            .apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
	
            Contact c = new Contact("Adrian E. Wilgenhoff", "https://www.linkedin.com/in/adrian-wilgenhoff/","adrianwilgenhoff@gmail.com");
            return new ApiInfo("Topic 6 Exercise 3", "REST API to Register Users", null, null, c, "GLOBANT LICENSE", "");
	}

    
    
}