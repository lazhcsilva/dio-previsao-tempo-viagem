package dio.tempo_diario.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Travel Weather Controller")
                        .description("API for to verify weather in the travel")
                        .version("1.0")
                        .termsOfService("Term of use: Open Source")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.test.com.br")));
    }

}
