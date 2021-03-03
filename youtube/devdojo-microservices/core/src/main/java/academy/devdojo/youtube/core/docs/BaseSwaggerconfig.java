package academy.devdojo.youtube.core.docs;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class BaseSwaggerconfig {

    private final String basePackage;

    public BaseSwaggerconfig(String basePackage) {
        this.basePackage = basePackage;
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData(){
        return new ApiInfoBuilder().title("Course from DevDojo Spring Boot Microservices")
                .description("Course")
                .version("1.0")
                .contact(new Contact("Anyone", "http://devodjo.academy","email@email.com"))
                .license("Private")
                .licenseUrl("http:/devdojo.academy")
                .build();
    }
}
