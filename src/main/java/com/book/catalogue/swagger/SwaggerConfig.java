package com.book.catalogue.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.book.catalogue.controller"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());                                      
    }
    
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Book Catalogue System.")
            .description("This a simple web-service interface for book catalogue system. <br/> It provides following web-services."
            		+ "<br/> <br/>"
            		+ "Created by <b>Parth Kansara</b> <br/>"
            		+ "Mob. No: +65-86481539 <br/>"
            		+ "Email: kparth01@gmail.com <br/>"
            		+ "See more at: <a href=\"https://www.linkedin.com/in/parth-kansara-7ba7b593/\">LinkedIn</a> \t"
            		+ "<a href=\"https://stackoverflow.com/users/9952631/parth-kansara\">Stack Overflow</a>" )
            .license("Apache 2.0")
            .licenseUrl("#")
            .version("1.0")
            //.contact(new Contact("Parth Kansara", "https://www.linkedin.com/in/parth-kansara-7ba7b593/", "kparth01@gmail.com"))
            .build();
    }

    
}
