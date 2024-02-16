package cl.notices.noticesapi.config;

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

@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {

        return new Docket(DocumentationType.SWAGGER_2).groupName
                        ("api").select()
                .apis(RequestHandlerSelectors
                        .basePackage("cl.notices.noticesapi"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {

        return new ApiInfoBuilder().title("API Rest Noticias")
                .description("API Rest para manager de noticias")
                .contact(new Contact("Mauricio Águila", "Desarrollador de Sistemas", "maurcio.aguila.g@outlook.com"))
                .licenseUrl("www.mipagina.cl")
                .version("1.0.0")
                .build();
    }
}
